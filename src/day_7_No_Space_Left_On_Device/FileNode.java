package day_7_No_Space_Left_On_Device;

public class FileNode {
	
	public static final long LIMIT = 100000;
	public static long total=0;
	
	//I will use this form of node management
	private FileNode parent=null;
	private FileNode firstChild=null;
	private FileNode nextSibling=null;
	
	//Data of each node
	private long size;
	private String name;

	public FileNode(String name, String data, FileNode parent) {
		this.name=name;
		this.parent=parent;
		if(!data.equals("dir"))
			this.size=Long.parseLong(data);
	}
	
	public FileNode getParent() {
		return parent;
	}
	
	public FileNode getFirstChild() {
		return firstChild;
	}
	
	public FileNode getNextSibling() {
		return nextSibling;
	}
	
	public void setNextSibling(FileNode nextSibling) {
		this.nextSibling = nextSibling;
	}
	
	public String getName() {
		return name;
	}
	
	public FileNode getChildByName(String name) {
		FileNode node=this.firstChild;
		while (!node.getName().equals(name)) {
			node=node.getNextSibling();
		}
		return node;
	}
	
	public void addChild(String name, String data) {
		FileNode node=new FileNode(name, data, this);
		if(this.firstChild==null)
			this.firstChild=node;
		else {
			node.setNextSibling(this.firstChild);
			this.firstChild=node;
		}
	}

	public long getSize() {
		if(this.firstChild!=null) {
			long size=0;
			FileNode node=this.firstChild;
			while (node!=null) {
				size+=node.getSize();
				node=node.getNextSibling();
			}
			if (size<LIMIT) 
				total+=size;
			this.size=size;
			return size;
		}
		else {
			return this.size;
		}
	}
	
	public long getClosestSize(long size, long limit) {
		if(this.firstChild!=null ) {
			if (this.size>=limit && this.size<size) {
				size=this.size;
			}
			if(this.size>limit) {
				FileNode node=this.firstChild;
				while (node!=null) {
					size=node.getClosestSize(size, limit);
					node=node.getNextSibling();
				}
			}
			
		}
		return size;
	}

}
