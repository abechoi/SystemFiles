import java.util.Scanner;
import java.io.*;

public class Main{

	public static void main(String[] args) {
		
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);
		SystemFunction sf = new SystemFunction();
		String logName = "out";
		String concName = "concatenate";
		String name = "";
		String file1 = "";
		String file2 = "";
		String tempStr = "";
		int option = 0;
		char choice = ' ';
		String menu = " 1) List the contents of a directory provided by the user";
		menu += "\n 2) List the contents of a directory provided by the user\n    as well as all of its sub directories.";
		menu += "\n 3) Locate a file with a given name.";
		menu += "\n 4) Locate files with a given file extension";
		menu += "\n 5) Concatenate the contents of 2 files whose names are provided\n    by the user and output the result to a third file";
		menu += "\n 6) Exit \n";

		System.out.println("Would you like to dump results into a log file? [y/n]");
		choice = sc.next().charAt(0);

		if(choice == 'y'){
			System.out.println("Name the log file: ");
			logName = sc.next();
		}

		
		while(option != 6){
			System.out.println(menu);
			option = sc.nextInt();
			try{
				//pw = new PrintWriter(new FileWriter(logName+".txt"));
				pw = new PrintWriter(new FileWriter(logName+".txt"));
				switch(option){
					case 1: 
						// Get contents of dir WORKS!
						System.out.println("Enter directory: ");
						name = sc.next();
						tempStr += sf.printAllFiles("/Users/Sushiko/Desktop/"+name); 
						break;

					case 2:	
						// Get contents and subdir of dir WORKS!
						System.out.println("Enter directory name: ");
						name = sc.next();
						tempStr += sf.listFiles("/Users/Sushiko/Desktop/"+name); 
						break;

					case 3:
						// Return path of file WORKS!
						System.out.println("Enter file name: ");
						name = sc.next();
						tempStr += sf.printPath(name);
						break;

					case 4:
						// Return path of extensions WORKS!
						System.out.println("Enter extension");
						name = sc.next();
						tempStr += sf.filesByExtension(name); 
						break;
					case 5:
						// Combine 2 files into 1 WORKS!
						System.out.println("Enter first filename: ");
						file1 = sc.next();
						System.out.println("Enter second filename: ");
						file2 = sc.next();
						System.out.println("Name the log file: ");
						concName = sc.next();
						sf.concatenate(file1,file2,concName); 
						System.out.println("file 1: "+file1+" and file 2: "+file2+" has been combined into concatenate.txt");
						break;

					}// END SWITCH
				}// END TRY
			catch(IOException e){e.printStackTrace();}
		}// END WHILE LOOP
		pw.write(tempStr);
		pw.close();
	}// END MAIN
} // END CLASS
