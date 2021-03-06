package il.ac.afeka.shoppingcatalogservice.data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductDetails;

@Entity
public class ProductEntity {
    private String id;
    @NotBlank
    private String name;
    @DecimalMin("0.0")
    private double price;
    @NotBlank
    private String image;
    private ProductDetailsEntity details;
    private CategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(String id, String name, double price, String image, ProductDetailsEntity details, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.details = details;
        this.category = category;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToOne
    public ProductDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(ProductDetailsEntity details) {
        this.details = details;
    }

    @ManyToOne(targetEntity = CategoryEntity.class)
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
    
    public ProductBoundary toBoundary() {
    	return new ProductBoundary(this.getId(),
				this.getName(),
				this.getPrice(),
				this.getImage(),
				new ProductDetails(this.getDetails().getParts(),
						this.getDetails().getManufacturer(),
						this.getDetails().getCollectable()),
				new CategoryBoundary(this.getCategory().getName(),
						this.getCategory().getDescription()));
    }
}
