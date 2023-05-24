/*Caitlyn Brodie
	10/20/2022
	Period 3*/
import java.util.*;
import java.io.*;
public class UsefulMethods
{
	private Scanner sc = new Scanner(System.in);
	/* This method will validate that an integer is greater than or equal to a lower bound.
	 * @param the integer to validate
	 * @param the lower bound as an int
	 * @returns the validated integer
	 */
	public int valid(int num, int lowBound)
	{
		while(num<lowBound)
		{
			System.out.print("\n\tPlease enter a number greater than or equal to " + lowBound + ": ");
			num = sc.nextInt();
			System.out.println();
		}

		//return the number that is validated
		return num;
	}

	/* This method will validate that an integer is greater than or equal to a lower bound
	 * and less than or equal to an upper bound
	 * @param the integer to validate
	 * @param the lower bound as an int
	 * @param the upper bound as an int
	 * @returns the validated integer
	 */
	public int valid(int num, int lowBound, int upperBound) {
		// WHILE LOOP TO VALIDATE
		while(num<lowBound || num>upperBound) {
			System.out.print("\n\tPlease enter a number greater than or equal to " + lowBound +
							 " and less than or equal to " + upperBound + ": ");
			num = sc.nextInt();
			System.out.println();
		}

		// RETURN THE VALIDATED NUMBER
		return num;
	}

	/* This method will validate that an double is greater than a lower bound
	 * and less than an upper bound
	 * @param the double to validate
	 * @param the lower bound as an double
	 * @param the upper bound as an double
	 * @returns the validated double
	 */
	public double valid(double num, double lowBound, double upperBound) {
		// WHILE LOOP TO VALIDATE
		while(num<=lowBound || num>=upperBound) {
			System.out.print("\n\tPlease enter a number greater than " + lowBound +
							 " and less than " + upperBound + ": ");
			num = sc.nextDouble();
			System.out.println();
		}

		// RETURN THE VALIDATED NUMBER
		return num;
	}


	/* This method will validate that a double is greater than or equal to a lower bound.
	 * @param the double to validate
	 * @param the lower bound as a double
	 * @returns the validated double
	 */
	public double valid(double num, double lowBound) {
		// WHILE LOOP TO VALIDATE
		while(num<lowBound) {
			System.out.print("\n\tPlease enter a number greater than or equal to " + lowBound + ": ");
			num = sc.nextDouble();
			System.out.println();
		}

		// RETURN THE VALIDATED NUMBER
		return num;
	}

	//Re-run
	public static String repeatProgram(String string, Scanner sc)
	{
		System.out.print("\n\nDo you want to repeat the program? ");
		string = sc.nextLine();
		//Validate
			while(!(string.equalsIgnoreCase("yes")||string.equalsIgnoreCase("no")))
			{
				System.out.println("\nYou need to enter yes or no");
				System.out.print("Do you want to repeat the program? ");
				string = sc.nextLine();
			}
		System.out.println("\n\n");
		return string;
	}


	//File reading and file writing
	public static void textFile() throws IOException
	{
		//Declare and Open Connection with the File
			FileWriter fw = new FileWriter("Name.txt");
			PrintWriter pw = new PrintWriter(fw);
		//Output the information to the file
			pw.println();

		//Close the connection
			pw.close();
			System.out.println("Data was written to the file");



		//Make the Connection
			FileReader fr = new FileReader("Name.txt");
			BufferedReader br = new BufferedReader(fr);

		//Read in the FIRST line from the file
			String str = br.readLine();

		//Validation to make sure there is something in the file
			while(str != null)
			{
				//Print the line
					System.out.println(str);

				//TYPICALLY the last line the loop
					str = br.readLine();

			}

		//Close the Connection
			br.close();

	}
	public String isEmpty(String str)
	{
		while(str.isEmpty())
		{
			System.out.println("\n\tYou need to enter something");
			str = sc.nextLine();
		}
		return str;
	}

}