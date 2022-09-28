/*
 * Class: CMSC203 CRN 21076
 * Instructor: Khandan Monshi
 * Description: Build an application that will receive a guess and report 
 * if your guess is the random number that was generated.  
 * Your application will narrow down the choices according to your 
 * previous guesses and continue to prompt you to enter a guess until you 
 * guess correctly.
 * Due: 09/28/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Majdoleen Mohammedaman
*/


import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		System.out.println("This application generates a random integer between 1 and 100 ");
		System.out.println(" and asks the user to guess repeatedly until they guess correctly.");
				
		
		Scanner input = new Scanner(System.in);
		//RNG rn = new RNG(); // this brings objects and functions from the rng class. I can use the rn function to call anything from the rng class
		int num = RNG.rand(); //this generates the random numbers from 1 to 100 (use this the same way I use the Scanner class)
		int highGuess = num--;
		int lowGuess = 1;
		int nextGuess = 0;
		
		System.out.println("Enter your first guess: ");
		while(true) {
			int guess = input.nextInt();
			if (guess != num) {
				while (guess != num) {
					if (guess > num) {
						System.out.println("Your guess is too high");
					}
					else if (guess < num) {
						System.out.println("Your guess is too low");
						lowGuess = guess + 1;
						
					}
					System.out.println("Number of guesses: " + RNG.getCount());
					break;
				}
				if (RNG.getCount() == 7) {
					System.out.println("You have exceeded the maximum number of guesses, 7. Try Again");
					System.out.println("Thanks for playing....");
					System.out.println("\nProgrammer: Majdoleen Mohammedaman");
					break;
				} 
				
				RNG.inputValidation(nextGuess, lowGuess, highGuess);
				System.out.println("Enter your next guess");
				
			}
			
			if (guess == num) {
				System.out.println("Congratulations, you guessed correctly");
				new RandomNumberGuesser().tryAgain();
				
				
			}
		}		
		
		input.close();
	}

	public void tryAgain() {
		Scanner input = new Scanner(System.in);
		System.out.println("Try again? (yes or no)");
		String again = input.next();
		if (again.equalsIgnoreCase("yes")) {
			RNG.resetCount();
			main(null); // this repeats the main method			
		}
		else if(again.equalsIgnoreCase("no")) {
			System.out.println("Thanks for playing....");
			System.out.println("\nProgrammer: Majdoleen Mohammedaman");
		}
		
		input.close();
	}

}
