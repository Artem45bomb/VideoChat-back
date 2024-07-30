package org.containercraft.videochatback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSocketDTO implements Serializable {
    private Long id;
    private String name;
    private String nickname;
    private List<RoleDTO> roles;
}
