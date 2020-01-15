package es.uca.iw.okto.backend.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import es.uca.iw.okto.backend.utils.AbstractEntity;

@Entity
public class Service extends AbstractEntity {

    /**
    *
    */
    private static final long serialVersionUID = -8104609640892884129L;

    @ManyToOne
    @JoinColumn(name = "ship_id", nullable=true) 
    private Ship ship;

    private Double price;

    private String name;

    private String description;

    @OneToMany(mappedBy = "service")
    private Collection<ShopLine> shopLine;

    public Service() {
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Collection<ShopLine> getShopLine() {
        return shopLine;
    }

    public void setShopLine(Collection<ShopLine> shopLine) {
        this.shopLine = shopLine;
    }
}
