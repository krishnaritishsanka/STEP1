import java.util.Arrays;

class ScoreCurve {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + bonus;
        }
    }
}

public class ScoreCurveTest {
    public static void main(String[] args) {

        int[] scores = {70, 85, 60};

        ScoreCurve.curveScores(scores, 10);

        System.out.println(Arrays.toString(scores));
    }
}