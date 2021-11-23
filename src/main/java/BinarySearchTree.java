import java.util.*;
public class BinarySearchTree{
	String data;
	BinarySearchTree parent;  
	BinarySearchTree left;    
	BinarySearchTree right;   

	static int szie=0; 
	static BinarySearchTree root; 

	public BinarySearchTree(){
		parent=null;
		left=null;
		right=null;
	}	
	public void add(String str){
		BinarySearchTree node = new BinarySearchTree();
		node.data=str;
		
		if(szie==0){
			root=node;
		}
		else{
			BinarySearchTree temp = root;
			while(temp!=null){
				if(temp.data.equals(str)) {
					//System.out.println("Duplicate found!");
					break;
				}
				if(temp.data.compareTo(str)>0){
					if(temp.right==null){
						temp.right=node;
						node.parent=temp;
						break;
					}
					else{
						temp=temp.right;
						continue;
					}
				}
				if(temp.data.compareTo(str)<0){
					if(temp.left==null){
						temp.left=node;
						node.parent=temp;
						break;
					}
					else{
						temp=temp.left;
						continue;
					}
				}
			}
		}
		szie++;
	}
	public void display() throws Exception {
		System.out.print("The Tree is : ");
		if(root==null){
			System.out.println("Tree is empty...");
			return;
		}
			inOrderDisplay(root);
			System.out.println();
	}
	private BinarySearchTree inOrderDisplay(BinarySearchTree root){
		if(root==null){
			return root;
		}
		inOrderDisplay(root.left);
		System.out.print(root.data + " ");
		inOrderDisplay(root.right);
		return root;
	}
	public boolean findNode(String str)throws Exception{
		if(root==null){
			throw new Exception("Empty tree!");
		}
		BinarySearchTree temp = root;
		boolean result=false;
		while(temp!=null){
			if(temp.data.equals(str) == true){
				result=true;
				break;
			}
			if(temp.data.compareTo(str)<0){
				temp=temp.left;
				continue;
			}
			if(temp.data.compareTo(str)>0){
				temp=temp.right;
				continue;
			}
		}
		if(result==false){
			return false;
		}
		else{
			return true;
		}
	}
}