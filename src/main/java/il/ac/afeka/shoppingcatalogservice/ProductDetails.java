package il.ac.afeka.shoppingcatalogservice;

public class ProductDetails {
    private String parts;
    private String manufacturer;
    private Boolean collectable;

    public ProductDetails() {
    }

    public ProductDetails(String parts, String manufacturer, Boolean collectable) {
        this.parts = parts;
        this.manufacturer = manufacturer;
        this.collectable = collectable;
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
}
