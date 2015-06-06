package com.bard.davol.serviceImpl;

import com.bard.davol.service.FileService;
import com.bard.davol.service.UserService;

public class LogicBeanFactory

{


    private static UserService userService = new UserServiceImpl();
    private static FileService fileService = new FileServiceImpl();

    public static UserService getUserService() {
        return userService;
    }

    public static FileService getFileService() {
        return fileService;
    }
}

