// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iter;
    boolean noSuchElement;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        moveIterator();
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
         return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (noSuchElement)
            throw new NoSuchElementException();
        Integer res = next;
        moveIterator();
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !noSuchElement;
	}
    
    private void moveIterator(){
        if(iter.hasNext()){
            next = iter.next();
        } else {
            noSuchElement = true;
        }
    }
}