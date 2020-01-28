package es.uca.iw.okto.backend.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.uca.iw.okto.backend.models.Purchase;
import es.uca.iw.okto.backend.models.ShopLine;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {  
    @Query("SELECT shopLine FROM Purchase p WHERE p.id = :purchaseId")
    Collection<ShopLine> findPurchaseLine(@Param("purchaseId")Long id);
}
