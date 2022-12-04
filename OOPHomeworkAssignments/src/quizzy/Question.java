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
    public Question(String question, String answer, String a, String b, String c) {
        setQuestion(question);
        setAnswer(answer);
        setA(a);
        setB(b);
        setC(c);
    }
    // Overriding the toString method 
    @Override 
    public String toString() {
        // I added a second string for the scenarios where there are only options A-C, not A-D, this way it avoids printing an empty space or "null"
        if (getD() != null) {
            return String.format("%s\nA.\t%s\nB.\t%s\nC.\t%s\nD.\t%s", question, a, b, c, d);
        } else {
            return String.format("%s\nA.\t%s\nB.\t%s\nC.\t%s", question, a, b, c);
        }
    }
}
