package org.containercraft.videochatback.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "call_data",schema = "videochat",catalog = "postgres")
@AllArgsConstructor
@NoArgsConstructor
public class Call implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "who_is_calling_user_id")
    private User whoIsCalling;

    @OneToOne
    @JoinColumn(name = "who_is_connect_user_id")
    private User whoIsConnect;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Role role)) return false;
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
