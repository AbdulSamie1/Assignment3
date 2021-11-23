import java.util.*;
import java.io.*; 
import java.util.Scanner;
class importingfiles extends Exception implements Runnable {
	BinarySearchTree tree = new BinarySearchTree();
	public int cVocab = 0;
	public String[] vocab;
	int cInp1 = 0;
	public String[] input1;
	public String[] input2;
	String iPath = null;
	String inSTR1 = null;
	String inSTR2 = null;
	String vocabSTR = null;
	int cVoc = 0;
	int choice  = 0;
	public String vPath = null;
	importingfiles(String message, String VOCpath,String inPath, int cUser){
		super(message);
		vPath = VOCpath;
		iPath = inPath;
		choice = cUser;
	}
	
	public void writingFile(String path) {
		try {
			
			BufferedWriter  bw = new BufferedWriter(
					new FileWriter(path));
			bw.write("The rain and wind abruptly stopped, but the sky still had the gray swirls of storms in the distance. Dave knew this feeling all too well. The calm before the storm. He only had a limited amount of time before all Hell broke loose, but he stopped to admire the calmness. Maybe it would be different this time, he thought, with the knowledge deep within that it wouldn't.");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void vocabfetchingFiles() {
		try {
			File file = new File(vPath);
			BufferedReader ln1
            = new BufferedReader(new FileReader(file));
			String tmp1;
			cVoc = 0;
			while((tmp1 = ln1.readLine())!= null){
				if(cVoc > 0) {
					vocabSTR = vocabSTR.concat(" ");
					vocabSTR = vocabSTR + tmp1;
				}
				else if(cVoc == 0) {
					vocabSTR = tmp1;
				}
				cVoc++;
			}
			ln1.close();
			int vLength = 0;
			vocabSTR = vocabSTR.toLowerCase();
			vLength = vocabSTR.length();
			char vChr;
			int spacesCount = 0;
			//System.out.println(vLength);
			for(int i=0;i<vLength;i++) {
				vChr = vocabSTR.charAt(i);
				if(vChr == ' ') {
					spacesCount++;
				}
			}
			///System.out.println(spacesCount);
			spacesCount = spacesCount+1;
			vocab = new String[spacesCount];
			String tmpStr = null;
			cVoc = 0;
			for(int i=0,j = 0;i<vLength;i++) {
				vChr = vocabSTR.charAt(i);
				if(((int)vChr > 32 && (int)vChr < 65) || ((int)vChr > 122 && (int)vChr < 127)) {
					cVoc++;
				}else if(vChr == ' ') {
					if(j<spacesCount) {
						vocab[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}else {
					if(cVoc == 0) {
						tmpStr = Character.toString(vChr);
						cVoc++;
					}else {
						tmpStr = tmpStr + Character.toString(vChr);
					}
				}
				if(i+1 == vLength) {
					if(j<spacesCount) {
						vocab[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}
			}
//			for(int  i=0;i<spacesCount;i++) {
//				System.out.println(i+ " "+vocab[i] + " ");
//			}
			String forBST;
			for(int i=0;i<spacesCount;i++) {
				forBST = vocab[i];
				tree.add(forBST);
				//System.out.print(i);
			}
			cVocab = spacesCount;
			
			//tree.display("inOrder");
			
		} catch (Exception e) {
			System.out.println("File not found!\n");
		}
	}
	
	//String iPath = null;
	//public String[] input1;
	//String inSTR1 = null;
	//int cVoc = 0;
	Vector<String> v = new Vector<String>();
	int looptime = 0;
	public void input1fetchingFiles() {
		try {
			File file = new File(iPath);
			BufferedReader ln1
            = new BufferedReader(new FileReader(file));
			String tmp1;
			cVoc = 0;
			while((tmp1 = ln1.readLine())!= null){
				if(cVoc > 0) {
					inSTR1 = inSTR1.concat(" ");
					inSTR1 = inSTR1 + tmp1;
				}
				else if(cVoc == 0) {
					inSTR1 = tmp1;
				}
				cVoc++;
			}
			ln1.close();
			int vLength = 0;
			vLength = inSTR1.length();
			char vChr;
			int spacesCount = 0;
			//System.out.println(vLength);
			for(int i=0;i<vLength;i++) {
				vChr = inSTR1.charAt(i);
				if(vChr == ' ') {
					spacesCount++;
				}
			}
			//System.out.println(spacesCount);
			spacesCount = spacesCount+1;
			input1 = new String[spacesCount];
			String tmpStr = null;
			cVoc = 0;
			for(int i=0,j = 0;i<vLength;i++) {
				vChr = inSTR1.charAt(i);
				if(((int)vChr > 32 && (int)vChr < 65) || ((int)vChr > 122 && (int)vChr < 127)) {
					cVoc++;
				}else if(vChr == ' ') {
					if(j<spacesCount) {
						input1[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}else {
					if(cVoc == 0) {
						tmpStr = Character.toString(vChr);
						cVoc++;
					}else {
						tmpStr = tmpStr + Character.toString(vChr);
					}
				}
				if(i+1 == vLength) {
					if(j<spacesCount) {
						input1[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}
			}
		
			looptime = spacesCount;
			for(int i=0;i<spacesCount;i++) {
				//System.out.println(i+ " "+input1[i] + " ");
				v.add(input1[i]);
			}
			for(int  i=0;i<v.size();i++) {
				//System.out.println(i+ " "+input1[i] + " ");
		//		System.out.println(v.get(i) + " ");
			}
		} catch (Exception e) {
			System.out.println("File not found!\n");
		}
	}
	
	Vector<String> vStr = new Vector<String>();
	Vector<Integer> vHz = new Vector<Integer>();
	String tmp1 = null;
	int tmp2 = 0;
	boolean checkSTR = false;
	void Evaluation() throws Exception{
		//tree.display("inOrder");
		///System.out.println(v.size());
		for(int i=0;i<v.size();i++) {
			tmp1 = v.get(i);
			//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
			if(tree.findNode(tmp1) == true) {
				//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
				for(int j = 0; j<vStr.size();j++) {
					//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
					if(vStr.get(j).equals(tmp1) == true) {
						//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
						checkSTR = true;
						
						tmp2 = vHz.get(j);
						tmp2 = tmp2+1;
						vHz.setElementAt(tmp2, j);
						j = vStr.size();
					}
					//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
				}
				//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
				if(checkSTR == false) {
					//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
					vStr.add(tmp1);
					vHz.add(1);
				}
			}
			checkSTR = false;
			tmp2 = 0;
		}
		
		for(int i=0;i<vStr.size();i++) {
			System.out.println("Word(founded): " + vStr.get(i));
			System.out.println("Occurance: " + vHz.get(i));
		}
	}
	
    public void run()
    {
        try {
        	//System.out.println("for : "+iPath + "\n");
        	vocabfetchingFiles(); 
        	if(choice == 1) {
        		System.out.println("Displaying tree(inroder): \n");
        		tree.display();
        	}
        	input1fetchingFiles();
        	if(choice == 2) {
        		System.out.println("Displaying from vectors: \n");
        		for(int i=0;i<v.size();i++) {
        			System.out.println(i + ": " + v.get(i));
        		}
        	}
        	if(choice == 3) {
            	Evaluation();	
        	}
        }
        catch (Exception e) {
            return;
        }
    }
}

class query extends Exception implements Runnable{
	BinarySearchTree tree = new BinarySearchTree();
	public int cVocab = 0;
	public String[] vocab;
	int cInp1 = 0;
	public String[] input1;
	public String[] input2;
	String iPath = null;
	String inSTR1 = null;
	String inSTR2 = null;
	String vocabSTR = null;
	int cVoc = 0;
	int choice  = 0;
	public String vPath = null;
	query(String message, String VOCpath,String inPath){
		super(message);
		vPath = VOCpath;
		iPath = inPath;
		//choice = cUser;
	}
	
	Scanner in = new Scanner(System.in);
	public void vocabfetchingFiles() {
		try {
			System.out.println("Enter a string for query. \n");
			iPath = in.nextLine();
			iPath = iPath.toLowerCase();
			File file = new File(vPath);
			BufferedReader ln1
            = new BufferedReader(new FileReader(file));
			String tmp1;
			cVoc = 0;
			while((tmp1 = ln1.readLine())!= null){
				if(cVoc > 0) {
					vocabSTR = vocabSTR.concat(" ");
					vocabSTR = vocabSTR + tmp1;
				}
				else if(cVoc == 0) {
					vocabSTR = tmp1;
				}
				cVoc++;
			}
			ln1.close();
			int vLength = 0;
			vLength = vocabSTR.length();
			char vChr;
			int spacesCount = 0;
			//System.out.println(vLength);
			for(int i=0;i<vLength;i++) {
				vChr = vocabSTR.charAt(i);
				if(vChr == ' ') {
					spacesCount++;
				}
			}
			///System.out.println(spacesCount);
			spacesCount = spacesCount+1;
			vocab = new String[spacesCount];
			String tmpStr = null;
			cVoc = 0;
			for(int i=0,j = 0;i<vLength;i++) {
				vChr = vocabSTR.charAt(i);
				if(((int)vChr > 32 && (int)vChr < 65) || ((int)vChr > 122 && (int)vChr < 127)) {
					cVoc++;
				}else if(vChr == ' ') {
					if(j<spacesCount) {
						vocab[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}else {
					if(cVoc == 0) {
						tmpStr = Character.toString(vChr);
						cVoc++;
					}else {
						tmpStr = tmpStr + Character.toString(vChr);
					}
				}
				if(i+1 == vLength) {
					if(j<spacesCount) {
						vocab[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}
			}
//			for(int  i=0;i<spacesCount;i++) {
//				System.out.println(i+ " "+vocab[i] + " ");
//			}
			String forBST;
			for(int i=0;i<spacesCount;i++) {
				forBST = vocab[i];
				tree.add(forBST);
				//System.out.print(i);
			}
			cVocab = spacesCount;
			
			//tree.display("inOrder");
			
		} catch (Exception e) {
			System.out.println("File not found!\n");
		}
	}
	
	//String iPath = null;
	//public String[] input1;
	//String inSTR1 = null;
	//int cVoc = 0;
	Vector<String> v = new Vector<String>();
	int looptime = 0;
	public void input1fetchingFiles() {
		//try {
			inSTR1 = iPath;
			int vLength = 0;
			vLength = inSTR1.length();
			char vChr;
			int spacesCount = 0;
			//System.out.println(vLength);
			for(int i=0;i<vLength;i++) {
				vChr = inSTR1.charAt(i);
				if(vChr == ' ') {
					spacesCount++;
				}
			}
			//System.out.println(spacesCount);
			spacesCount = spacesCount+1;
			input1 = new String[spacesCount];
			String tmpStr = null;
			cVoc = 0;
			for(int i=0,j = 0;i<vLength;i++) {
				vChr = inSTR1.charAt(i);
				if(((int)vChr > 32 && (int)vChr < 65) || ((int)vChr > 122 && (int)vChr < 127)) {
					cVoc++;
				}else if(vChr == ' ') {
					if(j<spacesCount) {
						input1[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}else {
					if(cVoc == 0) {
						tmpStr = Character.toString(vChr);
						cVoc++;
					}else {
						tmpStr = tmpStr + Character.toString(vChr);
					}
				}
				if(i+1 == vLength) {
					if(j<spacesCount) {
						input1[j] = tmpStr;
						tmpStr = null;
						cVoc = 0;
						j++;
					}
				}
			}
		
			looptime = spacesCount;
			for(int i=0;i<spacesCount;i++) {
				//System.out.println(i+ " "+input1[i] + " ");
				v.add(input1[i]);
			}
			for(int  i=0;i<v.size();i++) {
				//System.out.println(i+ " "+input1[i] + " ");
		//		System.out.println(v.get(i) + " ");
			}
		
	}
	
	Vector<String> vStr = new Vector<String>();
	Vector<Integer> vHz = new Vector<Integer>();
	String tmp1 = null;
	int tmp2 = 0;
	boolean checkSTR = false;
	void Evaluation() throws Exception{
		//tree.display("inOrder");
		///System.out.println(v.size());
		for(int i=0;i<v.size();i++) {
			tmp1 = v.get(i);
			//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
			if(tree.findNode(tmp1) == true) {
				//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
				for(int j = 0; j<vStr.size();j++) {
					//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
					if(vStr.get(j).equals(tmp1) == true) {
						//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
						checkSTR = true;
						
						tmp2 = vHz.get(j);
						tmp2 = tmp2+1;
						vHz.setElementAt(tmp2, j);
						j = vStr.size();
					}
					//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
				}
				//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
				if(checkSTR == false) {
					//System.out.println(tmp1+" "+i+ " " + tree.findNode(tmp1));
					vStr.add(tmp1);
					vHz.add(1);
				}
			}
			checkSTR = false;
			tmp2 = 0;
		}
		
		for(int i=0;i<vStr.size();i++) {
			System.out.println("Word(founded): " + vStr.get(i));
			System.out.println("Occurance: " + vHz.get(i));
		}
	}
	
	public void run() {
		try {

			vocabfetchingFiles(); 
			input1fetchingFiles();
			Evaluation();
		}catch(Exception e) {
			System.out.println("Encountered a problem....");
		}
		// TODO Auto-generated method stub
		
	}
	
}








 
