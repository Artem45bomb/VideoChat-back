package org.containercraft.videochatback.repository;


import org.containercraft.videochatback.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    Optional<Room> findByRoomId(String roomId);

    boolean existsByRoomId(String roomId);
}
