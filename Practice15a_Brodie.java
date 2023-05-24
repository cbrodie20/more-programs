/*Caitlyn Brodie
	11/14/2022
	Period 5
	The user will enter two strings that will be declared as String Objects. the program will determine
	if the first word should be placed before or after the second word in the dictionary. Then the program
	will ask the user if they would like to run the program again.*/

import java.util.*;
import java.util.Scanner;


public class Practice15a_Brodie
{
	public static void main(String[] args)
	{
		//Declare Scanner
			Scanner sc = new Scanner(System.in);

		//Create useful methods object
			UsefulMethods use = new UsefulMethods();
			String repeat = " ";

			do
			{
		//Ask the user to enter 2 strings
			System.out.print("Enter a string: ");
			String str1 = new String(sc.nextLine().toLowerCase());
			//Validate
				while(str1.isEmpty())
				{
					System.out.println("you need to enter something");
					System.out.print("Enter a string: ");
					str1 = new String(sc.nextLine().toLowerCase());
				}
			System.out.print("Enter another string: ");
			String str2 = new String(sc.nextLine().toLowerCase());
			//Validate
				while(str2.isEmpty())
				{
					System.out.println("you need to enter something");
					System.out.print("Enter another string: ");
					str2 = new String(sc.nextLine().toLowerCase());
				}

		//Decide which String should be first in dictionary

			int i = str1.compareTo(str2);
			if(i < 0)
				System.out.println(str1 + " should be placed before " + str2);

			else if(i == 0)
				System.out.println("The strings were the same");

			else if(i > 0)
				System.out.println(str2 + " should be placed before " + str1);

			//Ask to repeat
				repeat = use.repeatProgram(repeat,sc);
			}
			while(repeat.equalsIgnoreCase("yes"));

	}
}