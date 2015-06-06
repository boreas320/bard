 package com.bard.davol.util;

 import java.util.Collection;
 import java.util.Iterator;

 public class PPrint
 {
   public static String pformat(Collection<?> c)
   {
     if (c.size() == 0) return "[]";
     StringBuilder result = new StringBuilder("");
     for (Iterator i$ = c.iterator(); i$.hasNext(); ) { Object elem = i$.next();

       result.append(elem);
       if (c.size() != 1) {
         result.append("\n");
       } }

     result.append("");
     return result.toString();
   }
 }

/* Location:           D:\新建文件夹\bard-service-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.util.PPrint
 * JD-Core Version:    0.5.4
 */