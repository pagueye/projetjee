package springapp.web;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import springapp.controller.HelloController;

public class HelloControllerTest extends TestCase {

	public void testhandleRequest() throws Exception {
		HelloController helloController = new HelloController();
		ModelAndView modelAndView = helloController.handleRequest(null, null);
		assertEquals(modelAndView.getViewName(), "/WEB-INF/jsp/hello.jsp");

	}

}
