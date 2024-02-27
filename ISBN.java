import java.util.Scanner;

public class ISBN {
    public static Scanner input = new Scanner(System.in);

    public static String isbn10(long num){
        int sum = 0;
        int factor = 9;
        while (num > 0){  
            int digit = (int) num%10;
            sum += digit * factor;
            num /= 10;
            factor--;
        }
        int tenthnum = sum % 11;
        String tenthDigit;
        if (tenthnum == 10){
            tenthDigit = "X";
        } else{
            tenthDigit = String.valueOf(tenthnum);
        }
        return tenthDigit;
    }
   
    public static String isbn13(long num) {
        int sumWithEven = 0;
        int sumWithOdd = 0;
        int total = 0;
        int factor = 0;
    
        while (num > 0) {
            int digit = (int) (num % 10);
            if (factor % 2 == 0) {
                sumWithEven += digit * 3;  // Even positions have a weight of 3
            } else {
                sumWithOdd += digit;  // Odd positions have a weight of 1
            }
            num /= 10;
            factor++;
        }
    
        total = sumWithEven + sumWithOdd;
        int remainder = total % 10;
        int thirteenthDigit;
        if (remainder == 0) {
            thirteenthDigit = 0;
        } else {
            thirteenthDigit = 10 - remainder;
        }
        return String.valueOf(thirteenthDigit);
    }    
    public static void main(String[] args){
        while(true){
            System.out.print("Enter 9 digit numbers or 12 digit numbers for ISBN number:");
            String x=input.nextLine();
            int lengths=x.length();
            if(lengths == 9 || lengths == 12){
                try{
                    long num= Long.parseLong(x);
                    if (lengths == 9){
                        System.out.println("The 10 ISBN:" + num + isbn10(num));
                    }
                    else {
                        System.out.println("The 13 ISBN:" + num + isbn13(num));
                    }
                break;
            } catch (NumberFormatException exception){
                System.out.println("Invalid input.Please retype the number.");
            }  
            } else {
                System.out.println("Invalid input. ISBN must have 10 or 13 digits.");
            }
        }
    }   
}
