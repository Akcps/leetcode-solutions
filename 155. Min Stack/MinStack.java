/**
 * Runtime: 4 ms, faster than 95.65% of Java online submissions for Min Stack.
 * Memory Usage: 43 MB, less than 7.97% of Java online submissions for Min Stack.
 * Next challenges:
 */
class MinStack {
    List<List<Integer>> minStack;
    int count;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new ArrayList<>();
        count = 0;
    }

    public void push(int x) {
        List<Integer> element = new ArrayList<>();
        if (count == 0) {
            element.add(x);
            element.add(x);
        }  else {
            List<Integer> lastElement = minStack.get(count - 1);
            element.add(x);
            if (lastElement.get(1) > x) {
                element.add(x);
            } else {
                element.add(lastElement.get(1));
            }
        }
        minStack.add(element);
        count++;

    }

    public void pop() {
        if (count > 0) {
            minStack.remove(count - 1);
            count--;
        }
    }

    public int top() {
        if (count > 0) {
            return minStack.get(count - 1).get(0);
        }
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if (count > 0) {
            return minStack.get(count - 1).get(1);
        }
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */