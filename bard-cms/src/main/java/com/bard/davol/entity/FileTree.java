    package com.bard.davol.entity;
    
    import com.bard.davol.util.ReflectUtil;
    import java.util.List;
    
    public class FileTree
    {
      private String foldername;
      private String folderpath;
      private List<FileTree> children;
    
      public String getFoldername()
      {
        return this.foldername;
      }
      public void setFoldername(String foldername) {
        this.foldername = foldername;
      }
      public List<FileTree> getChildren() {
        return this.children;
      }
      public void setChildren(List<FileTree> children) {
        this.children = children;
      }
      public String getFolderpath() {
        return this.folderpath;
      }
      public void setFolderpath(String folderpath) {
        this.folderpath = folderpath;
      }
    
      public String toString() {
        return ReflectUtil.fieldsToString(this);
      }
    }

/* Location:           D:\新建文件夹\bard-cms-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.entity.FileTree
 * JD-Core Version:    0.5.4
 */