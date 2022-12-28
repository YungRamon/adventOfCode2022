package day_1_Calorie_Counting;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) throws FileNotFoundException {
		// Open file with contents
		//File file=new File("D:/fuentes_advent/1_ex.txt");
		File file=new File("D:/fuentes_advent/1.txt");
		Scanner reader=new Scanner(file);
		//Saving the biggest packs and the current run pack
		int[] biggest_pack=new int[3];
		int limite=biggest_pack.length-1;
		int current_pack=0;
		//Read the file
		while (reader.hasNext()) {
			//Get the calories count from the file
			String cal = reader.nextLine();
			//If the collected line is empty we can set the biggest pack to current if it is bigger. Thought, we will always clear current counter
			if(cal.isEmpty()) {
				insert(biggest_pack, limite, current_pack);
				current_pack = 0;
			}
			//In other case we are adding calories to my current pack.
			else {
				current_pack+=Integer.parseInt(cal);
			}
		}
		insert(biggest_pack, limite, current_pack);
		//Close reader and show the sum biggest counter
		reader.close();
		int sum=Arrays.stream(biggest_pack).sum();
		System.out.println(sum);
	}
	private static void insert(int[] biggest_pack, int limite, int current_pack) {
		boolean maximum=true;
		//Search for the position to insert current value, and clear
		for (int i = limite; i>=0 ; i--) {
			if(biggest_pack[i]>current_pack) {
				if (i<limite) {
					//Insert value
					shiftLeft(biggest_pack, current_pack, i+1);
				}
				maximum=false;
				break;
			}
		}
		if (maximum) {
			shiftLeft(biggest_pack, current_pack, 0);
		}
	}
	//Method to insert numbers with left shift into arra
	public static void shiftLeft(int[] array, int insert, int position) {
		//Shift
		for (int i = array.length-1; i > position; i--) {
			array[i]=array[i-1];
		}
		//Insert
		array[position]=insert;
	}

}