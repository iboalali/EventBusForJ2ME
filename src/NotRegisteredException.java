class NotRegisteredException extends Exception {
    NotRegisteredException(Class event) {
        super("No registered subscriber for the event " + event.getName());
    }

    NotRegisteredException(EventReceivers klass) {
        super(klass.getClass().getName() + " did not register any events");
    }

    NotRegisteredException(EventReceivers klass, Object event) {
        super(klass.getClass().getName() + " did not register " + event.getClass().getName());
    }
}
