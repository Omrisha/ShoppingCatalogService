package il.ac.afeka.shoppingcatalogservice.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class CategoryEntity {
    private long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> product = new ArrayList<>();

    public CategoryEntity() {
    }

    public CategoryEntity(String name, String description, List<ProductEntity> product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

    @Column(name = "CATEGORY_ID")
    @Id
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }
}
