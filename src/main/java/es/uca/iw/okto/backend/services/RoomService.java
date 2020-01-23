package es.uca.iw.okto.backend.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Room;
import es.uca.iw.okto.backend.repositories.RoomRepository;

@Service
public class RoomService {
  private final RoomRepository roomRepository;

  public RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public Collection<Room> findAll() {
    return roomRepository.findAll();
  }

  public int countAll() {
    return (int) roomRepository.count();
  }

  public Room save(Room room) {
    return roomRepository.save(room);
  }

  public void delete(Room room) {
    roomRepository.delete(room);
  }
}
