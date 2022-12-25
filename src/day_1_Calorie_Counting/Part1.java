package day_1_Calorie_Counting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) throws FileNotFoundException {
		// Open file with contents
		//File file=new File("D:/fuentes_advent/1_ex.txt");
		File file=new File("D:/fuentes_advent/1.txt");
		Scanner reader=new Scanner(file);
		//Saving the biggest pack and the current run pack
		int biggest_pack=0;
		int current_pack=0;
		//Read the file
		while (reader.hasNext()) {
			//Get the calories count from the file
			String cal = reader.nextLine();
			//If the collected line is empty we can set the biggest pack to current if it is bigger. Thought, we will always clear current counter
			if(cal.isEmpty() ) {
				if (current_pack>biggest_pack) {
					biggest_pack=current_pack;
				}
				current_pack=0;
			}
			
			//In other case we are adding calories to my current pack.
			else {
				current_pack+=Integer.parseInt(cal);
			}
		}
		if (current_pack>biggest_pack) {
			biggest_pack=current_pack;
		}
		//Close reader and show the biggest counter
		reader.close();
		System.out.println(biggest_pack);
	}

}
