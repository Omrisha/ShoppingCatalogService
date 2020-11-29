package il.ac.afeka.shoppingcatalogservice.logic;

import il.ac.afeka.shoppingcatalogservice.data.ShopingCatalogDao;
import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCatalogServiceDb implements ShoppingCatalogService {
    private ShopingCatalogDao shopingCatalogDao;

    @Override
    public void createCategory(CategoryBoundary value) {

    }

    @Override
    public ProductBoundary createProduct(ProductBoundary value) {
        return null;
    }
}
