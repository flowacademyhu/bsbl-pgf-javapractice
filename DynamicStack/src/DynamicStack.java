public class DynamicStack {

    private class Node {
        int value;
        Node previous = null;

        public Node(int value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    private Node actual = null;
    private Node tail = null;
    private int counter = 0;

    public boolean isEmpty() {
        return tail == null;
    }

    public void push(int value) {
        tail = new Node(value, tail);
        actual = tail;
        counter++;
    }

    public int pop() {
        if(!isEmpty()) {
            counter--;
            int popped = tail.value;
            tail = tail.previous;
            actual = tail;
            return popped;
        }
        return 0;
    }

    public String toString() {
        if(!isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i = 0; i < counter - 1; i++) {
                sb.append(actual.value).append(", ");
                actual = actual.previous;
            }
            sb.append(actual.value).append("]");
            actual = tail;
            return sb.toString();
        }
        return "";
    }

    public int getSize() {
        return counter;
    }

    public static void main(String[] args) {
        DynamicStack ds = new DynamicStack();

        ds.push(4);
        ds.push(75);
        ds.push(35);
        ds.push(9);
        ds.push(91);
        System.out.println(ds.toString());
        System.out.println(ds.getSize());
        ds.pop();
        ds.pop();
        System.out.println(ds.toString());
    }
}
