package com.bard.davol.action;

import com.bard.davol.entity.UserToken;
import com.bard.davol.service.UserService;
import com.bard.davol.serviceImpl.LogicBeanFactory;
import com.bard.davol.util.CommonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParentPackage("struts-default")
@Namespace("/")
@Action("userTokenAction")
@Results({@org.apache.struts2.convention.annotation.Result(name="userlist", location="/userlist.jsp"),
	      @org.apache.struts2.convention.annotation.Result(name="updUsertoken", location="/updUsertoken.jsp"),
	      @org.apache.struts2.convention.annotation.Result(name="addSuccess", location="/addSuccess.jsp"), 
	      @org.apache.struts2.convention.annotation.Result(name="updateSuccess", location="/updateSuccess.jsp"), 
	      @org.apache.struts2.convention.annotation.Result(name="addUsertoken", location="/addUsertoken.jsp"),
	      @org.apache.struts2.convention.annotation.Result(name="addFailure", location="/addFailure.jsp")})
public class UsertokenAction{
    private static final Logger logger = LoggerFactory.getLogger(UsertokenAction.class);
    private UserService userService =  LogicBeanFactory.getUserService();

  public String getUsertokenList() {
    HttpServletRequest request = ServletActionContext.getRequest();
    List<UserToken> userTokenList = userService.getUserTokenList();
    logger.error("======getUsertokenlist====" + userTokenList);
  /*  List<UserToken> validList = new ArrayList<UserToken>();
    List<UserToken> invalidList = new ArrayList<UserToken>();
    if ((userTokenList != null) && (userTokenList.size() > 0)) {
      for (UserToken userToken : userTokenList) {
        if ("0".equals(userToken.getStatus()))
          validList.add(userToken);
        else {
          invalidList.add(userToken);
        }
      }
    }
    userTokenList = new ArrayList<UserToken>();
    userTokenList.addAll(validList);
    userTokenList.addAll(invalidList);*/
    request.setAttribute("list", userTokenList);
    return "userlist";
  }

  public String addUsertoken() {
    Map<String,Integer> resultMap = new HashMap<String,Integer>();
    HttpServletRequest request = ServletActionContext.getRequest();

    String udid = request.getParameter("udid");
    String uname = request.getParameter("uname");
    String region = request.getParameter("region");
    String rank = request.getParameter("rank");
    if (StringUtils.isBlank(uname)) {
      JOptionPane.showMessageDialog(null, "员工号为空！");
      return "addUsertoken";
    }
    if (StringUtils.isBlank(udid)) {
      JOptionPane.showMessageDialog(null, "设备号为空！");
      return "addUsertoken";
    }
    int tid = this.userService.checkUdid(udid);
    if (tid > 0) {
      //JOptionPane.showMessageDialog(null, "设备号已经存在！");
      resultMap.put("errCode", Integer.valueOf(1));
      return "addFailure";
    }
    UserToken userToken = new UserToken();
    userToken.setUname(request.getParameter("uname"));
    userToken.setUdid(request.getParameter("udid"));
    String utoken = CommonUtil.genernateUsertoken();
    userToken.setUtoken(utoken);
    userToken.setStatus("0");
    String type = request.getParameter("userType");
    userToken.setUserType(type);
    userToken.setRegion(region);
    userToken.setRank(rank);
    userService.addUsertoken(userToken);
    resultMap.put("errCode", Integer.valueOf(0));

    return "addSuccess";
  }

  public String deleteUsertoken()
  {
    HttpServletRequest request = ServletActionContext.getRequest();
    int tid = Integer.parseInt(request.getParameter("t_id"));
    this.userService.deleteUsertoken(tid);
    return getUsertokenList();
  }

  public String invalidUsertoken() {
    HttpServletRequest request = ServletActionContext.getRequest();
    int tid = Integer.parseInt(request.getParameter("t_id"));
    this.userService.invalidUsertoken(tid);
    return getUsertokenList();
  }

  public String operateUsertoken()
  {
    HttpServletRequest request = ServletActionContext.getRequest();
    int tid = Integer.parseInt(request.getParameter("t_id"));
    UserToken userToken = this.userService.getUserToken(tid);
    request.setAttribute("userToken", userToken);
    return "updUsertoken";
  }

  public String updateUsertoken()
  {
    HttpServletRequest request = ServletActionContext.getRequest();
    String udid = request.getParameter("udid");
    int tId = this.userService.checkUdid(udid);

    int tid = Integer.parseInt(request.getParameter("t_id"));
    UserToken userToken = new UserToken();
    userToken.setTid(tid);
    userToken.setUname(request.getParameter("uname"));
    userToken.setUdid(request.getParameter("udid"));
    userToken.setUserType(request.getParameter("userType"));
    userToken.setRegion(request.getParameter("region"));
    userToken.setRank(request.getParameter("rank"));
    this.userService.updateUsertoken(userToken);
    return "updateSuccess";
  }
}