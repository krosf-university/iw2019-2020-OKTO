package es.uca.iw.okto.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.uca.iw.okto.backend.models.Room;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.RoomRepository;

@Service
public class RoomService implements FilterableCrudService<Room> {

  private final RoomRepository roomRepository;

  @Autowired
  public RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @Override
  public long countAnyMatching(Optional<String> filter) {
    return count();
  }

  @Override
  public RoomRepository getRepository() {
    return roomRepository;
  }

  public Page<Room> find(Pageable pageable) {
    return getRepository().findBy(pageable);
  }

  @Override
  public Room createNew(User currentUser) {
    return new Room();
  }

  @Override
  public Page<Room> findAnyMatching(Optional<String> filter, Pageable pageable) {
    return find(pageable);
  }
}
