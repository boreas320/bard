package com.bard.davol.filter;

import com.bard.davol.web.GetFilePathListServlet;
import com.bard.davol.web.LoginServlet;
import com.bard.davol.web.TransferFileServlet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class WebGuiceServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {
			
			@Override
			protected void configureServlets() {
				serve("/getFilePath.json").with(GetFilePathListServlet.class);
				serve("/getUpdZip.json").with(TransferFileServlet.class);
				serve("/login.json").with(LoginServlet.class);
			}
		});
	}
}
