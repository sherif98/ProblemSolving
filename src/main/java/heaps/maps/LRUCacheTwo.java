package heaps.maps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheTwo {

    private Cache<Integer, Integer> lru;

    public LRUCacheTwo(int capacity) {
        lru = new Cache<>(capacity);
    }

    public int get(int key) {
        if (lru.get(key) != null) {
            return lru.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        lru.set(key, value);
    }
}

class Cache<K, V> {

    private final Map<K, Node> map;
    private final LinkedList<Node> list;
    private final int capacity;

    public Cache(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.val;
    }

    public void set(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            list.remove(node);
            list.addFirst(node);
            return;
        }
        if (map.size() == capacity) {
            Node node = list.removeLast();
            map.remove(node.key);
        }
        Node node = new Node();
        node.key = key;
        node.val = value;
        list.addFirst(node);
        map.put(key, node);
    }


    class Node {
        K key;
        V val;
    }
}