package es.uca.iw.okto.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Room;
import es.uca.iw.okto.backend.models.Ship;

/**
 * RoomRepository
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
  Page<Room> findBy(Pageable pageable);

  Room findByShipAfter(Ship ship);
}