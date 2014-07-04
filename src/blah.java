
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.ArrayList;

public class blah {

	
	public static void main(String[] args){
	
		HashMap<String, String> trans = new HashMap<String,String>();
		trans.put("1", "one");
		trans.put("2", "two");
		trans.put("3", "three");
		trans.put("4", "four");
		trans.put("5", "five");
		trans.put("6", "six");
		trans.put("7", "seven");
		trans.put("8", "eight");
		trans.put("9", "nine");
		trans.put("10", "ten");
		
		System.out.println("Give me a string:");
		Scanner input = new Scanner(System.in);
		String user_input = input.nextLine();
		
		String[] thing = user_input.split(" ");
		for(int i = 0; i < thing.length; i++){
			if(trans.containsKey(thing[i])){
				
				thing[i] = trans.get(thing[i]);
			}
		}
		
		String final_output = "";
		for(int j = 0; j<thing.length;j++){
			final_output += " "+ thing[j] + " ";
		}
		
		System.out.println(final_output);
	}
}
