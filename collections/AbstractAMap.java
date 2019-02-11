package collections;

public abstract class AbstractAMap<K,V> implements AMap<K,V> {

    public boolean isEmpty() {
        return size()==0;
    }

    public boolean containsKey(K k) {
        return get(k)!=null;
    }
}
