package il.ac.afeka.shoppingcatalogservice.data;

import javax.persistence.*;

@Entity
public class ProductEntity {
    private String id;
    private String name;
    private double price;
    private String image;
    @OneToOne(mappedBy = "product")
    private ProductDetailsEntity details;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(String name, double price, String image, ProductDetailsEntity details, CategoryEntity category) {
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

    public ProductDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(ProductDetailsEntity details) {
        this.details = details;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
