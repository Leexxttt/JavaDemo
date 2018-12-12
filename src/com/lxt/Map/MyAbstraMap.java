package com.lxt.Map;

public abstract class MyAbstraMap<K, V> implements MyMap<K, V> {

    protected MyAbstraMap() {
    }

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsValue(Object value) {
        MyIterator<MyEntry<K, V>> i = entrySet().iterator();
        if (value == null) {
            while (i.hasNext()) {
                MyEntry<K, V> next = i.next();
                if (next.getValue() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                MyEntry<K, V> next = i.next();
                if (value.equals(next.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsKey(Object key) {
        MyIterator<MyEntry<K, V>> i = entrySet().iterator();
        if (key == null) {
            while (i.hasNext()) {
                MyEntry<K, V> next = i.next();
                if (next.getKey() == null) {
                    return true;
                }
            }
        } else {
            while (i.hasNext()) {
                MyEntry<K, V> next = i.next();
                if (key.equals(next.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    public V get(Object key) {
        MyIterator<MyEntry<K, V>> i = entrySet().iterator();
        if (key == null) {
            while (i.hasNext()) {
                MyEntry<K, V> next = i.next();
                if (next.getKey() == null) {
                    return next.getValue();
                }
            }
        } else {
            while (i.hasNext()) {
                MyEntry<K, V> next = i.next();
                if (key.equals(next.getKey())) {
                    return next.getValue();
                }
            }
        }
        return null;
    }

    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public V remove(Object key) {
        MyIterator<MyEntry<K, V>> i = entrySet().iterator();
        //用来存放ky对应的Entry
        MyEntry<K, V> correctEntry = null;
        if (key == null) {
            while (i.hasNext() && correctEntry == null) {
                MyEntry<K, V> next = i.next();
                if (next.getKey() == null) {
                    //将这个Entry赋值给我们声明出来的那个
                    correctEntry = next;
                }
            }
        } else {
            while (correctEntry == null && i.hasNext()) {
                MyEntry<K, V> next = i.next();
                if (key.equals(next.getKey())) {
                    correctEntry = next;
                }
            }
        }
        V oldValue = null;
        if (correctEntry != null) {
            //返回值是对应的这个key的value
            oldValue = correctEntry.getValue();
            i.remove();//UnsupportedOperationException
        }
        return oldValue;
    }

    public void putAll(MyMap<? extends K,? extends V> m){
        //
        MySet<? extends MyEntry<? extends K, ? extends V>> myEntryMySet = m.entrySet();
        /**
         * 1.5之后可以使用foreach TODO 需要看一下 是怎么支持foreach
         */
        MyIterator<? extends MyEntry<? extends K, ? extends V>> iterator = myEntryMySet.iterator();
        while (iterator.hasNext()){
            put(iterator.next().getKey(),iterator.next().getValue());
        }
    }
    public void clear(){
        entrySet().clear();
    }


    public abstract MySet<MyEntry<K, V>> entrySet();


}
