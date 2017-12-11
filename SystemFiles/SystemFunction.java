import java.io.*;

public class SystemFunction{

	String logName = "out";
	String currentPath;

	public SystemFunction(){
		currentPath = System.getProperty("user.dir");
		System.out.println(currentPath);
	}

	public void setCurrentPath(String path){
		currentPath = System.getProperty("user.dir");}

	public String getCurrentPath(){
		return currentPath;}

	// 1. Print all files in directory WORKS!
	public String printAllFiles(String path){
		String myStr = "";
		System.out.println(path);
		File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files){
            if (file.isFile()){
                myStr += file.getName()+"\n";
            }
        }
        return myStr;
	}

	// 2. Print contents of dir and subdir WORKS!
	public String listFiles(String path){
		String myStr = "";
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files){
            myStr += file.getName()+"\n";
        }
        return myStr;
    }

    // 3. Print path for any file WORKS!
    public String printPath(String fileName){
    	String myStr = "";
    	File file = new File(fileName);
    	String path = file.getAbsolutePath();
		myStr = "Path : " + file.getAbsolutePath()+"\n";
		return myStr;
    }

    // 4. Print files by extension WORKS!
    public String filesByExtension(String extension){
    	String myStr = "";
    	System.out.println(getCurrentPath());
    	File file = new File(getCurrentPath());
        File[] files = file.listFiles(new FilenameFilter() {
             
            @Override
            public boolean accept(File dir, String name){
                if(name.toLowerCase().endsWith("."+extension)){
                    return true;
                } else {
                    return false;
                }
            }
        });
        for(File f:files){
            myStr += f.getName()+"\n";
        }
        return myStr;
    }

    // 5. Combine 2 files into 1 WORKS!
    public void concatenate(String file1, String file2, String concName){

    	BufferedReader in1, in2;
    	PrintWriter pw = null;
    	String content1 = "", content2 = "";
        String logName = concName;
		String line;

    	try{
			in1 = new BufferedReader(new FileReader(file1));
			in2 = new BufferedReader(new FileReader(file2));
			pw = new PrintWriter(new FileWriter(logName+".txt"));

			while((line = in1.readLine()) != null){
			    content1 += line;}

			while((line = in2.readLine()) != null){
			    content2 += line;}

			pw.println(content1);
			pw.println(content2);
			pw.close();
		}
		catch(IOException e){e.printStackTrace();}
    }
}