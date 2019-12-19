package es.uca.iw.okto.backend.repositories;

import es.uca.iw.okto.backend.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository  extends JpaRepository<Ship,Long> {
}
