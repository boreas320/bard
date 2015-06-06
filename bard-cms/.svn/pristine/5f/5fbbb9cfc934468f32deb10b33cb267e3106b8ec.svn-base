 package com.bard.davol.util;
 
 import java.io.File;
 import java.io.FilenameFilter;
 import java.io.PrintStream;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 
 public class Directory
 {
          
 
   static TreeInfo recurseDirs(File startDir)
   {
     TreeInfo result = new TreeInfo();
    for (File item : startDir.listFiles()) {
       if (item.isDirectory()) {
         result.dirs.add(item);
         result.addAll(recurseDirs(item));
       }
       else {
        result.files.add(item);
       }
     }
     return result;
   }
 
   public static String processFile(File file) {
     StringBuilder buf = new StringBuilder(file.getName());
     String fileName = file.getName();
         int index = fileName.indexOf('.');
        if (index != -1) {
           buf.insert(index, "-" + file.lastModified());
     }
         return buf.toString();
   }
 
   public static String getFilePaths(File dir) {
         TreeInfo treeInfo = recurseDirs(dir);
         List fileList = treeInfo.files;
         String filePaths = PPrint.pformat(fileList);
        return filePaths;
   }
 
   public static List<Map<String, String>> getFilePathMap(File dir) {
         List list = new ArrayList();
        TreeInfo treeInfo = recurseDirs(dir);
            List<File> fileList = treeInfo.files;
            if ((fileList != null) && (fileList.size() > 0)) {
              for (File file : fileList) {
                if (!file.exists())
           continue;
                Map map = new HashMap();
                map.put("p", file.getPath());
                map.put("t", String.valueOf(file.lastModified()));
                list.add(map);
       }
     }
            return list;
   }
 
   public static List<String> getFileList(File dir) {
     TreeInfo treeInfo = recurseDirs(dir);
     List<File> fileList = treeInfo.files;
     List pathList = new ArrayList();
    for (File file : fileList) {
       pathList.add(file.getPath());
     }
     return pathList;
   }
 
   public static List<File> listFiles(File dir)
   {
	   TreeInfo treeInfo = recurseDirs(dir);
     List fileList = treeInfo.files;
    if ((fileList != null) && (fileList.size() > 0));
     return null;
   }
 
   public static List<File> getFiles(File dir)
   {
     TreeInfo treeInfo = recurseDirs(dir);
   return treeInfo.files;
   }
 
   public static List<File> getDirs(File dir) {
    TreeInfo treeInfo = recurseDirs(dir);
     return treeInfo.dirs;
   }
 
   public static void main(String[] args) {
     long starttime = System.currentTimeMillis();
    TreeInfo treeInfo = recurseDirs(new File("E:\\other"));
     long endtime = System.currentTimeMillis();
 
     System.out.println(getFilePathMap(new File("E:\\other")));
   }
 
   public static class TreeInfo
     implements Iterable<File>
   {
     public List<File> files;
     public List<File> dirs;
 
     public TreeInfo()
     {
       this.files = new ArrayList();
      this.dirs = new ArrayList();
     }
 
     public Iterator<File> iterator() {
      return this.files.iterator();
     }
 
     void addAll(TreeInfo other) {
      this.files.addAll(other.files);
       this.dirs.addAll(other.dirs);
     }
 
     public String toString() {
       return "dirs: " + PPrint.pformat(this.dirs) + "\n\nfiles: " + PPrint.pformat(this.files);
     }
   }
 }