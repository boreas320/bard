package com.bard.davol.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter
{
  private static final String ENCODING_NAME = "encoding";
  private String encoding = "UTF-8";

  public void init(FilterConfig filterConfig) throws ServletException {
    String str = filterConfig.getInitParameter("encoding");
    if ((str != null) && (!"".equals(str)))
      this.encoding = str;
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    request.setCharacterEncoding(encoding);
    response.setCharacterEncoding(encoding);
    response.setContentType("text/html;charset=utf-8");
    chain.doFilter(request, response);
  }

  public void destroy()
  {
  }
}
