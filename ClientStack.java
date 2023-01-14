public class ClientStack {
    public static void main(String[] args) {
        MyStack S = new MyStack(300);
        MyStack Se = new MyStack(200);
        Object a = new Object();
        try{
            Se.pushElement(a);
            Se.popElement(a);
            Se.popElement(a);
        } catch (Exception e) {
            System.out.println("Stack is full");
        }
         
    }
}
