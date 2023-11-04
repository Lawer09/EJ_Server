package Collections;

import MObject.Object;

import java.util.HashMap;

public class JMap<K,V> extends HashMap<K,V> {

    public JMap()
    {
        super();
    }

    public V Get(Object object)
    {
        return super.get(object);
    }

    public V Put(K key, V value)
    {
        return super.put(key,value);
    }

    public V Remove(K key)
    {
        return super.remove(key);
    }

}
