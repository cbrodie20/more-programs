/*Caitlyn and Nick
*/
import java.util.*;
public class RPS
{
	private String[] playerChoice = {"rock","paper","sissors"};
	private String[] computerChoice = {"rock","paper","sissors"};
	//Constructor
		public RPS(String[] playerChoice, String[] computerChoice)
		{
			this.playerChoice = playerChoice;
			this.computerChoice = computerChoice;
		}

	//Ask what choice they want to make
		public String playChoice()
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Rock, paper or sissors: ");
			String choice = sc.nextLine();
			return choice;
		}

	//randomly chose the computers choice
		public String compChoice()
		{
			Random rand = new Random();
			int randomNum = Random.nextInt(3);
			String comp = " ";
			if(randomNum == 0)
				comp = "rock";
			else if(randomNum == 1)
				comp = "paper";
			else
				comp = "sissors";
			return comp;
		}
	//Compare to method
		public void compareTo()
		{

		}


}
