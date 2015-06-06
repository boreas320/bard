 package com.bard.davol.util;

 import java.util.ResourceBundle;
 import org.apache.commons.codec.digest.DigestUtils;

 public class CommonUtil
 {
   public static final String CREDENTIAL_SEC_KEY = "bard-davol-qawsedazsxdc1q2w3eplokij0o9i8u";
   public static long LRU_CACHE_TIME = 1800000L;
   public static int LRU_MAX_ENTRIES = 10000000;

   public static String INVALID = "1";
   public static String VALID = "0";

   public static String calculateUToken(String udid, String credential) {
     return DigestUtils.md5Hex(udid + "^" + credential);
   }

   public static String getValue(String key) {
     ResourceBundle bundle = ResourceBundle.getBundle("config");
     String value = bundle.getString(key);
     return value;
   }
 }

/* Location:           D:\新建文件夹\bard-service-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.util.CommonUtil
 * JD-Core Version:    0.5.4
 */