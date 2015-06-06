 package com.bard.davol.web;

 import com.bard.davol.bean.Usertoken;
 import com.bard.davol.service.BardAccountService;
 import com.bard.davol.service.LogicBeanFactory;
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
 public class LoginServlet extends HttpServlet
 {
   private static final long serialVersionUID = 5686963295345413127L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
   {
     doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
   {
     Map resMap = new HashMap();
     resMap.put("e", Integer.valueOf(500));
     BardAccountService accountService = LogicBeanFactory.getBardAccountService();
     String utoken = request.getParameter("utoken");
     String udid = request.getParameter("udid");
     if (StringUtils.isEmpty(udid)) {
       resMap.put("e", Integer.valueOf(401));
     }
     else if (StringUtils.isNotEmpty(utoken)) {
       boolean isValid = accountService.isValidUtoken(utoken);
       resMap.put("isValid", Boolean.valueOf(isValid));
       if (isValid) {
         Map map = accountService.loginByUdid(udid, utoken);
         if ((map != null) && (map.size() > 0)) {
           resMap.putAll(map);
         }
       }
       resMap.put("e", Integer.valueOf(0));
     }
     else
     {
       Usertoken userToken = accountService.getUsertoken(udid);
       if ((userToken != null) && (userToken.getUtoken() != null)) {
         resMap.put("utoken", userToken.getUtoken());
         resMap.put("level", userToken.getLevel());
         resMap.put("e", Integer.valueOf(0));
       }
     }

     ObjectMapper mapper = new ObjectMapper();
     String returnStr = mapper.writeValueAsString(resMap);
     response.getWriter().print(returnStr);
   }
 }

/* Location:           D:\新建文件夹\bard-service-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.web.LoginServlet
 * JD-Core Version:    0.5.4
 */