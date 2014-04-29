package springapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import springapp.domain.Product;

public class ProductDaoImp extends SimpleJdbcDaoSupport implements ProductDao {

	@Override
	public List<Product> getProducts() {
		List<Product> products = getSimpleJdbcTemplate().query(
				"select id, description, price from products",
				new ProductMapper());
		return products;
	}

	@Override
	public void saveProduct(Product prod) {

		int count = getSimpleJdbcTemplate()
				.update("update products set description = :description, price = :price where id = :id",
						new MapSqlParameterSource()
								.addValue("description", prod.getDescription())
								.addValue("price", prod.getPrice())
								.addValue("id", prod.getId()));
	}

	public static class ProductMapper implements
			ParameterizedRowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int row) throws SQLException {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getDouble("price"));
			return product;
		}

	}
}
