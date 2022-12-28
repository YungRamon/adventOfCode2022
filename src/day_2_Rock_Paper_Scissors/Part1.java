package day_2_Rock_Paper_Scissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
	public static final int WIN=6;
	public static final int DRAW=3;
	public static final int LOSE=0;
	//Map to search letter value
	private static Map<Character, Integer> letterValue=new HashMap<>();
	public static void main(String[] args) throws FileNotFoundException {
		assignValues();
		int points=0;
		// Open file with contents
		//File file=new File("D:/fuentes_advent/2_ex.txt");
		File file=new File("D:/fuentes_advent/2.txt");
		Scanner reader=new Scanner(file);
		while (reader.hasNext()) {
			char[] plan=reader.nextLine().toCharArray();
			points+=result(letterValue.get(plan[0]), letterValue.get(plan[2]));
		}
		reader.close();
		System.out.println(points);

	}
	//Asign letters to indexes
	private static void assignValues() {
		char letter1='A';
		char letter2='X';
		for (int i = 1; i <= 3; i++,letter1++,letter2++) {
			letterValue.put(letter1, i);
			letterValue.put(letter2, i);
		}
	}
	//Get results of comparing
		private static int result(int opponent,int player) {
			switch (player-opponent) {
			case 0: {
				return player+DRAW;
			}
			case 1,-2:{
				return player+WIN;
			}
			default:
				return player+LOSE;
			}
		}

}
