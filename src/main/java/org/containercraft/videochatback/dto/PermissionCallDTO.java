package org.containercraft.videochatback.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionCallDTO implements Serializable {
    private Long whoIsCallingId;
    private Long whoIsConnectId;
}