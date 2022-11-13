class Text {
    private static String[] words;
    private static int[] index;
    private static int size = 0;
    private static int count = 0;

    public Text() {
        size = 2;
        words = new String[size];
        index = new int[size];
    }

    public Boolean getWord(String w) {
        for(int i = 0; i < size; i++) {
            if(w.equals(words[i])) {
                index[i]++;
                return true;
            }       
        }

        if(count >= size) {
            System.out.println("Cannot add word.");
            return false;
        }

        words[count] = w;
        index[count] = 1;
        count++;
        return true;
    }

    public String toString() {
        String aux = "";
        for(int i = 0; i < count; i++) {
            aux = aux + words[i] + " " + index[i] + "\n";
        }
        return aux;
    }

}

class ProblemText {
    public static void main(String[] args) {
        Text text = new Text();
        text.getWord("word1");
        text.getWord("word2");
        text.getWord("word1");
        text.getWord("word2");
        text.getWord("word3");
        System.out.println(text);
    }   
}
