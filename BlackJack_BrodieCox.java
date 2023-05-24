/*Caitlyn Brodie and Meara Cox
  Pd 3
  5/12/2022
  This program will allow the user to play blackjack, the goal of blackjack is to get as close to 21 without going over, or busting. To start the
  game the program will tell the user how much money they have, they start with $1000, and will ask them how much they want to bet. The dealer
  will draw one card, which will be displayed to the user. Then the user will be randomly given two cards and their total will be displayed. Cards
  2-9 are worth their set value, aces can be worth 1 or 11, and jack, queen, and king's are worth 10. After the user has their first two cards if
  their total does not equal 21 the program will ask the user if they want to "hit", take another card, or "stand", do not take another card. If
  the user chooses to hit the program will randomly draw another card and display the users new total. Until they are at or above 21 or they choose
  to stand the program will allow them to hit and keep displaying the card they were dealt along with their new total. Once they choose to stand
  if they have not busted and the dealer will be dealt a second card which will be displayed to the user. If the dealers total is less than 17
  they will continue to pick up cards until they are at at least 17. Once at that point the program will check if the dealer or player is closer to
  21 and will let the user know if they won or lost, or if the dealer and player have the same total they tied, or pushed. If the player won they
  will get the money they had plus their bet back and if the lost they will lose the amount they bet from the money they had. The program will
  continue to run while the player chooses to play again and they have money left. */

import java.text.*;
import java.util.*;

public class BlackJack_BrodieCox
{
	public static void main(String[] args)
	{
		//Declare Variables
			Scanner sc = new Scanner(System.in);
			String name, repeat = "";
			int money = 1000, bet;

		//print welcome message and ask for name
			System.out.print("Welcome to The Casino \n\nEnter your name: ");
			name = sc.nextLine();

		//create do while to run while user wants to play and has money
			do
			{
				//Declare Variables
					int dCV1, dCV2, dTotal = 0;
					int uCV1, uCV2, uTotal = 0;
					String dCF1, dCF2, uCF1, uCF2;
					String pick = "hit";

				//print how much money they have and ask how much they want to bet
					System.out.println("\nYou have $" + money + " how much would you like to bet?");
					bet = sc.nextInt();

					//call validate method for bet
						bet = validate(money, bet, sc);

				//read in blank line
					sc.nextLine();

				//Create Dealer card object
					Card dealCard1 = new Card();
					Card dealCard2 = new Card();

				//get the value of the dealer cards
					dCV1 = dealCard1.getValue();
					dCV2 = dealCard2.getValue();

				//get the face of the dealer cards
					dCF1 = dealCard1.getFace();
					dCF2 = dealCard2.getFace();

				//check to see if eiher card is an ace and call aces method if so
					if(dCF1.equalsIgnoreCase("ace"))
						dCV1 = aces(dCV1, dTotal);

					if(dCF2.equalsIgnoreCase("ace"))
						dCV2 = aces(dCV2, dTotal);

				//find total of dealer  cards
					dTotal = dCV1 + dCV2;

				//display one of the dealers card
					System.out.println("\nThe dealer: \n? + " + dealCard2.getFace());

				//create user card objects
					Card uCard1 = new Card();
					Card uCard2 = new Card();

				//get the value of the user cards
					uCV1 = uCard1.getValue();
					uCV2 = uCard2.getValue();

				//find face of user cards
					uCF1 = uCard1. getFace();
					uCF2 = uCard2.getFace();

				//check to see if either user card is an ace and if so call aces method
					if(uCF1.equalsIgnoreCase("ace"))
						uCV1 = aces(uCV1, uTotal);

					if(uCF2.equalsIgnoreCase("ace"))
						uCV2 = aces(uCV2, uTotal);

				//find total of user cards
					uTotal = uCV1 + uCV2;

				//print out users initial cards and the total of the cards
					System.out.println("\nYou: ");
					System.out.println(uCard1.getFace() + " + " + uCard2.getFace() + " = " + uTotal);

				//if the user gets 21 initially print out message
					if(uTotal == 21)
						System.out.println("\nYou got 21! Now lets see what the dealer gets...");

				//create do-while for user to pick cards while their total is under 21
					while(pick.equalsIgnoreCase("hit") && uTotal < 21)
					{
						//Ask the user if they want to hit or stand
							System.out.print("\n\tWould you like to \"hit\" or \"stand\": ");
							pick = sc.nextLine();

							//call validate method
								pick = validate(pick, "hit", "stand", sc);

						//if user chooses to hit call newCard method
							if(pick.equalsIgnoreCase("hit"))
							{
								System.out.println("\nDealer: \n? + " + dealCard2.getFace());
								System.out.println("\nYou:");
								uTotal = newCard(uTotal, "You");
							}
					}

				//if the users total is over 21 tell them they busted
					if(uTotal > 21)
					{
						System.out.println("\n\tYou busted. Dealer Wins");

						//subtract bet from money
							money  -= bet;

						//if user still has money left ask them if they want to play again
							if(money > 0)
								repeat = playAgain(repeat, money, sc);

							else
								repeat = "no";
					}

				//create if statement for if the user chooses to stand or their total is 21
					else if(pick.equalsIgnoreCase("stand") || uTotal == 21)
					{
						//print out both the dealers cards and their total
							System.out.println("\nDealer: \n" + dealCard1.getFace() + " + " + dealCard2.getFace() + " = " + dTotal);

						//if the dealers total is less than 17 have them pull new cards until they have at least a total of 17
							if(dTotal < 17)
							{
								//use while loop to call newCard method
									while(dTotal < 17)
									{
										dTotal = newCard(dTotal, "Dealer");
									}
							}

						//if user total is greater than dealer total tell user they won
							if(uTotal > dTotal || dTotal > 21)
							{
								//add bet to money
									money += bet;

								System.out.println("\n\n\tYou Win!");

								//call playAgain method
									repeat = playAgain(repeat, money, sc);
							}

						//if the totals are equal tell them they tied
							else if(uTotal == dTotal)
							{
								System.out.println("\n\n\tYou tie. This is a push. ");

								//call playAgain method
									repeat = playAgain(repeat, money, sc);
							}

						//if the user is less than dealer tell them they lost
							else
							{
								money -= bet;
								System.out.println("\n\n\tYou lost.");

								//call playAgain method if they still have money
									if(money > 0)
										repeat = playAgain(repeat, money, sc);

									else
										repeat = "no";
							}
					}

			}
			while(repeat.equalsIgnoreCase("yes"));

			//once user quits print thank you message
				System.out.println("\n\tThank you " + name + " for coming to The Casino!\n");

	}
/****************************************************************************************************************************************************
This method will accept a int and a string and will create a new card object, display it plus the total, the total, and will return the new total*/

