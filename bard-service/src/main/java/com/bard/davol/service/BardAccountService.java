package com.bard.davol.service;

import com.bard.davol.bean.Usertoken;
import java.util.Map;

public interface BardAccountService
{
  public  Usertoken getUsertoken(String udid);

  public  int saveUsertoken(String udid, String utoken);

  public  Map<String, Object> loginByUdid(String udid, String utoken);

  public  boolean isValidUtoken(String utoken);
}