package springapp.service;

import java.io.Serializable;
import java.util.List;

import springapp.domain.Product;

public interface ProductManager extends Serializable {

	public List<Product> getProducts();

	public void increasePrice(int percentage);

}
