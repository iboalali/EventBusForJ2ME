class AlreadyRegisteredException extends RuntimeException {
    AlreadyRegisteredException(EventReceivers klass) {
        super(klass.getClass().getName() + " is already register");
    }

    AlreadyRegisteredException(EventReceivers klass, Object event) {
        super(klass.getClass().getName() + "has already registered the event " + event.getClass().getName());
    }
}
