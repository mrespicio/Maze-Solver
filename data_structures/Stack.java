/* By: Megan Respicio
   Date: October 2017
   Github: github.com/mrespicio */

package data_structures;
import java.util.Iterator;

public class Stack <E extends Comparable<E>> implements Iterable<E>{
	private LinearList<E> list;
	public Stack(){
		list = new LinearList<E>();
	}
    public void push(E obj){
    	list.addFirst(obj);
    }  
    public E pop(){
    	return list.removeFirst();
    }
    public int size(){ 
    	return list.size(); 
    } 
    public boolean isEmpty() {
    	return list.isEmpty();
    }  
    public E peek() {
    	return list.peekFirst();
    } 
    public boolean contains(E obj){
    	return list.contains(obj);
    }
    public void makeEmpty() {
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

