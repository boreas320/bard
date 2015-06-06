 package com.bard.davol.filter;

 import java.io.IOException;
 import javax.servlet.Filter;
 import javax.servlet.FilterChain;
 import javax.servlet.FilterConfig;
 import javax.servlet.ServletException;
 import javax.servlet.ServletRequest;
 import javax.servlet.ServletResponse;

 public class CharacterEncodingFilter
   implements Filter
 {
   private static final String ENCODING_NAME = "encoding";
   private String encoding;

   public CharacterEncodingFilter()
   {
     this.encoding = "UTF-8";
   }

   public void init(FilterConfig filterConfig) throws ServletException {
     String str = filterConfig.getInitParameter("encoding");
     if ((str != null) && (!"".equals(str)))
       this.encoding = str;
   }

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
     throws IOException, ServletException
   {
     request.setCharacterEncoding(this.encoding);
     response.setCharacterEncoding(this.encoding);
     response.setContentType("text/html;charset=utf-8");
     chain.doFilter(request, response);
   }

   public void destroy()
   {
   }
 }

/* Location:           D:\新建文件夹\bard-service-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.filter.CharacterEncodingFilter
 * JD-Core Version:    0.5.4
 */