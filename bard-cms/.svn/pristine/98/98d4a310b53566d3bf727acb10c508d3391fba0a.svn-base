package com.bard.davol.serviceImpl;

import com.bard.davol.entity.FileItem;
import com.bard.davol.entity.FileTree;
import com.bard.davol.exception.FileHasBeenModifiedException;
import com.bard.davol.service.FileService;
import com.bard.davol.util.CommonUtil;
import com.bard.davol.util.ExtendFilenameUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileServiceImpl
        implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String fomatRootFilePath() {
        String filePath = CommonUtil.getValue("rootDir");
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        filePath = FilenameUtils.getFullPath(filePath);
        filePath = FilenameUtils.normalize(filePath);
        return filePath;
    }

    public List<FileTree> getFolderList() {
        String rootPath = fomatRootFilePath();
        FileTree root = new FileTree();
        root.setFolderpath(fomatRootFilePath());
        root.setFoldername(ExtendFilenameUtils.getLastFolderPathNoEndSeparator(rootPath));
        root.setChildren(getChildrenFolderPaths(root));

        List filePathTree = new ArrayList();
        filePathTree.add(root);
        return filePathTree;
    }

    private List<FileTree> getChildrenFolderPaths(FileTree parent) {
        List<FileTree> children = new ArrayList<FileTree>();
        File[] files = new File(parent.getFolderpath()).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    String path = file.getPath() + File.separator;
                    FileTree fileTree = new FileTree();
                    fileTree.setFoldername(ExtendFilenameUtils.getLastFolderPathNoEndSeparator(path));
                    fileTree.setFolderpath(path);
                    List childrenList = getChildrenFolderPaths(fileTree);
                    if ((childrenList != null) && (childrenList.size() > 0)) {
                        fileTree.setChildren(getChildrenFolderPaths(fileTree));
                    }
                    children.add(fileTree);
                    logger.info(path);
                }
            }
            return children;
        }
        return null;
    }

    public List<FileItem> listFilesByFolder(String folderPath) {
        List<FileItem> files = new ArrayList<FileItem>();

        List<FileItem> firstFiles = new ArrayList<FileItem>();
        List<FileItem> endFiles = new ArrayList<FileItem>();

        File folderFile = new File(folderPath);
        File[] filesArray = folderFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.startsWith(".");
            }
        });


        for (File file : filesArray) {
            FileItem fi = new FileItem();
            fi.setLashmodifydate(new Date(file.lastModified()));
            if (file.isDirectory()) {
                fi.setIsfolder(true);
                fi.setSize(Long.valueOf(FileUtils.sizeOfDirectory(file)));
                fi.setFilename(ExtendFilenameUtils.getLastFolderPathNoEndSeparator(file.getPath() + File.separator));
                fi.setFolderpath(ExtendFilenameUtils.getFullPath(file.getPath() + File.separator));
                if (fi.getFilename().contains("_1")) {
                    fi.setType(Integer.valueOf(1));
                } else if (fi.getFilename().contains("_2")) {
                    fi.setType(Integer.valueOf(2));
                } else if (fi.getFilename().contains("_3")) {
                    fi.setType(Integer.valueOf(3));
                }
                firstFiles.add(fi);
            } else {
                fi.setIsfolder(false);
                fi.setFolderpath(ExtendFilenameUtils.getFullPath(file.getPath()));
                fi.setBasename(ExtendFilenameUtils.getBaseName(file.getName()));
                fi.setExtension(ExtendFilenameUtils.getExtension(file.getName()));
                fi.setIshidden(file.isHidden());
                fi.setFilename(file.getName());
                fi.setSize(Long.valueOf(file.length()));
                String fileName = file.getName();

                if (fileName.contains("_n")) {
                    fi.setSend(Integer.valueOf(0));
                }
                if (fileName.contains("_y")) {
                    fi.setSend(Integer.valueOf(1));
                }
                endFiles.add(fi);
            }
        }
        if (firstFiles != null && !firstFiles.isEmpty()) {
            files.addAll(firstFiles);
        }
        if (endFiles != null && !endFiles.isEmpty()) {
            files.addAll(endFiles);
        }
        return files;
    }

    public FileItem getFile(String folderPath, String fileName, String isFolder) {
        FileItem fileItem = new FileItem();
        if ("true".equals(isFolder)) {
            fileItem.setFolderpath(folderPath);
            fileItem.setFilename(fileName);
            fileItem.setIsfolder(true);
            if (fileName.contains("_1"))
                fileItem.setType(Integer.valueOf(1));
            else if (fileName.contains("_2"))
                fileItem.setType(Integer.valueOf(2));
            else if (fileName.contains("_3"))
                fileItem.setType(Integer.valueOf(3));
        } else {
            File file = new File(folderPath, fileName);
            if (file.exists()) {
                fileItem.setFolderpath(ExtendFilenameUtils.getFullPath(file.getPath()));
                fileItem.setFilename(file.getName());
                fileItem.setIsfolder(false);
                String fName = file.getName();
                if (fName.contains("_n")) {
                    fileItem.setSend(Integer.valueOf(0));
                }
                if (fName.contains("_y")) {
                    fileItem.setSend(Integer.valueOf(1));
                }
            }
        }
        return fileItem;
    }

    public synchronized  String processFile(String folderPath, String fileName, Integer type, Integer send, String isFolder) {
        String path = CommonUtil.getValue("rootDir");
        if ("false".equals(isFolder)) {
            File filePath = new File(folderPath, fileName);
            if (!filePath.exists()) {
                throw new FileHasBeenModifiedException();
            }
            StringBuilder buf = new StringBuilder(fileName);
            int index = buf.indexOf(".");
            String isSend = (send.intValue() == 1) ? "y" : "n";
            if (buf.indexOf("_") < 0)
                buf.insert(index, "_" + isSend);
            else {
                buf.replace(buf.indexOf("_"), index, "_" + isSend);
            }
            String newFileName = buf.toString();
            logger.error("newFileName====" + newFileName);
            File newFilePath = new File(folderPath, newFileName);
            boolean flag = filePath.renameTo(newFilePath);
            logger.error("flag==="+flag);


//            com.bard.davol.util.FileUtils.copyFile(filePath, newFilePath);
//            if (filePath.exists() && !filePath.getAbsolutePath().equals(newFilePath.getAbsolutePath())) {
//                com.bard.davol.util.FileUtils.deleteAll(filePath);
//            }
            path = folderPath;
        } else {
            File dirPath = new File(folderPath);
            if (!dirPath.exists()) {
                throw new FileHasBeenModifiedException();
            }
            StringBuilder buf = new StringBuilder(fileName);
            if (fileName.indexOf("_") < 0)
                buf.append("_" + type);
            else {
                buf.replace(buf.indexOf("_"), buf.length() + 1, "_" + type);
            }
            String newFileName = buf.toString();
            int index = folderPath.indexOf(fileName);
            String dir = folderPath.substring(0, index);
            String newDirPath = dir + newFileName + File.separator;
            logger.error("newDirPath===" + newDirPath);
            File newDir = new File(newDirPath);
//            com.bard.davol.util.FileUtils.copyDirectiory(folderPath, newDirPath);
   /*   if(dirPath.exists()){
          com.bard.davol.util.FileUtils.deleteAll(dirPath);
      }*/
            boolean flag = dirPath.renameTo(newDir);
            logger.error("flag==="+flag);
            path = dir;
        }
        return path;
    }
}