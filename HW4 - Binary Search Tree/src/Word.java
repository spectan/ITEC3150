/**
 * Simple word class so we can store a count and a string.
 * @author - Samuel Mckinney
 */
public class Word implements Comparable<Word> {

    //Attributes
    protected String word;
    protected int count;

    /**
     * Word object constructor
     * @param word
     * @param count
     */
    public Word(String word) {
        this.word = word;
        this.count = 1;
    }
    /**
     * Increment Count simply increeases the count by one
     */
    public void incrementCount() {
        //System.out.println(this.count);
        this.count = this.count +1;
    }
    /**
     * getters for the attributes
     * @return
     */
    public String getWord() {
        return word;
    }
    public int getCount() {
        return count;
    }

    /**
     * Setters for the attributes
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public int compareTo(Word w) {
        // TODO Auto-generated method stub
        return this.word.compareTo(w.word);
    }
    @Override
    public String toString() {
        return word + ", count=" + count;
    }
}
