/**
 * Runtime: 8 ms, faster than 96.46% of Java online submissions for Design Linked List.
 * Memory Usage: 46.2 MB, less than 77.78% of Java online submissions for Design Linked List.
 */
class MyLinkedList {
    Node head;
    Node tail;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node cur = head;
        int i = 0;
        while ( i != index ) {
            cur = cur.next;
            i++;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= size) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node cur = head;
                int i = 0;
                while (i != index - 1) {
                    cur = cur.next;
                    i++;
                }
                Node newNode = new Node(val);
                newNode.next = cur.next;
                cur.next = newNode;
                size++;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < size) {
            if (index == 0) {
                head = head.next;
            } else if (index == size - 1) {
                Node cur = head;
                int i = 0;
                while (i != index - 1) {
                    cur = cur.next;
                    i++;
                }
                cur.next = null;
                tail = cur;
            } else {
                Node cur = head;
                int i = 0;
                while (i != index - 1) {
                    cur = cur.next;
                    i++;
                }
                cur.next = cur.next.next;
            }
            size--;
        }
    }


    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */