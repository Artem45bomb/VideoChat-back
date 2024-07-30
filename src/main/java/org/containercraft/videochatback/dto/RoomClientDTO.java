package org.containercraft.videochatback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomClientDTO implements Serializable {
    private String roomId;
    private Long userId;
}
