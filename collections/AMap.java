package collections;

public interface AMap<K,V> {
    V put(K k, V v);

    V get (K k);

    int size();

    int capacity();

    boolean containsKey(K k);

    boolean isEmpty();

    public static interface Entry<K,V>{
        K getKey();
        V getValue();
    }

}
