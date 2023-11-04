package Collections;

import java.util.Stack;

public class JStack<T> extends Stack<T> {

    public JStack()
    {
    super();
    }

    public void Push(T t)
    {
        super.push(t);
    }

    public T Pop()
    {
        return super.pop();
    }

    public T Peek()
    {
        return super.peek();
    }
}
