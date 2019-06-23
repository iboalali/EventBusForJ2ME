import org.bouncycastle.core.main.j2me.java.util.*;

/*
 * Copyright 2019 iboalali
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * <p> Usage for posting of events:
 *
 * <p> Usage for subscriber of events:
 * <pre>
 * class TestSubscriber implements EventReceivers {
 *     TestSubscriber() {
 *         if (!EventBus.getBus().isSubscribed(this, TestEvent1.class)) {
 *             EventBus.getBus().subscribe(this, TestEvent1.class);
 *         }
 *         if (!EventBus.getBus().isSubscribed(this, TestEvent2.class)) {
 *             EventBus.getBus().subscribe(this, TestEvent2.class);
 *         }
 *     }
 *
 *     public void eventReceiver(EventObject event) {
 *         if (event.isThisEventObject(TestEvent1.class)) {
 *             // handle event
 *         } else if (event.isThisEventObject(TestEvent2.class)) {
 *             // handle event
 *         }
 *     }
 * }
 * </pre>
 */
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
                    throw new AlreadySubscribedException(klass, event);
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