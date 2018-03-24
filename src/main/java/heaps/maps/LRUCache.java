package heaps.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LRU lru;

    public LRUCache(int capacity) {
        lru = new LRU(capacity);
    }

    public int get(int key) {
        return lru.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        lru.put(key, value);
    }
}

class LRU extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRU(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return this.size() > capacity;
    }
}
