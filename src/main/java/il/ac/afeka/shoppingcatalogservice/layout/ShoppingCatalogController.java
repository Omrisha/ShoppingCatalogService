package il.ac.afeka.shoppingcatalogservice.layout;

import il.ac.afeka.shoppingcatalogservice.logic.ShoppingCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCatalogController {
    private ShoppingCatalogService shoppingCatalogService;

    @Autowired
    public ShoppingCatalogController(ShoppingCatalogService shoppingCatalogService) {
        this.shoppingCatalogService = shoppingCatalogService;
    }

    @RequestMapping(path = "/shopping/categories",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public CategoryBoundary createCategory(@RequestBody CategoryBoundary value) {
        return shoppingCatalogService.createCategory(value);
    }

    @RequestMapping(path = "/shopping/products",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductBoundary createProduct(@RequestBody ProductBoundary value) {
        return shoppingCatalogService.createProduct(value);
    }

    @RequestMapping(path = "/shopping/categories",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryBoundary[] searchCategories(
            @RequestParam(name = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") String sortOrder,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return shoppingCatalogService.searchCategories(sortBy, sortOrder, page, size);
    }

    @RequestMapping(path = "/shopping/products/{productId}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductBoundary getProductById(@PathVariable("productId") String productId) {
        return this.shoppingCatalogService.getProductById(productId);
    }

    @RequestMapping(path = "/shopping/products",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductBoundary[] searchProducts(
            @RequestParam(name = "filterType", required = false, defaultValue = "") String filterType,
            @RequestParam(name = "filterValue", required = false, defaultValue = "") String filterValue,
            @RequestParam(name = "sortBy", required = false, defaultValue = "name") String sortBy,
            @RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") String sortOrder,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return this.shoppingCatalogService.searchProducts(filterType,
                filterValue,
                sortBy,
                sortOrder,
                page,
                size);
    }

    @RequestMapping(path = "/shopping",
            method = RequestMethod.DELETE)
    public void delete(){
        this.shoppingCatalogService.delete();
    }
}
