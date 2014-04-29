package springapp.dao;

import java.util.List;

import springapp.domain.Product;

public interface ProductDao {

	public List<Product> getProducts();

	public void saveProduct(Product prod);

}
