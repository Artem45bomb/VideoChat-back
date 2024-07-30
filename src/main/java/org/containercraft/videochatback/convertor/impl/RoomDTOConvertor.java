package org.containercraft.videochatback.convertor.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.RoomDTO;
import org.containercraft.videochatback.entity.Room;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomDTOConvertor implements ConvertorDTO<RoomDTO, Room> {
    private final ModelMapper mapper;

    @Override
    public RoomDTO convertObjectToDTO(Room object) {
        return mapper.map(object,RoomDTO.class);
    }

    @Override
    public Room convertDTOToObject(RoomDTO roomDTO) {
        return mapper.map(roomDTO,Room.class);
    }
}
