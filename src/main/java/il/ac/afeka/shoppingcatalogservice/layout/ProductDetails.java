package il.ac.afeka.shoppingcatalogservice.layout;

public class ProductDetails {
    private int parts;
    private String manufacturer;
    private Boolean collectable;

    public ProductDetails() {
    }

    public ProductDetails(int parts, String manufacturer, Boolean collectable) {
        this.parts = parts;
        this.manufacturer = manufacturer;
        this.collectable = collectable;
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
}
