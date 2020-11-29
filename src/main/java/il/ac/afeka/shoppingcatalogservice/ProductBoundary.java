package il.ac.afeka.shoppingcatalogservice;

public class ProductBoundary {
    private long id;
    private String name;
    private double price;
    private String image;
    private ProductDetails details;
    private CategoryBoundary category;

    public ProductBoundary() {
    }

    public ProductBoundary(String name, double price, String image, ProductDetails details, CategoryBoundary category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.details = details;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public ProductDetails getDetails() {
        return details;
    }

    public void setDetails(ProductDetails details) {
        this.details = details;
    }

    public CategoryBoundary getCategory() {
        return category;
    }

    public void setCategory(CategoryBoundary category) {
        this.category = category;
    }
}
