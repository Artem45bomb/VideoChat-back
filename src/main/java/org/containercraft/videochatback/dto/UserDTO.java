package org.containercraft.videochatback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.containercraft.videochatback.entity.Role;


import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private String nickname;
    private String password;
    private List<Role> roles;
}
