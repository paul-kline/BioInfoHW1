/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics1;

/**
 *
 * @author paulkline
 */
public class Pair <K,V> {
    K key;
    V val;

    public Pair(K k, V v) {
        key = k;
        val = v;
    }
   
    public K getKey(){
        return key; 
    }
    public V getValue(){
        return val;
    }
}
