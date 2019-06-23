import org.bouncycastle.core.main.j2me.java.util.*;

public class EventBus {

    private static volatile EventBus sInstance;
    private Map mEvents;

    public static EventBus getBus() {
        EventBus instance = sInstance;

        if (instance == null) {
            synchronized (EventBus.class) {
                instance = sInstance;

                if (instance == null) {
                    sInstance = new EventBus();
                    instance = sInstance;
                }
            }
        }

        return instance;
    }

    private EventBus() {
        mEvents = new HashMap();
    }

    /**
     * Subscribe a class to an event.
     *
     * @param klass The class to subscribe.
     * @param event The class to subscribe to.
     */
    public void subscribe(EventReceivers klass, Class event) {
        synchronized (EventBus.class) {
            if (mEvents.containsKey(klass)) {
                HashSet events = (HashSet) mEvents.get(klass);

                if (events.contains(event.getName())) {
                    throw new AlreadyRegisteredException(klass, event);
                } else {
                    events.add(event.getName());

                    mEvents.remove(klass);
                    mEvents.put(klass, events);
                }
            } else {
                HashSet events = new HashSet();
                events.add(event.getName());
                mEvents.put(klass, events);
            }
        }
    }


    /**
     * Checks if a class is subscribed to the given event.
     *
     * @param klass The class to check for.
     * @param event The event to check about.
     * @return {@code true} if the class is registered to the event.
     */
    public boolean isSubscribed(EventReceivers klass, Class event) {
        synchronized (EventBus.class) {
            if (!mEvents.containsKey(klass)) {
                return false;
            }

            HashSet events = (HashSet) mEvents.get(klass);
            return events.contains(event.getName());
        }
    }

    /**
     * Unsubscribe a class from an event bus
     *
     * @param klass The class to unsubscribe.
     * @param event The event to unsubscribe form.
     */
    public void unsubscribe(EventReceivers klass, Class event) {
        synchronized (EventBus.class) {
            if (!mEvents.containsKey(klass)) {
                try {
                    throw new NotRegisteredException(klass);
                } catch (NotRegisteredException e) {
                    e.printStackTrace();
                }
            } else {
                HashSet events = (HashSet) mEvents.get(klass);

                if (!events.contains(event.getName())) {
                    try {
                        throw new NotRegisteredException(klass, event);
                    } catch (NotRegisteredException e) {
                        e.printStackTrace();
                    }
                } else {
                    events.remove(event.getName());
                }
            }
        }
    }

    /**
     * Unsubscribe a class from all events.
     *
     * @param klass The class to unsubscribe from all events.
     */
    public void unsubscribeAll(EventReceivers klass) {
        synchronized (EventBus.class) {
            if (!mEvents.containsKey(klass)) {
                try {
                    throw new NotRegisteredException(klass);
                } catch (NotRegisteredException e) {
                    e.printStackTrace();
                }
            } else {
                mEvents.remove(klass);
            }
        }
    }

    /**
     * Post an event to all subscriber of this event.
     *
     * @param event The event to send to all subscribers.
     */
    public void post(EventObject event) {
        synchronized (EventBus.class) {
            Set keys = mEvents.keySet();
            Iterator iterator = keys.iterator();

            while (iterator.hasNext()) {
                EventReceivers key = (EventReceivers) iterator.next();
                HashSet events = (HashSet) mEvents.get(key);

                if (events.contains(event.getClass().getName())) {
                    key.eventReceiver(event);
                } else {
                    try {
                        throw new NotRegisteredException(event.getClass());
                    } catch (NotRegisteredException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}