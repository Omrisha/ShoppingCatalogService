package il.ac.afeka.shoppingcatalogservice.data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class ProductDetailsEntity {
    private long id;
    @Min(0)
    private int parts;
    @NotBlank
    private String manufacturer;
    private Boolean collectable;
    private ProductEntity product;

    public ProductDetailsEntity() {
    }

    public ProductDetailsEntity(long id, int parts, String manufacturer, Boolean collectable, ProductEntity product) {
        this.id = id;
        this.parts = parts;
        this.manufacturer = manufacturer;
        this.collectable = collectable;
        this.product = product;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getCollectable() {
        return collectable;
    }

    public void setCollectable(Boolean collectable) {
        this.collectable = collectable;
    }

    @OneToOne(mappedBy = "details", targetEntity = ProductEntity.class)
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
