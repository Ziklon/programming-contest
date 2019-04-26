package net.egork.collections.map;

import java.util.TreeMap;

/**
 * @author Egor Kulikov (egor@egork.net)
 */
public class TreeCounter<K> extends TreeMap<K, Long> {
    public TreeCounter() {
        super();
    }

    public void add(K key) {
        put(key, get(key) + 1);
    }

    public Long removeOne(K key) {
        return remove(key, 1L);
    }

    public Long remove(K key, Long delta) {
        if (!containsKey(key)) {
            return -1L;
        }
        Long curVal = get(key) - delta;
        if (curVal <= 0L) {
            remove(key);
        } else {
            put(key, curVal);
        }
        return curVal;
    }

    public void add(K key, Long delta) {
        put(key, get(key) + delta);
    }

    @Override
    public Long get(Object key) {
        if (containsKey(key)) {
            return super.get(key);
        }
        return 0L;
    }
}
