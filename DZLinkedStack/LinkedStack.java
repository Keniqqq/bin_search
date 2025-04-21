public class LinkedStack {
    private Node tail;
    private int size;

    public void push(int value) {
        Node node = new Node(value);
        if (tail != null) {
            node.setPrev(tail);
        }
        tail = node;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = tail.getValue();
        tail = tail.getPrev();
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "EMPTY";
        }

        StringBuilder sb = new StringBuilder();
        Node current = tail;

        while (current != null) {
            sb.append(current.getValue());
            if (current.getPrev() != null) {
                sb.append(" -> ");
            }
            current = current.getPrev();
        }

        return sb.toString();
    }
}
