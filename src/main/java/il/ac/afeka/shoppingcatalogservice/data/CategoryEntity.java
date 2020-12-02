package il.ac.afeka.shoppingcatalogservice.data;

import il.ac.afeka.shoppingcatalogservice.layout.CategoryBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductBoundary;
import il.ac.afeka.shoppingcatalogservice.layout.ProductDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryEntity {
    private String name;
    private String description;
    private List<ProductEntity> product = new ArrayList<>();

    public CategoryEntity() {
    }

    public CategoryEntity(String name, String description, List<ProductEntity> product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "category")
    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }

    public CategoryBoundary toBoundary() {
        return new CategoryBoundary(
                this.getName(),
                this.getDescription());
    }
}
