package data_structures;
/*  
 Program #2
 Megan Respicio
 cssc0935
*/

//package data_structures;

import java.util.Iterator;

public class Queue <E extends Comparable<E>> implements Iterable<E>{
	private LinearList<E> list; 
	public Queue(){
		list = new LinearList<E>();
	}
    public void enqueue(E obj){
    	list.addLast(obj); 
    }  
    public E dequeue(){
    	return list.removeFirst(); 
    } 
    public int size(){
    	return list.size();
    }
    public boolean isEmpty(){
    	return list.isEmpty();
    } 
    public E peek(){
    	return list.peekFirst();
    }   
    public boolean contains(E obj){
    	return list.contains(obj);
    }  
    public void makeEmpty(){
    	list.clear();
    } 
    public boolean remove(E obj){
    	if(list.remove(obj) != null)
    		return true;
    	return false;
    }  
    public Iterator<E> iterator(){
    	return list.iterator();
    }
} 