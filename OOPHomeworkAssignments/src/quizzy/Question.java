package quizzy;
public class Question {

    // Variables
    private String question;
    private String answer; 
    private String a, b, c, d;

    // Getters and setters 
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }
    
    // Default Constructor 
    public Question() {
        question = "";
        answer = "";
        a = "";
        b = "";
        c = "";
        d = "";
    }
    // Non-default Constructor 
    public Question(String question, String answer, String a, String b, String c, String d) {
        setQuestion(question);
        setAnswer(answer);
        setA(a);
        setB(b);
        setC(c);
        setD(d);
    }
    // Overriding the toString method 
    @Override 
    public String toString() {
        return String.format("%s\n\t%s\n\t%s\n\t%s\n\t%s", question, a, b, c, d);
    }
}
