package il.ac.afeka.shoppingcatalogservice.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import il.ac.afeka.shoppingcatalogservice.data.ProductEntity;
import il.ac.afeka.shoppingcatalogservice.data.ProductsDao;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private ProductsDao productsDao;

    public Query(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    public List<ProductEntity> getProducts(int page, int size) {
        return this.productsDao.findAll(PageRequest.of(page, size)).getContent();
    }
}
