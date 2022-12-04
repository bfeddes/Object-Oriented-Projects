package quizzy;
/****QUESTION ANSWERS*****
 * 1. (c)
 * 2. (c)
 * 3. (b)
 * 4. (b)
 * 5. (b)
 * 6. (d)
 * 7. (c)
 * 8. (a)
 * 9. (c)
 * 10. (b)
 * 11. (a)
 * 12. (c)
 * 13. (d)
 * 14. (a)
 */
public class App {
    public static void main(String[] args) {
        Question question = new Question();
        QuizFrame frm = new QuizFrame(question);
        frm.setVisible(true);
    }
}
