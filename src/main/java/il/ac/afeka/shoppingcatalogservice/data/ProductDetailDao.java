package il.ac.afeka.shoppingcatalogservice.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailDao extends JpaRepository<ProductDetailsEntity, Long> {
}
