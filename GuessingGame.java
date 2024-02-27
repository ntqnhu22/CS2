import java.util.Random;
import java.util.Scanner;

public class GuessingGame{
    /**
     * The random number generator.  DO NOT CHANGE
     */
    public static Random randomNumber = new Random();

    /**
     * Scanner to get user input.  DO NOT CHANGE
     */
    public static Scanner input = new Scanner(System.in);
        
    /**
     * Asks user if they want to play
     * @return True if player wants to play again
     */ 
    public static boolean wantToPlayAgain(){
        System.out.print("Do you want to play again? (Y/N)");
        String x = input.nextLine();
        if (x.equalsIgnoreCase("Y")){
            return true;
        }
        else if (x.equalsIgnoreCase("N")){
            return false;
        }
        else{
            return wantToPlayAgain();
        }
    }

    /**
     * Generates new random number between 1 and 100
     * 
     * @return new secret number
     */
    public static int generateSecretNumber(){
        return randomNumber.nextInt(100)+1;
    }

    /**
     * Play one iteration of the game.  This method creates a new secret number
     * and prompts the user to keep guessing until the guess is correct.
     * 
     * The user is prompted for a number and you need to read in the next input (hint: use the Scanner).
     * It should use isQuit, checkGuess, and generateSecretNumber.
     * 
     * @return False if the user quits
     */
    public static boolean playOneGame(){
        int  mysteryNumber = generateSecretNumber();
        int times = 0;
        while (true){
            System.out.print("Please enter a number from 1 to 100 (or q to quit):");
            String useinput = input.nextLine();
            if (isQuit(useinput)){
                System.out.println("Mystery number was" + mysteryNumber);
                System.out.println("Thank you for playing. Bye");
                return false;
            }else{
                try {
                    times += 1;
                    int guess = Integer.parseInt(useinput);
                    if (checkGuess(mysteryNumber, guess)){
                    System.out.println("That's correct. It took you" + " " + times + " " + "guess");
                    return true;
                    }  
                }
            
        catch (NumberFormatException e) {
            if (!useinput .equalsIgnoreCase ("q")){
                System.out.println("Invalid input. Enter a valid number or 'q' to quit.");
            }
        }
        }  
    }
}

    /**
     * Check whether guess is correct or not and report whether it is too high or too low.
     * This assumes that the guess has been confirmed to be valid.
     * 
     * If too high, prints 'too high' and returns false
     * If too low, prints 'too low' and returns false
     * 
     * @param mysteryNumber the secret number that the user is trying to guess
     * @param guess the user's guess 
     * @return True if the guess is correct
     */
    public static boolean checkGuess(int mysteryNumber, int guess){
        if (guess == mysteryNumber){
            System.out.println("Correct");
            return true;
        }
        else if (guess > mysteryNumber) {
            System.out.println("Incorrect, too high");
            return false;
        }
        else {
            System.out.println("Incorrect, too low");
            return false;
        }
    }

    /**
     * Checks if the player's input indiates they want to quit.
     * @param guess
     * @return True if input is "q" or "Q"
     */
    public static boolean isQuit(String guess){
        if (guess.equals("q")){
            return true;
        }
        else if (guess.equals("Q")){
            return true;
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args)throws Exception{
        // TODO: write the main loop
        //  You should use the above methods in writing your loop.
        while (true) {
            boolean playgame = playOneGame();
            if (!playgame || !wantToPlayAgain()){
                break;
            }
        }
    }
}