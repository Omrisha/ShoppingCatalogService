package il.ac.afeka.shoppingcatalogservice.logic;

import il.ac.afeka.shoppingcatalogservice.data.CategoryDao;
import il.ac.afeka.shoppingcatalogservice.data.ProductsDao;
import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCatalogServiceDb implements ShoppingCatalogService {
    private ProductsDao productsDao;
    private CategoryDao categoryDao;

    @Autowired
    public ShoppingCatalogServiceDb(ProductsDao productsDao, CategoryDao categoryDao) {
        this.productsDao = productsDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public void createCategory(CategoryBoundary value) {

    }

    @Override
    public ProductBoundary createProduct(ProductBoundary value) {
        return null;
    }
}
