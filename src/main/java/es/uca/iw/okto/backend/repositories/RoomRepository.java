package es.uca.iw.okto.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.okto.backend.models.Room;

/**
 * RoomRepository
 */
public interface RoomRepository extends JpaRepository<Room,Long> {
}