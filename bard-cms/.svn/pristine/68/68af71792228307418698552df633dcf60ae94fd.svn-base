    package com.bard.davol.util;
    
    import java.io.IOException;
    import java.io.PrintStream;
    import java.io.PrintWriter;
    import java.util.ResourceBundle;
    import javax.servlet.http.HttpServletResponse;
    import org.apache.commons.lang.RandomStringUtils;
    import org.apache.commons.lang.StringUtils;
    
    public class CommonUtil
    {
      public static int parseInt(String src, int def)
      {
        if (StringUtils.isEmpty(src)) {
          return def;
        }
        int res = def;
        try {
          res = Integer.parseInt(src);
        } catch (Exception e) {
        }
        return res;
      }
    
      public static int parseInt(Object src, int def) {
        if (src == null) {
          return def;
        }
        return parseInt(src.toString(), def);
      }
    
      public static long parseLong(String src, long def) {
        if (StringUtils.isEmpty(src)) {
          return def;
        }
        long res = def;
        try {
          res = Long.parseLong(src);
        } catch (Exception e) {
        }
        return res;
      }
    
      public static double parseDouble(Object src, double def) {
        if (src == null) {
          return def;
        }
        return parseDouble(src.toString(), def);
      }
    
      public static double parseDouble(String src, double def) {
        if (StringUtils.isEmpty(src)) {
          return def;
        }
        double res = def;
        try {
          res = Double.parseDouble(src);
        } catch (Exception e) {
        }
        return res;
      }
    
      public static String genernateUsertoken() {
        String p1 = RandomStringUtils.randomAlphabetic(3).toLowerCase();
        String p2 = RandomStringUtils.randomNumeric(3);
        return p1 + p2;
      }
    
      public static String getValue(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("upload");
        String value = bundle.getString(key);
        return value;
      }
    
      public static void main(String[] args) {
        System.out.println("usertoken=" + genernateUsertoken());
      }
    
      public static void sendJson(HttpServletResponse response, String text) {
        try {
          response.setHeader("Cache-Control", "no-cache");
          response.setHeader("Pragma", "no-cache");
          response.setDateHeader("Expires", 0L);
          response.setContentType("application/json;charset=utf-8");
          response.getWriter().write(text);
          response.getWriter().flush();
          response.getWriter().close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    }