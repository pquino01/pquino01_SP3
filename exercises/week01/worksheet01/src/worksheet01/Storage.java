package worksheet01;

/**
 *
 * @author pablo
 */
class Storage<T> {

    T x;

    public T getValue() {
        return x;
    }

    public void setValue(T value) {
        x = value;
    }
}
