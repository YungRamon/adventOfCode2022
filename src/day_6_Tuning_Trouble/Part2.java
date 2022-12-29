package day_6_Tuning_Trouble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

	static char[] tail=new char[13];
	public static void main(String[] args) throws FileNotFoundException {
	
		// Open file with contents
		//File file=new File("D:/fuentes_advent/6_ex.txt");
		File file=new File("D:/fuentes_advent/6.txt");
		Scanner reader=new Scanner(file);
		char[] input=reader.nextLine().toCharArray();
		int cont=0;
		while (!mark(input[cont])) {
			cont++;
		}
		System.out.println(cont+1);
		reader.close();
	}
	
	public static boolean mark(char c) {
		for (int i = 0; i < tail.length; i++) {
			if (tail[i]==c) {
				for (;i < tail.length; i++) {
					tail[i]='\0';
				}
				addToTail(c);
				return false;
			} else if(tail[i]=='\0') {
				addToTail(c);
				return false;
			}
		}
		return true;
	}
	
	public static void addToTail(char c) {
		for (int i = tail.length-2; i >= 0; i--) {
			tail[i+1]=tail[i];
		}
		tail[0]=c;
	}
}
