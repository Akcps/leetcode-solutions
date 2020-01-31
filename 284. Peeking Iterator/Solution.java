// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

/**
 * Runtime: 4 ms, faster than 99.87% of Java online submissions for Peeking Iterator.
 * Memory Usage: 38 MB, less than 5.00% of Java online submissions for Peeking Iterator.
 */
class PeekingIterator implements Iterator<Integer> {
    private Integer num;
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.num = null;
        this.iterator = iterator;
        hasNext();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return num;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (num != null) {
            int temp = num;
            num = null;
            hasNext();
            return temp;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (num != null) {
            return true;
        } else if (iterator.hasNext()) {
            num = iterator.next();
            return true;
        } else  {
            num = null;
            return false;
        }
    }
}