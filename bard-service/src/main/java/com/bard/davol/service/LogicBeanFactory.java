 package com.bard.davol.service;

 import com.bard.davol.service.impl.BardAccountServiceImpl;

 public class LogicBeanFactory
 {
   public static BardAccountService getBardAccountService()
   {
     return new BardAccountServiceImpl();
   }
 }

/* Location:           D:\新建文件夹\bard-service-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.service.LogicBeanFactory
 * JD-Core Version:    0.5.4
 */