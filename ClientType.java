import java.util.ArrayList;
import java.util.Iterator;

abstract class Type {
    abstract public String getType();

    abstract public String toString();
}

class IntegerType extends Type {
    private int value;

    public IntegerType(int value) {
        this.value = value;
    }

    public String getType() {
        return "Type: " + getClass().getName();
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

class StringType extends Type {
    private String string;

    public StringType(String string) {
        this.string = string;
    }

    public String getType() {
        return "Type: " + getClass().getName();
    }

    public String toString() {
        return this.string;
    }
}

class ElementExistsException extends Exception{
    public ElementExistsException() {
        super("Element is already in the list");
    }
}

class CollectionType extends Type{
    ArrayList<Type> list;

    public CollectionType() {
        this.list = new ArrayList<>();
    }

    public String toString() {
        Iterator<Type> it = list.iterator();
        String aux = new String();
        while(it.hasNext()) {
            aux += it.next().toString() + " ";
        }
        return aux;
    }

    public String getType() {
        Iterator<Type> it = list.iterator();
        String aux = new String();
        aux += getClass().getName() + "(";
        while(it.hasNext()) {
            aux += it.next().toString() + " ";
        }
        aux += ")";
        return aux;
    }

    public void addElement(Object element) throws ElementExistsException{
        if(element instanceof Type) {
            if(this.list.contains(element)) {
                throw new ElementExistsException();
            }
            else if(((Type)element).toString() == null)
                    throw new IllegalArgumentException();
                else
                    this.list.add((Type)element);

        }
    }

    public boolean equals(Object o) {
        if(o instanceof CollectionType) {
            if(this.list.size() == ((CollectionType)o).list.size()) {
                for(int i = 0; i < list.size(); i++) {
                    if(this.list.get(i) == ((CollectionType)o).list.get(i))
                        ;
                    else
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}

public class ClientType {
    public static void main(String[] args) {
        Type t1 = new IntegerType(10);
        Type t2 = new StringType(null);
        Type t3 = new IntegerType(20);
        Type t4 = new StringType("Hello");

        CollectionType c1 = new CollectionType();

        try {
            c1.addElement(t1);
        } catch (ElementExistsException eee) {
            System.out.println(eee.getMessage());
        }

        try {
            c1.addElement(t2);
        } catch (ElementExistsException eee) {
            System.out.println(eee.getMessage());
        }

        try {
            c1.addElement(t3);
        } catch (ElementExistsException eee) {
            System.out.println(eee.getMessage());
        }

        System.out.println(c1.getType());
        t1.getType();
        
        CollectionType c2 = new CollectionType();

        try {
            c2.addElement(t1);
        } catch (ElementExistsException eee) {
            System.out.println(eee.getMessage());
        }

        try {
            c2.addElement(t4);
        } catch (ElementExistsException eee) {
            System.out.println(eee.getMessage());
        }

        try {
            c2.addElement(t2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        

        System.out.println(c1.toString());

        System.out.println(c2.toString());

        System.out.println(c1.equals(c2));

        
    }
}
