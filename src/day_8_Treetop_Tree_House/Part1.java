package day_8_Treetop_Tree_House;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

	//Field
	static int[][] table;
	//Top and left values are going to be blocked by the highest value since it is easiest form to know if tree is visible
	static int[] top;
	static int left;
	//Bottom and right values are going to be blocked by position rather than value since it will demand less calculations.
	static int[] bottom;
	static int right;
	
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
		top=new int[cols];
		for (int i = 0; i < top.length; i++) {
			top[i]=-1;
		}
		bottom=new int[cols];
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
		int count=0;
		int[] row;
		int[] absoluts=new int[cols];
		for (int i = 0; i < absoluts.length; i++) {
			absoluts[i]=9;
		}
		//Process table row per row
		for (int j = 0; j < table.length; j++) {
			int abs_max=9;
			row=table[j];
			left=-1;
			right=0;
			for (int i = 0; i < row.length; i++) {
				boolean valid=false;
				if(row[i]>left) {
					left=row[i];
					valid=true;
				}
				if(row[i]>top[i]) {
					top[i]=row[i];
					valid=true;
				}
				if(i==right) {
					int max=-1;
					for (int k = row.length-1; k > i; k--) {
						if(row[k]>max) {
							right=k;
							if(row[k]==abs_max) break;
							max=row[k];
						}
					}
					abs_max=row[right]-1;
					valid=true;
				}
				if(j==bottom[i]) {
					int max=-1;
					for (int k = table.length-1; k > j; k--) {
						if(table[k][i]>max) {
							bottom[i]=k;
							if(table[k][i]==absoluts[i]) break;
							max=table[k][i];
						}
					}
					absoluts[i]=table[bottom[i]][i]-1;
					valid=true;
				}
				if(valid)
					count++;
			}
		}
		System.out.println(count);
	}
	
	
}
