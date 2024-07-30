package org.containercraft.videochatback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.containercraft.videochatback.entity.User;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoomDTO implements Serializable {
    private String roomId;
    private UserDTO user;

}
