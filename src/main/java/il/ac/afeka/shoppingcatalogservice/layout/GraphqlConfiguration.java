package il.ac.afeka.shoppingcatalogservice.layout;

import il.ac.afeka.shoppingcatalogservice.Mutations.Mutation;
import il.ac.afeka.shoppingcatalogservice.data.CategoryDao;
import il.ac.afeka.shoppingcatalogservice.data.ProductDetailDao;
import il.ac.afeka.shoppingcatalogservice.data.ProductDetailsEntity;
import il.ac.afeka.shoppingcatalogservice.data.ProductsDao;
import il.ac.afeka.shoppingcatalogservice.resolvers.ProductResolver;
import il.ac.afeka.shoppingcatalogservice.resolvers.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public ProductResolver productResolver(ProductDetailDao productDetailDao, CategoryDao categoryDao) {
        return new ProductResolver(productDetailDao, categoryDao);
    }

    @Bean
    public Query query(ProductsDao productsDao) {
        return new Query(productsDao);
    }

    @Bean
    public Mutation mutation(ProductsDao productsDao, ProductDetailDao productDetailDao, CategoryDao categoryDao) {
        return new Mutation(productsDao, categoryDao, productDetailDao);
    }
}
