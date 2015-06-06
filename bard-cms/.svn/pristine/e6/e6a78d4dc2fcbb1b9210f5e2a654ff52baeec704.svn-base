     package com.bard.davol.action;
     
     import com.bard.davol.entity.UserToken;
     import com.bard.davol.service.UserService;
     import com.bard.davol.serviceImpl.LogicBeanFactory;
     import com.bard.davol.util.CommonUtil;
     import java.io.IOException;
     import java.util.HashMap;
     import java.util.Map;
     import javax.servlet.ServletException;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;
     import net.sf.json.JSONObject;
     
     public class UserTokenServlet extends HttpServlet
     {
       private static final long serialVersionUID = -1222963340753883709L;
       private UserService userService;
     
       public UserTokenServlet()
       {
         this.userService = LogicBeanFactory.getUserService();
       }
     
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
       }
     
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException
       {
         Map resultMap = new HashMap();
         String udid = request.getParameter("udid");
         int tid = this.userService.checkUdid(udid);
         if (tid > 0) {
           resultMap.put("errCode", Integer.valueOf(1));
         } else {
           UserToken userToken = new UserToken();
           userToken.setUname(request.getParameter("uname"));
           userToken.setUdid(request.getParameter("udid"));
           String utoken = CommonUtil.genernateUsertoken();
           userToken.setUtoken(utoken);
           userToken.setStatus("0");
           String type = request.getParameter("userType");
           userToken.setUserType(type);
           this.userService.addUsertoken(userToken);
           resultMap.put("errCode", Integer.valueOf(0));
         }
         CommonUtil.sendJson(response, JSONObject.fromObject(resultMap).toString());
       }
     }