package day_3_Rucksak_Reorganization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) throws FileNotFoundException {
		// Open file with contents
		//File file=new File("D:/fuentes_advent/3_ex.txt");
		File file=new File("D:/fuentes_advent/3.txt");
		Scanner reader=new Scanner(file);
		char[] res=new char[0];
		while (reader.hasNext()) {
			//Items in rucksack
			char[] rucksack=reader.nextLine().toCharArray();
			char[] firstHalf=new char[0];
			for (int i = 0; i < rucksack.length/2; i++) {
				if(!searchInArray(rucksack[i], firstHalf)) {
					firstHalf=addToArray(firstHalf, rucksack[i]);
				}
			}
			char[] used=new char[0];
			for (int i = rucksack.length/2; i < rucksack.length; i++) {
				
				if(!searchInArray(rucksack[i], used)) {
				
					if(searchInArray(rucksack[i], firstHalf))
						res=addToArray(res, rucksack[i]);
					used=addToArray(used, rucksack[i]);
				}
			}
		}
		reader.close();
		int sum=0;
		for (char c : res) {
			sum+=getPriority(c);
		}
		System.out.println(sum);
	}
	
	//Metodo para encontrar un caracter en el array
	public static boolean searchInArray(char needle, char[] haystack) {
		for (char c : haystack) {
			if (needle==c) {
				return true;
			}
		}
		return false;
	}
	
	//Metodo para añadir un caracter en el array
	public static char[] addToArray(char[] arr, char add) {
		char[] new_arr=new char[arr.length+1];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		new_arr[arr.length]=add;
		return new_arr;
	}
	
	//Metodo para calcular prioridad
	public static int getPriority(char c) {
		int priority=c;
		if (priority>96) {
			priority-=96;
		}
		else {
			priority-=38;
		}
		return priority;
	}
}
