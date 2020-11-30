package il.ac.afeka.shoppingcatalogservice.logic;

import il.ac.afeka.shoppingcatalogservice.data.*;
import il.ac.afeka.shoppingcatalogservice.errors.InternalErrorException;
import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ShoppingCatalogServiceDb implements ShoppingCatalogService {
    private ProductsDao productsDao;
    private CategoryDao categoryDao;
    private ProductDetailDao productDetailDao;

    @Autowired
    public ShoppingCatalogServiceDb(ProductsDao productsDao,
                                    CategoryDao categoryDao,
                                    ProductDetailDao productDetailDao) {
        this.productsDao = productsDao;
        this.categoryDao = categoryDao;
        this.productDetailDao = productDetailDao;
    }

    @Override
    @Transactional
    public void createCategory(CategoryBoundary value) {
        CategoryEntity category = new CategoryEntity();
        category.setName(value.getName());
        category.setDescription(value.getDescription());
        categoryDao.save(category);
    }

    @Override
    @Transactional
    public ProductBoundary createProduct(ProductBoundary value) {
        ProductEntity entity = ConvertToProductEntity(value);
        CategoryEntity category = categoryDao.findById(value.getCategory().getName()).orElse(null);
        if (category == null)
            throw new InternalErrorException("category must exist in the database");
        ProductEntity product = productsDao.findById(value.getId()).orElse(null);
        if (product != null)
            throw new InternalErrorException("product with the same id is already exists.");
        ProductDetailsEntity productDetailsEntity = productDetailDao.save(entity.getDetails());
        entity.setDetails(productDetailsEntity);
        ProductEntity saved = productsDao.save(entity);
        return new ProductBoundary(saved.getId(),
                                saved.getName(),
                                saved.getPrice(),
                                saved.getImage(),
                                new ProductDetails(saved.getDetails().getParts(), saved.getDetails().getManufacturer(), saved.getDetails().getCollectable()),
                                new CategoryBoundary(saved.getCategory().getName(), saved.getCategory().getDescription()));
    }

    private ProductEntity ConvertToProductEntity(ProductBoundary value) {
        ProductEntity entity = new ProductEntity();

        if (value.getId() != null)
            entity.setId(value.getId());
        if (value.getName() != null)
            entity.setName(value.getName());
        entity.setPrice(value.getPrice());
        if (value.getImage() != null)
            entity.setImage(value.getImage());
        if (value.getDetails() != null) {
            entity.setDetails(ConvetToProductDetailsEntity(value.getDetails()));
        }
        if (value.getCategory() != null) {
            entity.setCategory(ConvertToCategoryEntity(value.getCategory()));
        }

        return entity;
    }

    private CategoryEntity ConvertToCategoryEntity(CategoryBoundary category) {
        CategoryEntity entity = new CategoryEntity();

        if (category.getName() != null)
            entity.setName(category.getName());
        if (category.getDescription() != null)
            entity.setDescription(category.getDescription());

        return entity;
    }

    private ProductDetailsEntity ConvetToProductDetailsEntity(ProductDetails details) {
        ProductDetailsEntity entity = new ProductDetailsEntity();

        if (details.getManufacturer() != null)
            entity.setManufacturer(details.getManufacturer());
        if (details.getParts() != null)
            entity.setParts(details.getParts());
        entity.setCollectable(details.getCollectable());

        return entity;
    }
}
