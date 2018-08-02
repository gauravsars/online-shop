package net.kzn.onlineshoppping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value ={"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC Message");
		return mv;
			
	}

	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting){
		if(greeting ==null){
			greeting = "Hello There";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	
	
/*	Aug 03, 2018 3:24:10 AM org.apache.catalina.core.ApplicationContext log
	INFO: Initializing Spring FrameworkServlet 'dispatcher'
	Aug 03, 2018 3:24:10 AM org.springframework.web.servlet.DispatcherServlet initServletBean
	INFO: FrameworkServlet 'dispatcher': initialization started
	Aug 03, 2018 3:24:10 AM org.springframework.web.context.support.XmlWebApplicationContext prepareRefresh
	INFO: Refreshing WebApplicationContext for namespace 'dispatcher-servlet': startup date [Fri Aug 03 03:24:10 IST 2018]; root of context hierarchy
	Aug 03, 2018 3:24:10 AM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
	INFO: Loading XML bean definitions from ServletContext resource [/WEB-INF/dispatcher-servlet.xml]
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Root mapping to handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/home] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/home.*] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/home/] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/index] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/index.*] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/index/] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/test/{greeting}] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/test/{greeting}.*] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping registerHandler
	INFO: Mapped URL path [/test/{greeting}/] onto handler 'pageController'
	Aug 03, 2018 3:24:13 AM org.springframework.web.servlet.DispatcherServlet initServletBean
	INFO: FrameworkServlet 'dispatcher': initialization completed in 3662 ms*/

}
