package il.ac.afeka.shoppingcatalogservice.data;

import javax.persistence.*;

@Entity
public class ProductDetailsEntity {
    private long id;
    private String parts;
    private String manufacturer;
    private Boolean collectable;
    private ProductEntity product;

    public ProductDetailsEntity() {
    }

    public ProductDetailsEntity(long id, String parts, String manufacturer, Boolean collectable, ProductEntity product) {
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

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
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
