import java.util.*;

public class MyStack {
    ArrayList<Object> stack = new ArrayList<>();
    private int MAX_ELEMENTS;
    private int count = 0;

    public MyStack(int size) throws SizeOverflow{
        if(size >= 500)
            throw new SizeOverflow();
        MAX_ELEMENTS = size;
    }

    public void pushElement(Object element) throws StackFull{
        if(count >= MAX_ELEMENTS)
            throw new StackFull();
        stack.add(element);
    }

    public void popElement(Object element) throws StackEmpty{
        if(count == 0)
            throw new StackEmpty();
        stack.remove(element);
    }
}
