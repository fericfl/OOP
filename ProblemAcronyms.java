class Acronyms {
    private static String[] words;
    private static String[] acr;
    private static int size = 0;
    private static int count = 0;

    public Acronyms() {
        size = 1;
        words = new String[size];
        acr = new String[size];    
    }

    public Boolean getWord(String word_add, String acr_add) {
        for(int i = 0; i < count; i++) {
            if(word_add.equals(words[i])) {
                acr[i] = acr_add;
                return true;
            }
        }
        if(count >= size){
            System.out.println("Size exceeded");
            return false;
        }
        
        words[count] = word_add;
        acr[count] = acr_add;
        count++;
        return true;
    }

    public String printAcr(String Acr) {
        String aux= "";
        for(int i = 0; i < count; i++) {
            if(acr[i].equals(Acr) == true) {
                aux = aux + words[i] + "\n";
            }
        }
        if(aux.equals("") == true)
            return "XXXX";
        return aux;
    }

}

class ProblemAcronyms {
    public static void main(String[] args) {
        Acronyms text = new Acronyms();
        text.getWord("word1","abc");
        text.getWord("word2","abc");
        text.getWord("word1","nice");
        text.getWord("word2","abc");
        text.getWord("word3","nice");
        System.out.println(text.printAcr("nice"));
    }
}