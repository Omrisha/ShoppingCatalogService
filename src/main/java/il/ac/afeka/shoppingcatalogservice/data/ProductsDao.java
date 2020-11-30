package il.ac.afeka.shoppingcatalogservice.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDao extends JpaRepository<ProductEntity, String> {

	List<ProductEntity> findByName(String name, Pageable pageable);
	
	List<ProductEntity> findByPriceIsGreaterThanEqual(double price, Pageable pageable);
	
	List<ProductEntity> findByPriceIsLessThanEqual(double price, Pageable pageable);

	List<ProductEntity> findByCategoryName(String categoryName, Pageable pageable);
}
