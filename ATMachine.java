import java.util.Scanner;
public class ATMachine 
{
	public static void main(String[]args) 
	{
        float balance = 50000.0f;
        float res1=0;
        float res2=0;
 
        while(true)
        {    		
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			ATMachine sc = new ATMachine();
			System.out.println("");
			System.out.println("");

			System.out.println("       -] WELCOME TO TUNGSTEN BANK INC. [-");
			System.out.println("");
			System.out.println("  Choose the desired operation ");
			System.out.println("    -:- Withdraw amount      +press >> 1 and enter");
			System.out.println("    -:- Deposit amount       +press >> 2 and enter");
			System.out.println("    -:- Exit                 +press >> any other digit and enter");
			System.out.println("");
			
			int choice = scan.nextInt();
			switch(choice)
				{		
					case 1 :res1 = sc.withdraw(balance);
                    	balance = res1;
                    	break;
					case 2 :res2 = sc.deposit(balance);
                        balance = res2;     
                        break;
					default:System.out.print("    closing Affairs...");
					System.exit(0);
				}                 
         }			
	}
	
	@SuppressWarnings("resource")
	public float withdraw(float b) 
	{	
		float t=0;
		sup :while(true)
		{
			ATMachine sc = new ATMachine();
			Scanner scan = new Scanner(System.in); 
			System.out.println(" Enter amount to withdraw :");
			float user_input = scan.nextFloat();
			if(user_input==0)
			{
				System.out.println("invalid amount...!");	
			}	
			else if(user_input<b)
			{
				b = b-user_input;
				System.out.println("Amount Deducted !");
			}
			else if(user_input==b)
			{
				System.out.println("Amount Deducted !");
				b=0;	
			}	
			else if(user_input>b && b!=0)
			{       
				System.out.println("Action not permitted ! ..amount requested is greater than available balance");
			}	
			else if(user_input>b)
			{
				System.out.println("                      Insufficient Balance");
				System.out.println("Do not worry, come later...or we can redirect you to deposits....");
				System.out.println(" >>  +press >> y to deposit");
				System.out.println(" >>  +press >> n to end transaction");
				char user = scan.next().charAt(0);
					switch(user)
					{
						case 'y' :System.out.println("       ........Redirecting to Deposits........");
							b = sc.deposit(0);
							break sup;
						case 'n' : System.exit(0);
					}
				
			}
			System.out.println(" ");	
			t =checkBalance(b);		
			
			return t;
		}
		return b;		
	}
	
	@SuppressWarnings("resource")
	public float deposit(float bln)
	{
		while(true)
		{
							System.out.println(" ");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the amount to be deposited :");
			float amount = scan.nextFloat();
			if(amount==0)
			{
				System.out.println("This action has no effect !");
							System.out.println(" ");
			}
			bln = bln+amount;
			System.out.println("Thank you! ..your deposit is noted.");
							System.out.println(" ");
			float t2=0;
			t2 = checkBalance(bln);
			return t2;
		}
	}	
	
	public float checkBalance(float total)
	{
		while(true)
		{		
			System.out.println("Your current balance is : Rs. "+total);
							System.out.println(" ");
			System.out.println("        ---------------------x---------------------");

			return total;
		}		
	}
}
