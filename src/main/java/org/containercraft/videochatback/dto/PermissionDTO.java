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
public class PermissionDTO implements Serializable {
    private String typeAction;
    private Boolean isPermission;
    private String descriptionIfNot;
}
