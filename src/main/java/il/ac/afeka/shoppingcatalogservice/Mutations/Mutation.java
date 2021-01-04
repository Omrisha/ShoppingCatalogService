package il.ac.afeka.shoppingcatalogservice.Mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import il.ac.afeka.shoppingcatalogservice.data.*;

public class Mutation implements GraphQLMutationResolver {
    private ProductsDao productsDao;
    private CategoryDao categoryDao;
    private ProductDetailDao productDetailDao;

    public Mutation(ProductsDao productsDao, CategoryDao categoryDao, ProductDetailDao productDetailDao) {
        this.productsDao = productsDao;
        this.categoryDao = categoryDao;
        this.productDetailDao = productDetailDao;
    }

    public ProductEntity writeProduct(String id, String name, double price, String image, ProductDetailsEntity productDetailsEntity, CategoryEntity categoryEntity) {
        ProductEntity entity = new ProductEntity();
        if (id != null)
            entity.setId(id);
        if (name != null)
            entity.setName(name);
        entity.setPrice(price);
        if (image != null)
            entity.setImage(image);
        if (productDetailsEntity != null) {
            ProductDetailsEntity details = new ProductDetailsEntity();
            details.setParts(productDetailsEntity.getParts());
            details.setCollectable(productDetailsEntity.getCollectable());
            if (productDetailsEntity.getManufacturer() != null)
                details.setManufacturer(productDetailsEntity.getManufacturer());
            entity.setDetails(productDetailDao.save(details));
        }
        if (categoryEntity != null) {
            CategoryEntity category = new CategoryEntity();

            if (categoryEntity.getName() != null)
                category.setName(categoryEntity.getName());
            if (categoryEntity.getDescription() != null)
                category.setDescription(categoryEntity.getDescription());
            entity.setCategory(categoryDao.save(category));
        }

        return productsDao.save(entity);
    }
}
