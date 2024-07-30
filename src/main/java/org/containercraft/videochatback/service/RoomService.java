package org.containercraft.videochatback.service;

import org.containercraft.videochatback.entity.Room;

import java.util.List;
import java.util.UUID;

public interface RoomService {
   List<Room> findAll();
   Room findById(UUID id);
   Room update(Room role);
   
   Room save(Room role);
   
   void deleteById(UUID id);

   boolean existByRoomId(String roomId);

   Room findByRoomId(String roomId);
}
