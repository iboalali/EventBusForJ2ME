public abstract class EventObject {
    public boolean isThisEventObject(Class klass) {
        return this.getClass().getName().equals(klass.getName());
    }
}
