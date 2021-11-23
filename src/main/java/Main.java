import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
//		for(int i = 0 ; i < args.length ; i++) {
//			System.out.println(args[i]);
//		}
//		
		Scanner in = new Scanner(System.in);
		int var=0;
		System.out.println("1) Displaying BST build from Vocabulary File.\n");
		System.out.println("2) Displaying Vectors build from Input files.\n");
		System.out.println("3) Viewing Match words and its frequency.\n");
		System.out.println("4) Searching a query->It should display all the files query found in.\n");
		System.out.println("5) Enter 5 for Exiting.\n");
		var = in.nextInt();
		String str=null;
		if(var == 5) {
			System.out.println("Quiting the program...Thank you!!!\n");
		}
		
		if(var>0 && var<4) {
			for(int i=1;i<args.length;i++) {
				importingfiles vocabulary = new importingfiles(null,args[0],args[i],var);
		        Thread vocabularyThread = new Thread(vocabulary);
		        vocabularyThread.start();
			}
		}
		
		if(var == 4) {
			
			query vocabulary = new query(null,args[0],str);
	        Thread vocabularyThread = new Thread(vocabulary);
	        vocabularyThread.start();
		}
	}

}
