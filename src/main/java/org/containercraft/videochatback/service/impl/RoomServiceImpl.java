package org.containercraft.videochatback.service.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.entity.Room;
import org.containercraft.videochatback.entity.User;
import org.containercraft.videochatback.exception.ExistResourceException;
import org.containercraft.videochatback.exception.NotResourceException;
import org.containercraft.videochatback.repository.RoomRepository;
import org.containercraft.videochatback.service.RoomService;
import org.containercraft.videochatback.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;
    private final UserService userService;

    @Override
    //@Cacheable("rooms")
    public List<Room> findAll() {
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "rooms",key = "#id")
    public Room findById(UUID id) {
        Optional<Room> room = repository.findById(id);

        if(room.isEmpty()) throw new NotResourceException("room is not exist");

        return room.get();
    }

    @Override
    @CachePut(value = "rooms",key = "#room.id")
    public Room update(Room room) {
        findById(room.getId());
        User user = userService.findById(room.getRoomUserCreate().getId());
        room.setRoomUserCreate(user);

        return repository.save(room);
    }

    @Override
    public Room save(Room room) {
        Optional<Room> roomFind = repository.findByRoomId(room.getRoomId());
        User user = userService.findById(room.getRoomUserCreate().getId());

        if(roomFind.isPresent()) throw new ExistResourceException("room is exist");
        room.setRoomUserCreate(user);

        return repository.save(room);
    }

    @Override
    @CacheEvict(value = "rooms",key = "#id")
    public void deleteById(UUID id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public boolean existByRoomId(String roomId){
        return repository.existsByRoomId(roomId);
    }

    @Override
    public Room findByRoomId(String roomId){
        Optional<Room> room = repository.findByRoomId(roomId);

        if(room.isEmpty()) throw new NotResourceException("room is not exist");

        return room.get();
    }
}
