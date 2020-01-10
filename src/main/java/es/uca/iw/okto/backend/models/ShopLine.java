package es.uca.iw.okto.backend.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import es.uca.iw.okto.backend.utils.AbstractEntity;

@Entity
public class ShopLine extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = -4047702656737581607L;

    private Integer amount;

    private Double temporaryImport;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "purchases_id", nullable = false)
    private Purchases purchases;

    public ShopLine() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTemporaryImport() {
        return temporaryImport;
    }

    public void setTemporaryImport(Double temporaryImport) {
        this.temporaryImport = temporaryImport;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Purchases getPurchases() {
        return purchases;
    }

    public void setPurchases(Purchases purchases) {
        this.purchases = purchases;
    }
}
