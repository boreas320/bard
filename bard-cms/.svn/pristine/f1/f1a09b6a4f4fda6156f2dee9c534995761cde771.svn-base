package com.bard.davol.action;

import com.bard.davol.entity.FileItem;
import com.bard.davol.exception.FileHasBeenModifiedException;
import com.bard.davol.service.FileService;
import com.bard.davol.serviceImpl.LogicBeanFactory;
import com.bard.davol.util.CommonUtil;
import com.bard.davol.util.ExtendFilenameUtils;
import com.bard.davol.util.FileUtils;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.json.JSONResult;
import org.apache.struts2.json.annotations.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@ParentPackage("struts-default")
@Namespace("/")
@Action("fileAction")
@Results({
        @Result(name = "fileList", location = "/fileList.jsp"),
        @Result(name = "fileInfo", location = "/fileInfo.jsp"),
        @Result(name = "zipSuccess", location = "/zipSuccess.jsp"),
        @Result(name = "zipFailure", location = "/zipFailure.jsp"),
        @Result(name = "fileUpdateError", location = "/fileUpdateError.jsp")})
public class FileAction {
    private static final Logger logger = LoggerFactory.getLogger(FileAction.class);
    private FileService fileService = LogicBeanFactory.getFileService();

    public String listFile() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String rootDir = CommonUtil.getValue("rootDir");
        String folderPath = request.getParameter("folderPath");
        if (StringUtils.isBlank(folderPath)) {
            folderPath = rootDir;
        }
        String lastFolder = ExtendFilenameUtils.getLastFolderPath(folderPath);
        if (lastFolder.length() < rootDir.length()) {
            lastFolder = rootDir;
        }
        logger.error("=====文件所在的目录为=====" + folderPath);
        List<FileItem> itemList = fileService.listFilesByFolder(folderPath);
        request.setAttribute("itemList", itemList);
        request.setAttribute("currentFolder", folderPath);
        request.setAttribute("lastFolder", lastFolder);
        return "fileList";
    }

    public String listDir() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String folderPath = (String) request.getAttribute("folderPath");
        if (StringUtils.isBlank(folderPath)) {
            folderPath = CommonUtil.getValue("rootDir");
        }
        List<FileItem> itemList = this.fileService.listFilesByFolder(folderPath);
        request.setAttribute("itemList", itemList);
        request.setAttribute("lastFolder", folderPath);
        return "fileList";
    }

    public String updateFile() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String folderPath = request.getParameter("folderPath");
        String fileName = request.getParameter("fileName");
        String isFolder = request.getParameter("isFolder");
        Integer fileType = Integer.valueOf(0);
        Integer send = Integer.valueOf(0);
        /*String fpath = folderPath;
        try {
			fpath = new String(folderPath.getBytes("GBK"),"cp1252");
			fileName = new String(fileName.getBytes("GBK"),"cp1252");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
        logger.error("=====修改的文件名为：：：=====" + folderPath);
        try {
            if ("true".equals(isFolder)) {
                fileType = Integer.valueOf(request.getParameter("fileType"));
                String path = fileService.processFile(folderPath, fileName,
                        fileType, send, isFolder);
                request.setAttribute("folderPath", path);
                return listDir();
            }
            send = Integer.valueOf(request.getParameter("sendType"));
            fileService.processFile(folderPath, fileName, fileType, send,
                    isFolder);
            return listFile();
        } catch (FileHasBeenModifiedException e) {


            return "fileUpdateError";
        }
    }

    public String getFile() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String folderPath = request.getParameter("folderPath");
        String fileName = request.getParameter("fileName");
        String isFolder = request.getParameter("isFolder");
        FileItem fileItem = this.fileService.getFile(folderPath, fileName,
                isFolder);
        request.setAttribute("fileItem", fileItem);
        return "fileInfo";
    }

    public String getZipFileProgress() {
        try {
            PrintWriter writer
                    = ServletActionContext.getResponse().getWriter();
            JSONObject jsonObject = new JSONObject();


            jsonObject.put("lastZipBeginTime", FileUtils.lastZipBeginTime);


            int status = -1;
            int percent = 0;

            if (FileUtils.progressMonitor != null) {

                status = FileUtils.progressMonitor.getResult();
                percent = FileUtils.progressMonitor.getPercentDone();

            }

            jsonObject.put("status", status);
            jsonObject.put("percent", percent);


            writer.print(jsonObject.toString());
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String zipFile() {
//        boolean flag = com.bard.davol.util.FileUtils.zipFile();
        ProgressMonitor progressMonitor = FileUtils.zipFile();

        HttpServletRequest request = ServletActionContext.getRequest();


        request.setAttribute("progressMonitor", progressMonitor);

//        if (flag) {
//
//            return "zipSuccess";
//        } else {
//            return "zipFailure";
//        }

        return "zipSuccess";

    }
}
