package day_8_Treetop_Tree_House;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

	//Table
	static int[][] table;
	//In this part I don't have an idea for how to evade full scanner
	
	public static void main(String[] args) throws FileNotFoundException{
		// Open file with contents
		//File file=new File("D:/fuentes_advent/8_ex.txt");
		File file=new File("D:/fuentes_advent/8.txt");
		Scanner reader=new Scanner(file);
		//Count for rows and cols
		int cols=reader.nextLine().length();
		int rows=1;
		while (reader.hasNextLine()) {
			reader.nextLine();
			rows++;
		}
		reader.close();
		//Use sizing
		table=new int[rows][cols];
		reader=new Scanner(file);
		//It can be possible to work, at least partially with straight input, but my experience ain't giving me this solution
		//So, I will just parse full field
		int row_num=0;
		while (reader.hasNextLine()) {
			char[] nums = reader.nextLine().toCharArray();
			for (int col = 0; col < nums.length; col++) {
				table[row_num][col]=Character.getNumericValue(nums[col]);
			}
			row_num++;
		}
		reader.close();
		int maxed=0;
		int[] row;
		//Process table row per row
		for (int j = 1; j < table.length-1; j++) {
			row=table[j];
			for (int i = 1; i < row.length-1; i++) {
				int mult=1;
				int cont=0;
				int dist=0;
				for (cont = i-1; cont > 0 && row[cont]<row[i]; cont--);
				dist=i-cont;
				mult*=dist;
				for (cont = i+1; cont < row.length-1 && row[cont]<row[i]; cont++);
				dist=cont-i;
				mult*=dist;
				for (cont = j-1; cont > 0 && table[cont][i]<row[i]; cont--);
				dist=j-cont;
				mult*=dist;
				for (cont = j+1; cont < table.length-1 && table[cont][i]<row[i]; cont++);
				dist=cont-j;
				mult*=dist;
				if (mult>maxed) {
					maxed=mult;
				}
			}
		}
		System.out.println(maxed);
	}
	
	
}
