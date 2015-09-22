package coursera.collection;

/**
 * Created by milanashara on 22/9/2015.
 */
public class ResizingArrayQueueOfStrings {
    private String[] s;
    private int N = 0;
    private int front = -1;
    private int rear = -1;

    public ResizingArrayQueueOfStrings() {
        s = new String[1];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < s.length; i++)
            copy[i] = s[i];
        s = copy;
    }


    public void enqueue(String item) {
        if ((rear + 1) % s.length == front) {
            //throw new IllegalStateException("Queue is full");
            resize(2 * s.length);//increase size
        } else if (isEmpty()) {
            front++;
            rear++;
            s[rear] = item;

        } else {
            rear = (rear + 1) % s.length;
            s[rear] = item;

        }
    }

    public int size() {
        return Math.abs(front - rear + 1);
    }

    public String dequeue() {
        String value = null;
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cant dequeue");
        } else if (front == rear) {
            value = s[front];
            front = -1;
            rear = -1;

        } else {

            if (size() == s.length / 4) resize(s.length / 2);//shrink

            value = s[front];
            front = (front + 1) % s.length;

        }
        return value;
    }
}
