package org.containercraft.videochatback.controller.websocket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.containercraft.videochatback.dto.DisconnectCallDTO;
import org.containercraft.videochatback.entity.Call;
import org.containercraft.videochatback.entity.User;
import org.containercraft.videochatback.service.CallService;
import org.containercraft.videochatback.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;


@Slf4j
@Controller
@RequiredArgsConstructor
public class WCallController {
    private final CallService service;
    private final UserService userService;

    @MessageMapping("/call")
    @SendTo("/topic/call")
    public Call call(@Payload Call call){
        call.setWhoIsCalling(userService.findById(call.getWhoIsCalling().getId()));
        call.setWhoIsConnect(userService.findById(call.getWhoIsConnect().getId()));
        return service.save(call);
    }

    @MessageMapping("/call/connect")
    @SendTo("/topic/call/connect")
    public Call callConnect(@Payload Call dto){
        return service.findById(dto.getId());
    }

    @MessageMapping("/call/disconnect")
    @SendTo("/topic/call/disconnect")
    public DisconnectCallDTO callSnuggle(@Payload DisconnectCallDTO dto){
        if(service.existById(dto.getCallId())) {
            service.deleteById(dto.getCallId());
        }
        return dto;
    }
}
