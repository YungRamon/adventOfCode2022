package day_4_Camp_Cleanup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) throws FileNotFoundException {
		// Open file with contents
		//File file=new File("D:/fuentes_advent/4_ex.txt");
		File file=new File("D:/fuentes_advent/4.txt");
		Scanner reader=new Scanner(file);
		int cont=0;
		while (reader.hasNext()) {
			//Get the sectors
			 String[] sectores = reader.nextLine().split("(-|,)");
			 int[] nums=new int[sectores.length];
			 for (int i = 0; i < nums.length; i++) {
				nums[i]=Integer.valueOf(sectores[i]);
			}
			if((nums[0]>=nums[2] && nums[0]<=nums[3]) ||(nums[1]>=nums[2] && nums[1]<=nums[3]) || (nums[2]>=nums[0] && nums[3]<=nums[1])) 
				cont++;
		}
		reader.close();
		System.out.println(cont);
	}
}
