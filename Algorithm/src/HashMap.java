
 
/**
 * Generic Implementation of Map
 * @author Milan
 *
 */

public class HashMap<K,V> {

	// for simplicity size is taken as 2^4
    private static final int SIZE = 16;
    private Entry<K,V> table[] = new Entry[SIZE];
 
    /**
     * User defined simple Map data structure
     * with key and value.
     * This is also used as linked list in case multiple
     * key-value pairs lead to the same bucket with same
     * hashcodes and different keys (collisions) using
     * pointer 'next'.
     *
     * @author Milan
     */
    class Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next;
 
        Entry(K k, V v) {
            key = k;
            value = v;
        }
 
        public V getValue() {
            return value;
        }
 
        public void setValue(V value) {
            this.value = value;
        }
 
        public K getKey() {
            return key;
        }
    }
 
    /**
     * Returns the entry associated with the specified key in the
     * HashMap.  Returns null if the HashMap contains no mapping
     * for the key.
     */
    public V get(String k) {
        int hash = k.hashCode() % SIZE;
        Entry<K,V> e = table[hash];
 
        // if bucket is found then traverse through the linked list and
        // see if element is present
        while(e != null) {
            if(e.key.equals(k)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }
 
    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    public void put(K k, V v) {
        int hash = k.hashCode() % SIZE;
        Entry<K,V> e = table[hash];
        if(e != null) {
            // it means we are trying to insert duplicate
            // key-value pair, hence overwrite the current
            // pair with the old pair
            if(e.key.equals(k)) {
                e.value = v;
            } else {
                // traverse to the end of the list and insert new element 
                // in the same bucket
                while(e.next != null) {
                    e = e.next;
                }
                Entry<K,V> entryInOldBucket = new Entry<K,V>(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            // new element in the map, hence creating new bucket
            Entry<K,V> entryInNewBucket = new Entry<K,V>(k, v);
            table[hash] = entryInNewBucket;
        }
    }
 
    // for testing our own map
    public static void main(String[] args) {
        HashMap<String,Integer> tmhm = new HashMap<String,Integer>();
 
        tmhm.put("Niranjan", 0);
        tmhm.put("Ananth", 0);
        tmhm.put("Niranjan", 1);
        tmhm.put("Chandu", 5);
 
        Integer value = tmhm.get("Niranjan");
        System.out.println(value);
    }
}