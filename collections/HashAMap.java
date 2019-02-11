package collections;

import java.util.HashSet;
import java.util.Set;

public class HashAMap<K,V> extends AbstractAMap<K,V> {

    public static final int INITIAL_CAPACITY = 16;
    public static final float LOAD_FACTOR = 0.75f;

    int size;
    private float loadFactor = LOAD_FACTOR;
    private int capacity = INITIAL_CAPACITY;
    private AEntry<K,V> entries[];

    public HashAMap() {
        this.entries = new AEntry[capacity];
    }

    class AEntry<K,V> implements Entry<K, V> {

        K key;
        V value;

        AEntry <K,V> next;

        public void setKey(K key) {
            this.key = key;
        }

        public AEntry<K, V> getNext() {
            return next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(AEntry<K, V> next) {
            this.next = next;
        }

        public AEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    @Override
    public V put(K k, V v) {
        return putEntry(new AEntry<>(k,v));
    }

    @Override
    public boolean containsKey(K k) {
        return super.containsKey(k);
    }

    private V putEntry(AEntry entry){
        K key = (K)entry.key;
        V value = (V) entry.value;
        int position = Math.abs(key.hashCode() % capacity);
//        AEntry<K, V> kvaEntry = new AEntry<>(k,v);
        AEntry<K,V> current = entries[position];

        if(entries[position]==null){
            entries[position]=entry;
            size++;
        } else{

            while(current!=null){
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    return value;
                } else {
                    current = current.getNext();
                }
            }
        }

        entry.setNext(entries[position]);
        entries[position] = entry;
        size++;
        return value;
    }

    @Override
    public V get(K k) {
        int position = Math.abs(k.hashCode()%capacity);
        AEntry<K, V> current = entries[position];
        while(current!=null){
            if (current.getKey().equals(k)) {
                return current.getValue();
            } else  {
                current = current.getNext();
            }
        }
        //TODO
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    public Set<AEntry> getEntries() {
        Set <AEntry> entrySet = new HashSet<>();
        for (AEntry<K,V> entry: entries){
            while(entry!=null){
                entrySet.add(entry);
                entry = entry.next;

            }
        }
        return entrySet;
    }

    private boolean checkOverload(){
        return size>=loadFactor*capacity;
    }

    private void tryResize(){
        if (checkOverload()){
            capacity*=2;
            size=0;
            entries = new AEntry[capacity];
            Set<AEntry> entriesSet = getEntries();
           for(AEntry entry:entriesSet){
               putEntry(entry);
            }

        }
    }
}
