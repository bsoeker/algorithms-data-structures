import java.util.StringJoiner;

public class StackQueue<T> {
    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;

    public StackQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    // [30 40 50 60]
    // []
    // [50 40 30]
    public void enqueue(T value) {
        enqueueStack.push(value);
    }

    public T dequeue() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty())
                throw new IllegalStateException("Queue is empty!");
            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
        }

        return dequeueStack.pop();
    }

    @Override
    public String toString() {
        var enqueueCopy = enqueueStack.createCopy();
        var dequeueCopy = dequeueStack.createCopy();
        if (enqueueCopy.isEmpty() && dequeueCopy.isEmpty())
            return "[ ]";

        StringJoiner joiner = new StringJoiner(", ", "[ ", " ]");

        while (!dequeueCopy.isEmpty())
            joiner.add(String.valueOf(dequeueCopy.pop()));
        while (!enqueueCopy.isEmpty())
            dequeueCopy.push(enqueueCopy.pop());
        while (!dequeueCopy.isEmpty())
            joiner.add(String.valueOf(dequeueCopy.pop()));

        return joiner.toString();
    }
}
