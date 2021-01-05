package il.ac.afeka.shoppingcatalogservice.logic;

import il.ac.afeka.shoppingcatalogservice.data.*;
import il.ac.afeka.shoppingcatalogservice.errors.InternalErrorException;
import il.ac.afeka.shoppingcatalogservice.errors.NotFoundException;
import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public CategoryBoundary createCategory(CategoryBoundary value) {
        CategoryEntity category = new CategoryEntity();
        category.setName(value.getName());
        category.setDescription(value.getDescription());
        CategoryEntity saved = categoryDao.save(category);

        return saved.toBoundary();
    }

    @Override
    @Transactional
    public ProductBoundary createProduct(ProductBoundary value) {
        ProductEntity entity = ConvertToProductEntity(value);
        CategoryEntity category = categoryDao.findById(value.getCategory().getName()).orElse(null);
        // Check category is already exist, or return 500 Error code
        if (category == null)
            throw new InternalErrorException("category must exist in the database");
        // Check if product with the same id is already exist, or return 500 error code
        ProductEntity product = productsDao.findById(value.getId()).orElse(null);
        if (product != null)
            throw new InternalErrorException("product with the same id is already exists.");
        ProductDetailsEntity productDetailsEntity = productDetailDao.save(entity.getDetails());
        entity.setDetails(productDetailsEntity);
        ProductEntity saved = productsDao.save(entity);
        return saved.toBoundary();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryBoundary> searchCategories(String sortAttr, String sortOrder, int page, int size) {
        return categoryDao.
                findAll(PageRequest.of(page,
                        size,
                        sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                        sortAttr))
                .stream()
                .map(CategoryEntity::toBoundary)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductBoundary getProductById(String productId) {
        ProductEntity entity = productsDao.findById(productId).orElse(null);

        if (entity == null) {
            throw new NotFoundException("Product with the requested catalog number wasn't found.");
        }

        return new ProductBoundary(entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getImage(),
                new ProductDetails(entity.getDetails().getParts(), entity.getDetails().getManufacturer(), entity.getDetails().getCollectable()),
                new CategoryBoundary(entity.getCategory().getName(), entity.getCategory().getDescription()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductBoundary> searchProducts(String filterType, String filterValue, String sortBy, String sortOrder, int page, int size) {
    	   	
        if (filterType.isEmpty()) {
        	 return this.productsDao
        			.findAll(PageRequest.of(page,
        					size,
        					sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                            sortBy))
        			.stream()
        			.map(ProductEntity::toBoundary)
        			.collect(Collectors.toList());
        }
        
        List<ProductEntity> res = null;
        
        if (filterType.equals("byName")) {
        	res = this.productsDao
        			.findByName(filterValue, PageRequest.of(page,
        					size,
        					sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                            sortBy));
        }
        
        if (filterType.equals("byMinPrice")) {
        	double price = Double.parseDouble(filterValue);
        	res = this.productsDao
        			.findByPriceIsGreaterThanEqual(price, PageRequest.of(page,
        					size,
        					sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                            sortBy));
        }
        
        if (filterType.equals("byMaxPrice")) {
        	double price = Double.parseDouble(filterValue);
        	res = this.productsDao
        			.findByPriceIsLessThanEqual(price, PageRequest.of(page,
        					size,
        					sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                            sortBy));
        }
        
        if (filterType.equals("byCategoryName")) {
        	res = this.productsDao
        			.findByCategoryName(filterValue, PageRequest.of(page,
        					size,
        					sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                            sortBy));
        }
    	
        return res == null ? new ArrayList<>() : res
        		.stream()
    			.map(ProductEntity::toBoundary)
    			.collect(Collectors.toList());
    }

    @Override
    public void delete() {
        this.categoryDao.deleteAll();
        this.productDetailDao.deleteAll();
        this.productsDao.deleteAll();
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
        if (value.getProductDetails() != null) {
            entity.setDetails(ConvertToProductDetailsEntity(value.getProductDetails()));
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

    private ProductDetailsEntity ConvertToProductDetailsEntity(ProductDetails details) {
        ProductDetailsEntity entity = new ProductDetailsEntity();

        if (details.getManufacturer() != null)
            entity.setManufacturer(details.getManufacturer());
        entity.setParts(details.getParts());
        entity.setCollectable(details.getCollectable());

        return entity;
    }
}
