package org.containercraft.videochatback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.containercraft.videochatback.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO implements Serializable {
    UUID id;
    String roomId;
    UserDTO roomUserCreate;
    Set<UserDTO> users;
}
