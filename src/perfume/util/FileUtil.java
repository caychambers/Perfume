package perfume.util;

import java.io.File;
import java.util.ArrayList;

public class FileUtil {
	
	private static final String FILES_COUNT = "!!!!! files count: %s";
	private static final String DIR_NOT_EXIST = "????? directory %s not exist";
	
	private static ArrayList<String> filePath;
	
	public static void showAllJavaFilePath(String dirName) {
		getAllJavaFilePath(dirName);
		
		for (String path: filePath) {
			LogUtil.print(path);
		}
		
		LogUtil.print(
				String.format(
						FILES_COUNT, filePath.size()));
	}
	
	public static ArrayList<String> getAllJavaFilePath(String dirName) {
		filePath = new ArrayList<String>();
		getJavaFile(dirName);
		return filePath;
	}
	
	private static void getJavaFile(String dirName){ 
    	File dir = new File(dirName);
    	
    	if (!dir.exists()) {
    		LogUtil.print(
    				String.format(
    						DIR_NOT_EXIST, dirName));    		
    		return;
    	}
    	
    	File[] fileList = dir.listFiles();
    	
    	for (File file: fileList) {
    		String path = file.getAbsolutePath();
    		if (path.endsWith(".java")) {
    			filePath.add(file.getAbsolutePath());
            }
    		else if (file.isDirectory()){
    			getJavaFile(path);
    		}
    	}
    }
    
	public static ArrayList<String> getAllProjectName(String dirName) {
		File dir = new File(dirName);
		File[] fileList = dir.listFiles();
		ArrayList<String> projectNameList = new ArrayList<>();
    	
    	for (File file: fileList) {
    		if (file.isDirectory()){
    			projectNameList.add(file.getName());
    		}
    	}
    	
    	return projectNameList;
	}
}
