package com.bard.davol.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.lingala.zip4j.progress.ProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class FileUtils {

	public static ProgressMonitor progressMonitor=null;
	public static Long lastZipBeginTime=-1l;

	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

	public synchronized  static ProgressMonitor zipFile(){
		 try {


			 if(progressMonitor==null||progressMonitor.getResult()!=ProgressMonitor.RESULT_WORKING) {
				 long starttime = System.currentTimeMillis();
				 lastZipBeginTime=starttime;
				 String zipPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
				 int i = zipPath.indexOf("work");
				 zipPath = zipPath.substring(0, i) + "webapps/upload/";
				 System.out.println("========zipPath=" + zipPath);
				 File udidFile = new File(zipPath + "bard.zip");
				 System.out.println("========udidFile=" + udidFile.getPath());
				 if (udidFile.exists())
					 udidFile.delete();
				 ZipFile zipFile = new ZipFile(udidFile);
				 //难道是因为加了编码？
//				 zipFile.setFileNameCharset("GBK");
				 //开启线程模式
				 zipFile.setRunInThread(true);

				 ZipParameters parameters = new ZipParameters();
				 parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
				 parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

				 String folderPath = CommonUtil.getValue("rootDir");
				 zipFile.addFolder(folderPath, parameters);

				 progressMonitor = zipFile.getProgressMonitor();

				 System.out.println("time=" + (System.currentTimeMillis() - starttime));
			 }

            return progressMonitor;
	     } catch (ZipException e) {
	    	logger.error("zip file failed.", e);
//	    	return false;
			 return  null;
	     }

	}

	// 复制文件
	public static void copyFile(File sourceFile, File targetFile){
		//同名文件就不要复制了
		if(sourceFile.getAbsolutePath().equals(targetFile.getAbsolutePath()))return;
		FileInputStream input = null;
		BufferedInputStream inBuff = null;
		FileOutputStream output = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			input = new FileInputStream(sourceFile);
			inBuff = new BufferedInputStream(input);

			// 新建文件输出流并对它进行缓冲
			output = new FileOutputStream(targetFile);
			outBuff = new BufferedOutputStream(output);

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();

			// 关闭流
			inBuff.close();
			outBuff.close();
			output.close();
			input.close();
		} catch (IOException e) {
			logger.error("close file failed.",e);
		} finally{
			closeIgnoringException(inBuff);
			closeIgnoringException(outBuff);
			closeIgnoringException(output);
			closeIgnoringException(input);
		}
		//为什么要在这删除呢
		if(sourceFile.exists()){
			deleteAll(sourceFile);
		}
	}

	private static void closeIgnoringException(Closeable c){
		if(c != null){
			try {
				c.close();
			} catch (IOException e) {
				// TODO There is nothing we can do if close fails.
			}
		}
	}

	// 复制文件夹
	public static void copyDirectiory(String sourceDir, String targetDir){
		//同名文件就不要复制了
		if(sourceDir.equals(targetDir))return;
		// 新建目标目录
		(new File(targetDir)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 源文件
				File sourceFile = file[i];
				// 目标文件
				File targetFile = new File(
						new File(targetDir).getAbsolutePath() + File.separator
								+ file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			if (file[i].isDirectory()) {
				// 准备复制的源文件夹
				String dir1 = sourceDir + "/" + file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + "/" + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
		File source = new File(sourceDir);
		if(source.exists()){
			deleteAll(source);
		}
	}

	public static void deleteAll(File file) {
		if(file == null){
			return;
		}
		if (file.isFile() || file.list().length == 0) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteAll(files[i]);
				files[i].delete();
			}
			if (file.exists()) {// 如果文件本身就是目录 ，就要删除目录
				file.delete();
			}
		}
	}
}  

