package il.ac.afeka.shoppingcatalogservice.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {
}
