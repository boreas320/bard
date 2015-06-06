import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.bard.davol.util.Directory;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;



public class TestFile {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        /*try {
            FileOutputStream output = new FileOutputStream(new File("E:\\other\\aa.zip"));
            ZipOutputStream zos = new ZipOutputStream(output);
            BufferedOutputStream out = new BufferedOutputStream(zos);
            
            List<String> filePathList = Directory.getFileList(new File("E:\\other\\psb.jpg"));
            for(String path : filePathList){
                System.out.println("path="+path);
                File temp = new File(path);
                if(!temp.exists()){
                    continue;
                }
                BufferedReader reader = new BufferedReader(new FileReader(
                        path));
                zos.putNextEntry(new ZipEntry(path));
                int c;
                while ((c = reader.read()) != -1) {
                    out.write(c);
                }
                reader.close();
                out.flush();
            }
            out.close();
            
            String path = "E:\\other\\psb.jpg";
            BufferedReader reader = new BufferedReader(new FileReader(
                    path));
            zos.putNextEntry(new ZipEntry(path));
            int c;
            while ((c = reader.read()) != -1) {
                out.write(c);
            }
            reader.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        try {
            long starttime = System.currentTimeMillis();
            ZipFile zipFile = new ZipFile("E:\\other\\bb.zip");
            zipFile.setFileNameCharset("GBK");
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            
            //ArrayList<File> fileList = new ArrayList<File>();
            //List<File> tempList = Directory.getFiles(new File("E:\\testzip"));
            //List<String> pathList = Directory.getFileList(new File("E:\\testzip"));
           // System.out.println(pathList);
           /* for(File file : tempList){
                if(file.exists()){
                    System.out.println("file=="+file);
                    fileList.add(file);
                }
            }*/
            //zipFile.addFile(new File("E:\\other\\psb.jpg"), parameters);
            //zipFile.addFiles(fileList, parameters);
            
            zipFile.addFolder("E:\\gaga", parameters);
            System.out.println("time="+(System.currentTimeMillis()-starttime));
        } catch (ZipException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        /*ZipFile zipFile;
        try {
            zipFile = new ZipFile("E:\\other\\cc.zip");
            ArrayList<File> filesToAdd = new ArrayList<File>();  
            filesToAdd.add(new File("E:\\other\\1406812429534-1-thumb.png"));  
            filesToAdd.add(new File("E:\\other\\1406812429534-1.png"));  
            filesToAdd.add(new File("E:\\other\\附件一.doc"));  
            filesToAdd.add(new File("E:\\other\\附件2：行业信息.xls"));  
              
            ZipParameters parameters = new ZipParameters();  
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);  
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);   
              
            zipFile.addFiles(filesToAdd, parameters);  
            
        } catch (ZipException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  */
    }
}
