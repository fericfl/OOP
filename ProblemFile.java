class File { 
    private String information;
    private String name;

    public File(String info, String n) {
        information = info;
        name = n;
    }

    public String getContent() {
        return information + name;
    }
    
    public String toString() {
        return information;
    }
} 

class Folder {
    private File[] entries;
    private static int index = 0;
    private static int size;
    private static int flag = 0;

    public Folder(int s) {
        size = s;
        entries = new File[size];
    }

    public void getEntry(File file) {
            if (index >= size) {
                System.out.println("Cannot add any more elements!");
            }
            else {
                flag = 1;
                for (int i = 0; (i < index) && (flag != 0) ; i++) {
                    if(entries[i] == file) {
                        flag = 0;
                        System.out.println("Element " + entries[i].toString() +  " is already added in the folder. Aborting action...");
                    }
                }
                if(flag != 0){
                    entries[index] = file;
                    index++;
                }
            }
        }

    public void getContent() {
        String aux = "";
        for(int i = 0; i < index; i++) {
            aux = aux + entries[i].getContent() + " || ";
        }
        System.out.println(aux);
    }


}

class ProblemFile {
    public static void main(String[] args) {
        File f1 = new File("test1","Andrei");
        File f2 = new File("test2","Alex");
        File f3 = new File("test3","Andar");

        Folder f = new Folder(4);
        f.getEntry(f1);
        f.getEntry(f2);
        f.getEntry(f3);
        f.getContent();
    }
}