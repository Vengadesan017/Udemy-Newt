package project.quiz_game;

public class Start {
    public static void main(String[] args) {

        QuestionService questionService = new QuestionService();
        questionService.playQuiz();
        questionService.printScore();
    }
}
