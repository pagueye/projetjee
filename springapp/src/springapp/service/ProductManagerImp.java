package springapp.service;

import java.util.Iterator;
import java.util.List;

import springapp.dao.ProductDao;
import springapp.domain.Product;

public class ProductManagerImp implements ProductManager {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.getProducts();
	}

	@Override
	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProducts();
		// TODO Auto-generated method stub
		if (products != null) {
			for (Iterator<Product> iterator = products.iterator(); iterator
					.hasNext();) {
				Product product = (Product) iterator.next();
				double price = ((product.getPrice()) * (double) (percentage) / 100)
						+ product.getPrice();
				product.setPrice(price);
				productDao.saveProduct(product);

			}
		}

	}
}
