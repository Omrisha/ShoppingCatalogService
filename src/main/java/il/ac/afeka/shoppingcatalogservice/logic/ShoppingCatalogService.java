package il.ac.afeka.shoppingcatalogservice.logic;

import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;

import java.util.List;

public interface ShoppingCatalogService {

    CategoryBoundary createCategory(CategoryBoundary value);

    ProductBoundary createProduct(ProductBoundary value);

    List<CategoryBoundary> searchCategories(String sortAttr, String sortOrder, int page, int size);

    ProductBoundary getProductById(String productId);

    List<ProductBoundary> searchProducts(String filterType, String filterValue, String sortBy, String sortOrder, int page, int size);

    void delete();
}
