public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] buckets;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public V put(K key, V value) {
        if ((double) size / capacity > LOAD_FACTOR) {
            resize();
        }

        int idx = hash(key);
        Entry<K, V> head = buckets[idx];

        for (Entry<K, V> cur = head; cur != null; cur = cur.getNext()) {
            if (cur.getKey().equals(key)) {
                V oldValue = cur.getValue();
                cur.setValue(value);
                return oldValue;
            }
        }

        Entry<K, V> newEntry = new Entry<>(key, value, head);
        buckets[idx] = newEntry;
        size++;
        return null;
    }

    public V get(K key) {
        int idx = hash(key);
        Entry<K, V> head = buckets[idx];

        for (Entry<K, V> cur = head; cur != null; cur = cur.getNext()) {
            if (cur.getKey().equals(key)) {
                return cur.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int idx = hash(key);
        Entry<K, V> head = buckets[idx];
        Entry<K, V> prev = null;

        for (Entry<K, V> cur = head; cur != null; cur = cur.getNext()) {
            if (cur.getKey().equals(key)) {
                if (prev == null) {
                    buckets[idx] = cur.getNext();
                } else {
                    prev.setNext(cur.getNext());
                }
                size--;
                return cur.getValue();
            }
            prev = cur;
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


    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        Entry<K, V>[] newBuckets = new Entry[newCapacity];
        
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> head = buckets[i];
            while (head != null) {
                Entry<K, V> next = head.getNext();
                int newIdx = Math.abs(head.getKey().hashCode()) % newCapacity;
                
                head.setNext(newBuckets[newIdx]);
                newBuckets[newIdx] = head;
                
                head = next;
            }
        }
        
        this.buckets = newBuckets;
        this.capacity = newCapacity;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry<K, V> head = buckets[i];
            while (head != null) {
                System.out.print(head + " -> ");
                head = head.getNext();
            }
            System.out.println("null");
        }
    }

    public int getCapacity() {
        return capacity;
    }
}