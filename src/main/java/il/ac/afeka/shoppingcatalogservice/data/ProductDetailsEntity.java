package il.ac.afeka.shoppingcatalogservice.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductDetailsEntity {
    private long id;
    private String parts;
    private String manufacturer;
    private Boolean collectable;
    @OneToOne
    private ProductEntity product;

    public ProductDetailsEntity() {
    }

    public ProductDetailsEntity(String parts, String manufacturer, Boolean collectable, ProductEntity product) {
        this.parts = parts;
        this.manufacturer = manufacturer;
        this.collectable = collectable;
        this.product = product;
    }

    @Id
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
