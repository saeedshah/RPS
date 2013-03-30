/* ---------------------------------------------
 * File: rpsAssignment.java
 * It's a simple game called Rock-Paper-Scissors: 
 * coded by Saeed
 * --------------------------------------------
 * program flow sequence:
 * 1- ask user how many rounds they want to play. (min 2, max 10 rounds - just to keep it simple)
 * 2- ask user to input their choice - Rock, Paper, or Scissors.
 * 3- get computer to make a counter choice randomly. (using a built-in Random method)
 * 4- compare user-input vs computer-input and decide winner of the round. 
 * 5- after final round, compare user vs computer score and declare winner of the match.  
 */
import acm.program.*;
import java.util.*;
public class rpsAssignment extends ConsoleProgram 
{
  public void run() {
	setFont("verdana-bold-14"); // just so you can see it nice and bold//
	println("Welcome to ROCK - PAPER - SCISSORS \t This game is coded by Saeed. "); pause(500);
	println("Remember: Scissors cut Paper - Paper wraps Rock - Rock breaks Scissors.");
	
	int userChoice=0;		// to get input from user  //
	int pcChoice=0;  		// to get random input from computer//
	int userScore=0;	 	// keep count of user score //
	int pcScore=0; 	  		// keep count of computer score //
	int scorer=0;	        // used to update user and computer scores at each round //
    // to keep it simple play between 2 to 10 rounds //
	int maxRounds = readInt ("How many Rounds do you want to play? (min 2 to max 10): ");
	while (maxRounds < 2 || maxRounds > 10) // to check user gives a valid input //
			maxRounds = readInt ("Plz pick between 2 to 10 rounds only: ");
		pause(500);
		println("Chalo shuru karein phir: \n \n ===> ===> ===> ===> ===> ===> ===> ===>  "); 

		// run the FOR loop to number of rounds user selected in previous step //
	for (int i=0; i< maxRounds; i++ ) 
	{
		userChoice = get_userChoice();
		pcChoice = get_pcChoice();
		scorer= scoreUpdater(userChoice, pcChoice);
		if (scorer==1) userScore++;
		if (scorer==-1) pcScore++;
		
		println("Your score:==>" + userScore + "\tComputer's score:==>" + pcScore);
	}
	pause(500);
println("\n That was the last round. Thanks for playing.");
	pause(1000);

	
if (pcScore == userScore)println ("===>> Wow! That was a tie. What are the odds of that happening? really!!! <<=== ");
if (pcScore > userScore) println ("===>> Computer has won the match. Better luck next time! <<=== ");
if (userScore > pcScore) println ("===>> Well done. Aap Jeet Gaye yeh match. Aap ki kia hee baat hai! <<===");

}
	
 private int get_userChoice(){
		int i_userChoice= readInt ("\nPlz make your choice:\n 1-Rock;\t    2-Paper; \t   3-Scissors;     ");
		while (i_userChoice < 1 || i_userChoice > 3)
			i_userChoice = readInt("Plz enter a valid choice. REMEMBER ( 1 for Rock, 2 for Paper, or 3 for Scissors): ");

		switch (i_userChoice) {  // convert user input number to Rock, Paper, or Scissors //
		case 1:  print (" Your choice: 1-Rock:     <----vs----> ");	break;
		case 2:  print (" Your choice: 2-Paper:    <----vs----> "); 	break;
		case 3:  print (" Your choice: 3-Scissors: <----vs----> "); 	break;
		}
		return(i_userChoice);
 
 }
 private int get_pcChoice(){
	// get a valid choice for computer using built-in java method of random number generator // 
	 int i_pcChoice = 0;
	 Random i_myDice= new Random();
	 i_pcChoice= 1 + i_myDice.nextInt(3);    // adding 1 to make sure computer choice is valid (between 1-3)//
	 
	
	switch (i_pcChoice) {  // convert user input number to Rock, Paper, or Scissors //
		case 1:  println (" 1-Rock: Computer's choice ");		break;
		case 2:  println (" 2-Paper: Computer's choice "); 	break;
		case 3:  println (" 3-Scissors: Computer's choice "); 	break;
	 }
 return(i_pcChoice);
 
}
 private int scoreUpdater( int i_userChoice, int i_pcChoice)
 {
 if (i_userChoice==i_pcChoice)   
 
 { println("is dafa braaber. both made same choice: ");
	 	return (0);}  // if both make same choice, it's a draw.
 
 
 // (1 && 3) || (2&&1) || (3&&2)
 else if ( i_userChoice==1 &&  i_pcChoice==3 ||  i_userChoice==2 && i_pcChoice==1 || i_userChoice==3 && i_pcChoice==2)  // this is flawed. correct it
 
 {println("waah kia baat hai. you beat computer in this round");   return(1);} // means user won this round.
  
 else 
 
 { println(" Computer jeeta ye round. ");return(-1);} // means computer won this round.  

}
 
}
