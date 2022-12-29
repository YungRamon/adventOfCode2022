package day_5_Supply_Stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) throws FileNotFoundException {
		// Open file with contents
		//File file=new File("D:/fuentes_advent/5_ex.txt");
		File file=new File("D:/fuentes_advent/5.txt");
		Scanner reader=new Scanner(file);
		//ArrayList to save packages
		ArrayList<String> tmp=new ArrayList<>();
		//Get lines with crates
		while (!reader.hasNextInt()) {
			String line = reader.nextLine();
			while (line.matches(".*\\s{3}.*")) {
				line=line.replaceFirst("(?<!(\\u005D))\\s{3}", "empty\u005D");
			}
			tmp.add(line);
		}
		//Image of my crates
		char[][] crates=parseCrates(tmp);
		//Null useless object
		tmp=null;
		//Skip numbered and space line
		reader.nextLine();
		reader.nextLine();
		//Run every command
		while (reader.hasNextLine()) {
			String[] line=reader.nextLine().split(" ");
			int move=Integer.parseInt(line[1]);
			int from=Integer.parseInt(line[3])-1;
			int to=Integer.parseInt(line[5])-1;
			//Moving crates
			char[] moved=getArray(crates[from], move);
			crates[from]=reduce(crates[from], move);
			crates[to]=add(crates[to],moved);
		}
		reader.close();
		String result="";
		for (char[] pile : crates) {
			result+=pile[pile.length-1];
		}
		System.out.println(result);
	}
	
	//Method to transform ArrayList into the field
	public static char[][] parseCrates(ArrayList<String> description) {
		char[][] data=null;
		int size=description.size();
		for (String line : description) {
			String[] splited=line.split(" ");
			if (data==null) {
				data=new char[splited.length][0];
			}
			for (int i = 0; i < splited.length; i++) {
				if(!splited[i].equals("empty]")) {
					char crate=splited[i].toCharArray()[1];
					if (data[i].length==0) {
						data[i]=new char[size];
					}
					data[i][size-1]=crate;
				}
			}
			size--;
		}
		return data;
	}
	
	//Method to get array from another array by size in straight order
	public static char[] getArray(char[] source,int size) {
		char[] arr=new char[size];
		System.arraycopy(source, source.length-size, arr, 0, size);
		return arr;
	}
	
	//Method to reduce line of crates by the moved number
	public static char[] reduce(char[] victim, int take) {
		char[] res=new char[victim.length-take];
		System.arraycopy(victim, 0, res, 0, res.length);
		return res;
	}

	//Method to add array of characters at the end of another one
	public static char[] add(char[] to, char[] add) {
		char[] res=new char[to.length+add.length];
		System.arraycopy(to, 0, res, 0, to.length);
		System.arraycopy(add, 0, res, to.length, add.length);
		return res;
	}
}
