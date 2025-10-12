public class HashTable<K, V> {
    private Entry<K, V>[] buckets;
    private int capacity = 10; 
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = (Entry<K, V>[]) new Entry[capacity];
    }

    private int indexFor(K key) {  
        return Math.abs(key.hashCode() % capacity);
    }

    public V put(K key, V value) {
        int idx = indexFor(key);
        Entry<K, V> head = buckets[idx];


        for (Entry<K, V> cur = head; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                V old = cur.value;
                cur.value = value;
                return old;
            }
        }

        // Insertar nuevo nodo al inicio de la lista
        Entry<K, V> newEntry = new Entry<>(key, value, head);
        buckets[idx] = newEntry;
        size++;
        return null;
    }

    public V get(K key) {
        int idx = indexFor(key);
        for (Entry<K, V> cur = buckets[idx]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int idx = indexFor(key);
        Entry<K, V> cur = buckets[idx];
        Entry<K, V> prev = null;

        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) {
                    buckets[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("[" + i + "]: ");
            Entry<K, V> cur = buckets[i];
            while (cur != null) {
                System.out.print(cur.key + "=" + cur.value + " -> ");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }
}
