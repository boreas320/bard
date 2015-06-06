 package com.bard.davol.web;

 import com.bard.davol.service.BardAccountService;
 import com.bard.davol.service.LogicBeanFactory;
 import com.bard.davol.util.FileUtils;
 import com.google.inject.Singleton;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.util.HashMap;
 import java.util.Map;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.commons.lang.StringUtils;
 import org.codehaus.jackson.map.ObjectMapper;

 @Singleton
 public class TransferFileServlet extends HttpServlet
 {
   private static final long serialVersionUID = -1227289479288860906L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
   {
     doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
   {
     Map resMap = new HashMap();
     ObjectMapper mapper = new ObjectMapper();
     resMap.put("e", Integer.valueOf(500));
     String udid = request.getParameter("udid");
     String utoken = request.getParameter("utoken");
     if ((StringUtils.isNotEmpty(udid)) && (StringUtils.isNotEmpty(utoken))) {
       BardAccountService accountService = LogicBeanFactory.getBardAccountService();
       boolean isValid = accountService.isValidUtoken(utoken);
       resMap.put("isValid", Boolean.valueOf(isValid));
       if (isValid) {
         Map map = accountService.loginByUdid(udid, utoken);
         if ((map != null) && (map.size() > 0)) {
           resMap.putAll(map);
           boolean isMatch = ((Boolean)map.get("isMatch")).booleanValue();
           if (isMatch) {
             String filePath = request.getParameter("filePath");
             if (StringUtils.isBlank(filePath)) {
               resMap.put("e", Integer.valueOf(401));
             } else {
               String[] filePaths = filePath.split(",");
               boolean isSuccess = FileUtils.processFilePath(filePaths, udid);
               if (isSuccess)
                 resMap.put("e", Integer.valueOf(0));
             }
           }
           else {
             resMap.put("e", Integer.valueOf(405));
           }
         }
       }
     } else {
       resMap.put("e", Integer.valueOf(401));
     }
     String returnStr = mapper.writeValueAsString(resMap);
     response.getWriter().print(returnStr);
   }
 }

/* Location:           D:\新建文件夹\bard-service-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.web.TransferFileServlet
 * JD-Core Version:    0.5.4
 */