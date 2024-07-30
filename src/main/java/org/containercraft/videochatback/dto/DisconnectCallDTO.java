package org.containercraft.videochatback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisconnectCallDTO implements Serializable {
    private Long userId;
    private UUID callId;
}
