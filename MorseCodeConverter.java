import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is for managing the conversion and output.
 * @author y
 */
public class MorseCodeConverter 
{
	public static MorseCodeTree<String> cTree = new MorseCodeTree<>();
	
	public MorseCodeConverter()
	{
		
	}
	
	/**
	 * Converts MorseCode into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * Example: code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
     * string returned = "Hello World"
	 * @param code the morseCode
	 * @return the English translation
	 */
	public static String convertToEnglish(String code)
	{
		String result="", r="";
		String[] wordCodes = code.split("/");
		String[] letterCodes;
		
		for(int i=0; i< wordCodes.length; i++)
		{
			letterCodes = wordCodes[i].trim().split(" ");
			System.out.println(letterCodes);
			for(int j=0; j< letterCodes.length; j++)
			{
				r = cTree.fetch(letterCodes[j].trim());
				result += r;
				System.out.println(result);
			}
			result += " ";   // space between words
			System.out.println(result);
		}
		result = result.trim();		
		System.out.println(result);
		//return result.trim();
		return result;
	}
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * Example: a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * @param codeFile name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		ArrayList<String> codeLines = new ArrayList<>();
		Scanner input= new Scanner(codeFile);
		while (input.hasNext())
			codeLines.add(input.nextLine());
		input.close();
		
		String result="";
		String[] wordCodes;
		String[] letterCodes;
		for(int c=0; c< codeLines.size(); c++)
		{	
			wordCodes = codeLines.get(c).split("/");
			for(int i=0; i< wordCodes.length; i++)
			{
				letterCodes = wordCodes[i].trim().split(" ");
				//System.out.println(eachLetter);
				for(int j=0; j< letterCodes.length; j++)
				{
					result += cTree.fetch(letterCodes[j]);
				}
				result += " ";   // space between words
			}
		}
		result = result.trim();		
		return result;
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree.
	 * It should return the data in this order: "h s v i f u e l r a p w j b d x n c k y t z g q m o" 
	 * Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would come between the right most 
	 * child of the left tree (j) and the left most child of the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree()
	{
		String output="";
		ArrayList<String> tree = new ArrayList<>();
		tree = cTree.toArrayList();
		for (int i=0; i< tree.size(); i++)
		{	
			if (tree.get(i).equals("o"))
				output +=tree.get(i);
			else output += tree.get(i)+" ";
		}
		return output;
	}
	
}
