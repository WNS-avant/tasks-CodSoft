import java.util.*;
import java.util.Random;
public class MainCode 
{	
	public static void main(String[]args)
	{	
		//iterated n number of times until the user decides to exit.
		while(true)
			{		
				Scanner scan = new Scanner(System.in);
				
				//creating instance of the class to call the methods in switch-case.
				MainCode mc = new MainCode();
				System.out.println(" ");
				System.out.println("			Choose one of the following methods to generate a  random number : ");
				System.out.println(" 					number 1 : Existing method.");
				System.out.println(" 					number 2 : Code generated. ");
				System.out.println(" 				     ---any other number to exit---");
				int choice = scan.nextInt();
					switch(choice)
						{		
							case 1 :mc.existingMethod();
								break;
							case 2 :mc.coderGenerated();
								break;
							default: System.out.println("closing affairs...");
								System.exit(0);
						}
				
			}	
	}
		
	public void coderGenerated()
	{	
		//initialized in-order to keep track of games won.
		int gamesWon = 0;
		
		//iterated for next game until user decides to exit.
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter any combination of 2 to 5 digits to generate a unique number :");
			 int key = scan.nextInt();
			 System.out.println(" ");

			 System.out.println("     *__//   A random number, ranging from 1-100 has been generated.   \\__*      ");
			 System.out.println(" ");
			 /*
				an array to keep the generated numbers,
			 along with the code to generate a pseudo-random number.
				*/
			 
			 int arr[] = new int[50];
			 int i =0;										
			 int sum = 0;
			 int digit = 0;
			 if(key%2==0)
			 {
				key = (key*key)+23;
			 }
			 else
			 {
				key = key*key;
			 }
			while(key!=0)
			{
				digit = key%10;
				sum = sum + digit;
				key = key/10;
			}

			arr[i] = sum;
			//System.out.println("the generated number is : "+arr[i]); //un-comment the code to print the number.
			
			System.out.println("Guess the number that would've been genereted (5 attempts):");
			int n = scan.nextInt();

			int res = checkNum(n,arr[i]);
			
			// if the returned user number matches the generated number here it's a successful attempt, therefore a point is given to user.
			if(res==arr[i])
			  {
				  gamesWon++;
			  }
			  			
			  System.out.println("");
			System.out.println("                             Games won in a row : "+gamesWon);
							 System.out.println("              ---------------------------x----------------------------");

			System.out.println(" ");
 
			System.out.println("Enter any digit to continue guessing...");
			System.out.println("                 or           ");
			System.out.println("<<<   Enter c to change method   >>>");
			char change = scan.next().charAt(0);
				switch(change)
					{		
						case 'c' :return;
					}
		}
	}
	public void existingMethod()
	{
		int gamesWon = 0;
		
		//iterated for next game until user decides to exit.
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("               A random number, ranging from 1-100 has been generated.         ");
			
			/*
			the in-built java.Random method is utilized here.
			*/
			Random r = new Random();
			int num = r.nextInt(100);
			
		//System.out.println("the generated number is : "+num);  //un-comment the code to print the number.
			
			System.out.println(" ");
			System.out.println("Guess the number that would've been genereted (5 attempts):");
			int n = scan.nextInt();
			
			int res = checkNum(n,num);
			
			// if the returned user number matches the generated number here it's a successful attempt, therefore a point is given to user.
			if(res==num)
			{
				gamesWon++;
			}
			System.out.println("                            Games won in a row : "+gamesWon);
			System.out.println("");
							 System.out.println("              ---------------------------x----------------------------");

			System.out.println("");

			System.out.println("Enter any digit to continue guessing...");
			System.out.println("                 or           ");
			System.out.println("<<<   Enter c to change method   >>>");
			char change = scan.next().charAt(0);
				switch(change)
					{		
						case 'c' :return;
					}
		}
	}
	
	//takes two parameters 
	public static int checkNum(int u, int r)
	{	
		
		//initialized to count attempts.
		int count = 1;
		Scanner scan = new Scanner(System.in);
		
		//if the generated number and the user number matches.
		 if(r==u)
			{
				System.out.println("Splendid !  you've guessed it right....on the first attempt.!!");
			}
		 sup :
			 {
			  while(count<6)  // to keep the number of attempts limited to 5.
			 	{
			 	// if the iteration is equal to the generated number.
			 		if(u==r)
			 		{
			 			System.out.println("Congratulations !  you've guessed it right.");
			 			break sup;
			 		}
			 		else if(u<r&&u>=r-5&&u>=r-2)
			 			{
					 		System.out.println("very close now..a few numbers more ");
					 	}
			 		else if(u<r&&u>=r-5)
			 			{	
			 				System.out.println("a handful of numbers more...");
				 		}
			 		else if(u<r)
			 			{
			 				System.out.println("too low...keep guessing..");
			 			}
			 		else if(u>r&&u<=r+5&&u<=r+2)
			 			{
			 				System.out.println("very close now..a few numbers less ");
			 			}	
			 		else if(u<=r+5&&u<=r+2)
				 		{
			 				System.out.println("a handful of numbers less...");
				 		}
			 		else if(u>r)
					 	{
			 				System.out.println("too high...keep guessing..");
					 	}				
			 		
			 		//for every condition satisfied, user will be presented with an option to guess it again.
			 		u = scan.nextInt();
			 		
			 		//to keep the actual count of attempts until it reaches the limit.
			 		count++;
			 	}
			 	System.out.println("Sorry ! .... no more attempts left.");
			 }
		 //returns the last user input for verifying the games won.
		 return u;
	}
}