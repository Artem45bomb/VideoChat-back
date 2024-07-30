package org.containercraft.videochatback.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@Table(name = "role_data",schema = "videochat",catalog = "postgres")
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

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
