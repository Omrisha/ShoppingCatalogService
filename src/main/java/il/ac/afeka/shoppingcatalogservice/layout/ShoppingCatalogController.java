package il.ac.afeka.shoppingcatalogservice.layout;

import il.ac.afeka.shoppingcatalogservice.logic.ShoppingCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCatalogController {
    private ShoppingCatalogService shoppingCatalogService;

    @Autowired
    public ShoppingCatalogController(ShoppingCatalogService shoppingCatalogService) {
        this.shoppingCatalogService = shoppingCatalogService;
    }

    @RequestMapping(path = "/shopping/products",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCategory(@RequestBody CategoryBoundary value) {
        shoppingCatalogService.createCategory(value);
    }

    @RequestMapping(path = "/shopping/products",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductBoundary createProduct(@RequestBody ProductBoundary value) {
        return shoppingCatalogService.createProduct(value);
    }
}
