/*Caitlyn and Nick
*/

public class Player
{
	//Instant variables
		private String firstName, lastName;
		private int wins, loses, cashOnHand, currentChoice;

	//Constructor
		public Player(String f, String l, int w, int lose, int cash, int current)
		{
			String firstName = f;
			String lastName = l;
			int wins = w;
			int loses = lose;
			int cashOnHand = cash;
			int currentChoice = current;
		}
	//Accessor methods
		public void setName(String f, String l)
		{
			String firstName = f;
			String lastName = l;
		}

	//Mutator
		public String getName()
		{
			return firstName + " " + lastName;
		}

	//toString to write out all the data at the end of the game
		public String toString()
		{
			return " ";
		}
}