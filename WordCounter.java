import java.util.*;
public class WordCounter 
{
	public static void main(String[]args)
	{   
		Scanner scan = new Scanner(System.in);
        int count = 0;
        int withoutRepCount = 0;
        //System.out.println("Write a sentence or a paragraph :");
		//String file =  scan.next();
        String file = "Hey!, I am not one among many, but I am THE one, in many.";
        
        //for easier verification of duplicate words.
        String checkString = file.toLowerCase();
        
        //splits the sentence based on the given delimiters and stores i=them in the array.
		String arr1[] = checkString.split("[, . ]+");
        
		//stores the value of original array
        String arr[] = new String[arr1.length];
        for(int i=0;i<arr1.length;i++)
        {
        	//to count the number of words.
		    count++;
		    arr[i] = arr1[i]; 
            //System.out.println(arr1[i]);
        }	        
        System.out.println("Total number of words : "+count);  
        System.out.println("");
        System.out.println("Duplicate words : ");
        //takes the from index of the array.
        for(int i=0;i<arr.length;i++)
        {
        	//check the first index of the array with rest of the indexes.
            for(int j=i+1;j<arr.length;j++)
            {	
                if(arr[i].equals(arr[j]))
                {
                	//to keep count of words without repetition
                    withoutRepCount++;
                    
                    //so that those words are not taken in account for.
                    arr[j] = "0";
                }
            }
            String[] rep = new String[arr1.length];
        	if(arr[i]=="0")
        	{
        		//to give all the repeated words to a different array.
				rep[i]=arr1[i];
                System.out.println(rep[i]);
        	}    	
        }    
        System.out.println("");
        System.out.println("Total number of words without repetition are : "+withoutRepCount);     
	}
}
