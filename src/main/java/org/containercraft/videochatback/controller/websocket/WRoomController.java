package org.containercraft.videochatback.controller.websocket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.UserRoomDTO;
import org.containercraft.videochatback.dto.UserDTO;
import org.containercraft.videochatback.entity.Room;
import org.containercraft.videochatback.entity.User;
import org.containercraft.videochatback.service.RoomService;
import org.containercraft.videochatback.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
@Slf4j
@RequiredArgsConstructor
public class WRoomController {
    private final RoomService roomService;
    private final UserService userService;
    private final ConvertorDTO<UserDTO,User> convertorUser;

    @MessageMapping("/room/connect")
    @SendTo("/topic/room/connect")
    public UserRoomDTO connectUser( UserRoomDTO dto){
        //log.info("user:{}",dto);
        User user = userService.findById(dto.getUser().getId());
        Room room = roomService.findByRoomId(dto.getRoomId());

        room.getUsers().add(user);
        roomService.update(room);
        dto.setUser(convertorUser.convertObjectToDTO(user));

        return dto;
    }

    @MessageMapping("/room/disconnect")
    @SendTo("/topic/room/disconnect")
    public UserRoomDTO disconnectUser(@Payload UserRoomDTO dto){
        if(roomService.existByRoomId(dto.getRoomId())) {
            Room room = roomService.findByRoomId(dto.getRoomId());
            User user = convertorUser.convertDTOToObject(dto.getUser());

            if (room.getRoomUserCreate().equals(user)) {
                roomService.deleteById(room.getId());
                return dto;
            }

            room.getUsers().remove(user);
            roomService.update(room);
        }
        return dto;
    }

    @MessageMapping("/room/delete")
    @SendTo("/topic/room/delete")
    public UserRoomDTO roomDelete(@Payload UserRoomDTO dto){
        return dto;
    }
}
