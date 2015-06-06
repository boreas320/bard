package com.bard.davol.action;

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
@Action("loginAction")
@Results({@org.apache.struts2.convention.annotation.Result(name = "index", location = "/main.jsp"),
        @org.apache.struts2.convention.annotation.Result(name = "main", location = "/main.jsp"),
        @org.apache.struts2.convention.annotation.Result(name = "login", location = "/login.jsp")
})
public class LoginAction {

    private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

    public String login() {
        System.out.println("=========login====================");
        HttpServletRequest request = ServletActionContext.getRequest();
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        logger.error("======userName=" + userName + "  ,passWord=" + passWord);
        if (StringUtils.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "username is null");
            return "login";
        }
        if (StringUtils.isEmpty(passWord)) {
            JOptionPane.showMessageDialog(null, "password is null");
            return "login";
        }
//        if (("admin".equals(userName)) && ("admin".equals(passWord))) {
        if (("admin".equals(userName)) && ("d@volshar3".equals(passWord))) {

            return "index";
        }
        logger.error("user login failed.userName=" + userName + " ,passWord=" + passWord);
        JOptionPane.showMessageDialog(null, "username or password is error.");
        return "login";
    }
}

