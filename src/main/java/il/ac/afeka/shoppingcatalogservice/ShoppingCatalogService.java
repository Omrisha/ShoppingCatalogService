package il.ac.afeka.shoppingcatalogservice;

public interface ShoppingCatalogService {

    void createCategory(CategoryBoundary value);

    ProductBoundary createProduct(ProductBoundary value);
}
