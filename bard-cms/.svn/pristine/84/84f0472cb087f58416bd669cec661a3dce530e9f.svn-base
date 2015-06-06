 package com.bard.davol.util;
 
 import org.apache.commons.io.FilenameUtils;
 
 public class ExtendFilenameUtils extends FilenameUtils
 {
   public static String getLastFolderPathNoEndSeparator(String filename)
   {
     String path = getFullPathNoEndSeparator(filename);
     int index = indexOfLastSeparator(path);
     if (index < 0)
     {
       return filename.substring(0, getPrefixLength(filename));
     }
     return path.substring(index + 1);
   }
   
   public static String getLastFolderPath(String folderPath){
	   String path = getFullPathNoEndSeparator(folderPath);
	   int index = indexOfLastSeparator(path);
       if (index < 0){
    	   return folderPath.substring(0, getPrefixLength(folderPath));
       }
	   return path.substring(0,index + 1);
   }
   
   public static void main(String[] args) {
	  String path = "D:\\bard\\other\\测试文件夹1\\";
	  System.out.println(getLastFolderPath(path));
   }
}

