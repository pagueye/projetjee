package springapp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springapp.service.ProductManager;

public class InventoryController implements Controller {
	private ProductManager productManager;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String now = (new Date()).toString();

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", productManager.getProducts());

		return new ModelAndView("inventoryStock", "model", myModel);
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}
