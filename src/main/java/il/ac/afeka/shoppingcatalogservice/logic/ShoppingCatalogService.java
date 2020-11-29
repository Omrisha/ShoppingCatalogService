package il.ac.afeka.shoppingcatalogservice.logic;

import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;

public interface ShoppingCatalogService {

    void createCategory(CategoryBoundary value);

    ProductBoundary createProduct(ProductBoundary value);
}