	public static int newCard(int total, String who)
	{
		//Declare new total variable
			int nTotal = 0;

		//Create new card object
			Card nCard = new Card();

		//get value of new card
			int value = nCard.getValue();

		//get face of new card
			String face = nCard.getFace();

		//if new card is an ace call aces method
			if(face.equalsIgnoreCase("ace"))
				value = aces(value, total);

		//find new total
			nTotal += value + total;

		//print new info
			System.out.println(who + " got dealt a " + nCard.getFace());
			System.out.println(total + " + " + nCard.getFace() + " = " + nTotal);

		//return new tota;
			return nTotal;
	}

/*************************************************************************************************************************************************
This method will accept a string and will tell the user how much money they have left and ask the user if they want to play again the method will
return their answer to the main method. */

	public static String playAgain(String repeat, int money, Scanner sc)
	{
		//tell user how much money they have and ask if they want to play again
			System.out.println("\nYou now have $" + money + " Would you like to play agian?");
			repeat = sc.nextLine();

		//call validate method for repeat
			repeat = validate(repeat, "yes", "no", sc);

		//return repeat
			return repeat;
	}
/*************************************************************************************************************************************************
This method accepts a string and validates that the user entered hit or stand and will return a string. */

	public static String validate(String choice, String word1, String word2, Scanner sc)
	{
		while(!(choice.equalsIgnoreCase(word1) || choice.equalsIgnoreCase(word2)))
		{
			System.out.print("\n\tERROR: must enter \"" + word1 + "\" or \"" + word2 + "\": ");
			choice = sc.nextLine();
		}

		return choice;
	}

/*************************************************************************************************************************************************
This method will accept an int for the value of the card and the current total of the hand determine if the the ace should be a 1 or an 11 and
returns an int to the method it was called from. */

	public static int aces(int value, int total)
	{
		if(total <= 10)
			value = 11;

		else
			value = 1;

		return value;

	}

/*************************************************************************************************************************************************
This method will accept two ints and will validate that the amount of money the user wants to bet is greater than 0 and does not exceed the amount
they have left, then it will return the bet back to the main method. */

	public static int validate(int money, int bet, Scanner sc)
	{
		while(bet < 1 || bet > money)
		{
			System.out.println("\n\tYour bet must be positive and cannot exceed the amount of money you have left");
			bet = sc.nextInt();
		}

		return bet;
	}

}