package org.containercraft.videochatback.controller.client;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.dto.PermissionDTO;
import org.containercraft.videochatback.dto.RoomClientDTO;
import org.containercraft.videochatback.service.RoomService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomClientController {
    private final RoomService service;


    @PostMapping("/permission/create")
    public PermissionDTO createRoom(@RequestBody RoomClientDTO dto){
        var permission = PermissionDTO.builder()
                .typeAction("create")
                .isPermission(true)
                .build();
        if(service.existByRoomId(dto.getRoomId())){
            permission.setIsPermission(false);
            permission.setDescriptionIfNot("id for this room is already taken");
        }

        return permission;
    }

    @PostMapping("/permission/join")
    public PermissionDTO joinRoom(@RequestBody RoomClientDTO dto){
        var permission = PermissionDTO.builder()
                .typeAction("join")
                .isPermission(true)
                .build();
        if(!service.existByRoomId(dto.getRoomId())){
            permission.setIsPermission(false);
            permission.setDescriptionIfNot("room is not exist");
        }

        return permission;
    }
}
