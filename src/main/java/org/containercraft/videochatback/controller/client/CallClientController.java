package org.containercraft.videochatback.controller.client;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.dto.PermissionCallDTO;
import org.containercraft.videochatback.dto.PermissionDTO;
import org.containercraft.videochatback.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/call")
@RequiredArgsConstructor
public class CallClientController {
    private final UserService userService;

    @PostMapping("/permission")
    public PermissionDTO callUser(@RequestBody PermissionCallDTO dto){
        var permission = PermissionDTO.builder()
                .typeAction("create")
                .isPermission(true)
                .build();
        try {
            userService.findById(dto.getWhoIsConnectId());
        }
        catch (Exception e){
            permission.setIsPermission(false);
            permission.setDescriptionIfNot(e.getMessage());
        }
        return permission;
    }
}
