class Book {
    public String title;
    public String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    } 
}

class Set {
    private Book[] book; 
    private int size = 0;
    private int count = 0;

    public Set(int s) {
        size = s;
        book = new Book[s];
    }

    public Boolean addBook(Book book_add) {
        if(count >= size) {
            System.out.println("Limit reached");
            return false;
        }
        for(int i = 0; i < count; i++) {
            if(book_add.author.equals(book[i].author) && book_add.title.equals(book[i].title))
                return false;
        }
        book[count] = new Book(book_add.title,book_add.author);
        count++;
        return true;
    }

    public void unionSet(Set set1, Set set2) {
            int size_union = set1.size + set2.size;
            Set unionSet = new Set(size_union);
            for(int i = 0; i < set1.count; i++) {
                unionSet.book[i] = set1.book[i];
            }
            for(int i = set1.count; i < set1.count + set2.count; i++) {
                unionSet.book[i] = set2.book[i-set1.count];
            }
            System.out.println(printSet(unionSet));           
    }

    public String printSet(Set obj_set) {
        String aux = "";
        for(int i = 0; i < obj_set.count; i++) {
            aux = aux + obj_set.book[i].title + " " + obj_set.book[i].author + "\n";
        }
        return aux;
    }

}

public class ProblemSet {
    public static void main(String[] args) {
        Set set1 = new Set(5);
        Set set2 = new Set(1);
        Book book1 = new Book("Capra cu trei iezi", "Ion Creanga");
        Book book2 = new Book("Ciresarii", "Anonim");
        Book book3 = new Book("Pacala", "Ion Creanga");

        set1.addBook(book1);
        set1.addBook(book2);
        set2.addBook(book3);
        set1.unionSet(set1, set2);
    }
}
