package org.containercraft.videochatback.controller;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.RoomDTO;
import org.containercraft.videochatback.entity.Room;
import org.containercraft.videochatback.exception.NotValidateParamException;
import org.containercraft.videochatback.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class RoomController {
    public final ConvertorDTO<RoomDTO, Room> convertorDTO;
    public final RoomService service;

    @GetMapping
    public List<Room> findAll(){
        return service.findAll();
    }

    @GetMapping("/roomId/{roomId}")
    public Room findByRoomId(@PathVariable String roomId){
        return service.findByRoomId(roomId);
    }

    @GetMapping("/{id}")
    public RoomDTO findById(@PathVariable UUID id){
        return convertorDTO.convertObjectToDTO(service.findById(id));
    }

    @PostMapping("/add")
    public RoomDTO save(@RequestBody RoomDTO dto){
        if(dto.getId() != null) throw new NotValidateParamException("missed param: id");
        Room user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.save(user));
    }

    @PutMapping("/update")
    public RoomDTO update(@RequestBody RoomDTO dto){
        if(dto.getId() == null) throw new NotValidateParamException("missed param: id");
        Room user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.update(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        if(id == null) throw new NotValidateParamException("missed param: id");
        service.deleteById(id);
    }
}
