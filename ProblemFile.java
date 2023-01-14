interface Item {
    public String getContent();

}

class File implements Item {   
    private String information;

    public File(String information) {
        this.information = information;
    }

    public String getContent () {
        return information;
    }
}

class Folder implements Item {
    private Item[] entries;
    private String information = "";
    private int count = 0;
    private int size;

    public Folder(int size) {
        this.size = size;
        entries = new Item[size];
    }

    public void addElement(Item element) {
        if(count >= size)
            System.out.println("Cannot add element " + element.getContent());
        else {
            entries[count] = element;
            count++;
        }
    }
    public String getContent() {
        String aux = "";
        for(int i = 0; i < count; i++) {
            aux += entries[i].getContent() + " ";
        }
        return aux;
    }
}


public class ProblemFile {
    public static void main(String[] args) {
        File file1 = new File("File1");
        Folder folder1 = new Folder(2);
        folder1.addElement(file1);
        Folder folder2 = new Folder(2);
        folder1.addElement(folder2);
        File file2 = new File("File2");
        folder2.addElement(file2);
        File file3 = new File("File3");
        folder2.addElement(file3);
        Folder folder3 = new Folder(1);
        folder2.addElement(folder3);
        System.out.println(folder1.getContent());
    }    
}
