package org.containercraft.videochatback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.containercraft.videochatback.entity.User;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CallDTO implements Serializable {
    private UUID id;
    private User whoIsCalling;
    private User whoIsConnect;
}
