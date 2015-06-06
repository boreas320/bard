 package com.bard.davol.util;
 
 import javax.servlet.http.HttpServletRequest;
 
 public class PagerHelper
 {
   public static Pager getPager(HttpServletRequest request, int totalRows)
   {
     Pager pager = new Pager(totalRows);
 
     String currentPage = request.getParameter("currentPage");
 
     if (currentPage != null) {
       pager.refresh(Integer.parseInt(currentPage));
     }
 
     String pagerMethod = request.getParameter("pageMethod");
     if (pagerMethod != null) {
       if (pagerMethod.equals("first"))
         pager.first();
       else if (pagerMethod.equals("previous")) pager.previous();
       else if (pagerMethod.equals("next")) pager.next();
       else if (pagerMethod.equals("last")) pager.last();
       else {
         pager.goPage(Integer.valueOf(pagerMethod).intValue());
       }
     }
     return pager;
   }
 }

