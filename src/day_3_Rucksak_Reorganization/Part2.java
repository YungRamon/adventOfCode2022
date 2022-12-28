package day_3_Rucksak_Reorganization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) throws FileNotFoundException {
		// Open file with contents
		//File file=new File("D:/fuentes_advent/3_ex.txt");
		File file=new File("D:/fuentes_advent/3.txt");
		Scanner reader=new Scanner(file);
		char[] res=new char[0];
		while (reader.hasNext()) {
			//Obtengo los caracteres primeros
			char[] common=new char[0];
			char[] rucksack=reader.nextLine().toCharArray();
			for (char c : rucksack) {
				if (!searchInArray(c,common)) {
					common=addToArray(common, c);
				}
			}
			//Items in rucksack
				rucksack=reader.nextLine().toCharArray();
				char[] rucksack2=reader.nextLine().toCharArray();
				for (int i=0;i<common.length;i++) {
					if (!searchInArray(common[i], rucksack) || !searchInArray(common[i], rucksack2)) {
						common=removeFromArray(common, i);
						i--;
					}
				}
			res=addToArray(res, common[0]);
			
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
	
	//Metodo para borrar caracter del array
	public static char[] removeFromArray(char[] arr, int remove) {
		char[] new_arr=new char[arr.length-1];
		System.arraycopy(arr, 0, new_arr, 0, remove);
		System.arraycopy(arr, remove+1, new_arr, remove, new_arr.length-remove);
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
