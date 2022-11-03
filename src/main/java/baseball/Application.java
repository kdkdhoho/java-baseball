package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    String input = "";
    String answer = "";

    public void startGame() {

    }

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getInput() {
        System.out.println("숫자를 입력해주세요 : ");
        return readLine();
    }

    public String generateAnswer() {
        String answer = "";

        while(answer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String numberString = convertIntToString(randomNumber);
            if(!answer.contains(numberString)) {
                answer += numberString;
            }
        }

        return answer;
    }

    public String convertIntToString(int intValue) {
        return String.valueOf(intValue);
    }

    public boolean isValidInput(String input) {
        if(isOnlyNumber(input) && isThreeDigit(input) && isAllDifferent(input)) {
            return true;
        }
        return false;
    }

    public boolean isOnlyNumber(String input) {
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            return false;
        }
        return true;
    }

    public boolean isThreeDigit(String input) {
        if(input.length() != 3) {
            return false;
        }
        return true;
    }

    public boolean isAllDifferent(String input) {
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        if(first == second || second == third || first == third) {
            return false;
        }
        return true;
    }

    public String compareToAnswer(String input, String answer) {
        int strike = countStrike(input, answer);
        int ball = countBall(input, answer);
        return createResult(strike, ball);
    }

    public int countStrike(String input, String answer) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int countBall(String input, String answer) {
        int count = 0;
        char[] inputCharArray = input.toCharArray();
        char[] answerCharArray = answer.toCharArray();

        return count;
    }

    public String createResult(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        } else if(strike == 3) {
            return THREE_STRIKE;
        } else if (strike == 0 && ball != 0){
            return ball + BALL;
        } else if (strike != 0 && ball == 0) {
            return strike + STRIKE;
        } else {
            return (ball + BALL + " " + strike + STRIKE);
        }
    }

    public void resetGame(String answer) {
        answer = generateAnswer();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
    }
}
