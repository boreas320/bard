package com.bard.davol.service;

import com.bard.davol.entity.FileItem;
import com.bard.davol.entity.FileTree;
import java.util.List;

public interface FileService
{
  List<FileTree> getFolderList();

  List<FileItem> listFilesByFolder(String paramString);

  String fomatRootFilePath();

  String processFile(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, String paramString3);

  FileItem getFile(String paramString1, String paramString2, String paramString3);
}