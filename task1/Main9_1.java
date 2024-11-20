import ru.isys.trainings.task1.LanguageException;

import java.util.Scanner;
public class Main9_1 {
    public static void main(String[] args) throws LanguageException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter lower bound");
        int lower_bound = scanner.nextInt();
        System.out.println("enter upper bound");
        int upper_bound = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character

        int range = upper_bound - lower_bound + 1;
        int guess_1 = (int) (Math.random() * range) + lower_bound;
        int guess = guess_1;
        int answer = 0;
        String input = "";
        Guess guessObj = new Guess(-1, -1, range, lower_bound, upper_bound);




        do { //start cycle here

            System.out.println(guess);
            System.out.println("is my guess less, equal or greater than the number you guessed? ");
            input = scanner.nextLine();

                if (!Guess.valid(input)){
                    throw new LanguageException("type 'greater' ,'less' or 'equal' ");
                }


                if (input.equals(sign.less.getInput())) {
                    answer = 0;
                } else if (input.equals(sign.greater.getInput())) {
                    answer = 1;
                } else if (input.equals("equal")) {
                    System.out.println("yay");
                    return;
                } else {
                    System.err.println("no");
                    break;
                }
                guess = guessObj.methodGuess(answer, guess);

                //update guess here



        }while (!input.equals("equal"));
    }
    enum sign {
        greater("greater"),
        less("less");

        private String input;
        sign(String input) {
            this.input = input;
        }

        // Getter to retrieve activity
        public String getInput() {
            return input;
        }


    }

}
class Guess {
    public int regected_plus;
    public int regected_minus;
    private int range;
    private int lower_bound;
    private int upper_bound;

    public Guess(int regected_plus, int regected_minus, int range, int lower_bound, int upper_bound) {
        this.regected_plus = regected_plus;
        this.regected_minus = regected_minus;
        this.range = range;
        this.lower_bound = lower_bound;
        this.upper_bound = upper_bound;

    }

    public int methodGuess(int answer, int guess) {
        if (regected_plus == -1 || regected_minus== -1){
            regected_plus= upper_bound;
            regected_minus= lower_bound;
        }
        if (answer == 1) {
            regected_plus = guess;
        } else{
            regected_minus = guess;
        }
        range = regected_plus - regected_minus + 1;
        int a= (int)(Math.floor((Math.random() * range)));

        if(a==0){
            a=1;
        } //this ensures that the new guess can't be equal to the old guess (difference can't be 0)
        guess = guess + (int)(Math.pow(-1, answer)) * a;
        return guess;
    }


    public static boolean valid(String input) {
        for (Main9_1.sign s: Main9_1.sign.values()){
            if (s.name().equals(input)){
                return true;
            }
        }
        return false;
    }

}

