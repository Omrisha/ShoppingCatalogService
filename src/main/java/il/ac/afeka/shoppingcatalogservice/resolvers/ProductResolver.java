package il.ac.afeka.shoppingcatalogservice.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import il.ac.afeka.shoppingcatalogservice.data.*;

public class ProductResolver implements GraphQLResolver<ProductEntity> {
    private ProductDetailDao productDetailDao;
    private CategoryDao categoryDao;

    public ProductResolver(ProductDetailDao productDetailDao, CategoryDao categoryDao) {
        this.productDetailDao = productDetailDao;
        this.categoryDao = categoryDao;
    }

    public CategoryEntity getCategoryEntity(ProductEntity productEntity) {
        return categoryDao.findById(productEntity.getCategory().getName()).orElseThrow(RuntimeException::new);
    }

    public ProductDetailsEntity getProductDetailsEntity(ProductEntity productEntity) {
        return productDetailDao.findById(productEntity.getDetails().getId()).orElseThrow(RuntimeException::new);
    }
}
