package day_7_No_Space_Left_On_Device;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) throws FileNotFoundException {
		// Open file with contents
		//File file=new File("D:/fuentes_advent/7_ex.txt");
		File file=new File("D:/fuentes_advent/7.txt");
		Scanner reader=new Scanner(file);
		//Node Cursor
		reader.nextLine();
		FileNode root=new FileNode("/", "dir", null);
		FileNode cur_node=root;
		//Reading Lines
		while (reader.hasNext()) {
			String[] line = reader.nextLine().split(" ");
			if(line[1].equals("cd")) {
				if(line[2].equals(".."))
					cur_node=cur_node.getParent();
				else
					cur_node=cur_node.getChildByName(line[2]);
			}
			else if(line[1].equals("ls")){
				while(reader.hasNext("[^$]+")) {
					line = reader.nextLine().split(" ");
					cur_node.addChild(line[1], line[0]);
				}
			}
		}
		reader.close();
		long size=root.getSize();
		long toDelete=30000000-(70000000-size);
		System.out.println(root.getClosestSize(size, toDelete));
	}
}
