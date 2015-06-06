package com.bard.davol.entity;

import com.bard.davol.util.ReflectUtil;
import java.util.Date;

public class FileItem
{
  private String filename;
  private String extension;
  private String basename;
  private String folderpath;
  private Long size;
  private boolean ishidden;
  private boolean isfolder;
  private Date lashmodifydate;
  private Integer type = 0;
  private Integer send = 1;

  public FileItem(){
	  
  }
  
  public Date getLashmodifydate() {
	  return this.lashmodifydate; 
  }

  public void setLashmodifydate(Date lashmodifydate) {
    this.lashmodifydate = lashmodifydate;
  }
  public boolean isIshidden() {
    return this.ishidden;
  }
  public void setIshidden(boolean ishidden) {
    this.ishidden = ishidden;
  }
  public boolean isIsfolder() {
    return this.isfolder;
  }
  public void setIsfolder(boolean isfolder) {
    this.isfolder = isfolder;
  }
  public String getFilename() {
    return this.filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }
  public String getExtension() {
    return this.extension;
  }
  public void setExtension(String extension) {
    this.extension = extension;
  }
  public String getBasename() {
    return this.basename;
  }
  public void setBasename(String basename) {
    this.basename = basename;
  }
  public String getFolderpath() {
    return this.folderpath;
  }
  public void setFolderpath(String folderpath) {
    this.folderpath = folderpath;
  }
  public Long getSize() {
    return this.size;
  }
  public void setSize(Long size) {
    this.size = size;
  }
  public Integer getType() {
    return this.type;
  }
  public void setType(Integer type) {
    this.type = type;
  }
  public Integer getSend() {
    return this.send;
  }
  public void setSend(Integer send) {
    this.send = send;
  }

  public String toString() {
    return ReflectUtil.fieldsToString(this);
  }
}