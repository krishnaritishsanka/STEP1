abstract class Question {

    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    abstract String getType();
}

class MCQQuestion extends Question {

    MCQQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {

    TFQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    EssayQuestion(
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(correctAnswer, studentAnswer, points);
    }

    @Override
    double calculateScore() {

        String[] keywords =
                correctAnswer.split(",");

        int matched = 0;

        String answer =
                studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            if (answer.contains(
                    keyword.trim().toLowerCase())) {

                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }

    @Override
    String getType() {
        return "ESSAY";
    }
}

public class ExamTest {

    public static void main(String[] args) {

        Question[] questions = {

            new MCQQuestion(
                "Paris",
                "Paris",
                10
            ),

            new TFQuestion(
                "False",
                "True",
                5
            ),

            new EssayQuestion(
                "Inheritance, Polymorphism, Encapsulation",
                "Polymorphism is one.",
                20
            ),

            new EssayQuestion(
                "Abstraction, Composition",
                "I talked about abstraction.",
                15
            )
        };

        double total = 0;

        for (Question question : questions) {

            double score =
                    question.calculateScore();

            System.out.printf(
                "%s: %.2f%n",
                question.getType(),
                score
            );

            total += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            total
        );
    }
}