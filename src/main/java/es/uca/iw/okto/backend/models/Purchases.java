package es.uca.iw.okto.backend.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import es.uca.iw.okto.backend.utils.AbstractEntity;

@Entity
public class Purchases extends AbstractEntity {

    /**
    *
    */
    private static final long serialVersionUID = 49272672233553808L;

    private Double price;

    @OneToMany(mappedBy = "purchases")
    private Collection<ShopLine> shopLine;

    @OneToMany(mappedBy = "purchases")
    private Collection<UserTrip> users;


    public Purchases() {
    }

    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }


    public Collection<ShopLine> getShopLine() {
        return shopLine;
    }


    public void setShopLine(Collection<ShopLine> shopLine) {
        this.shopLine = shopLine;
    }

    public Collection<UserTrip> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserTrip> users) {
        this.users = users;
    }
}
