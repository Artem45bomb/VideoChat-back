package org.containercraft.videochatback.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "room_data",schema = "videochat",catalog = "postgres")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String roomId;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User roomUserCreate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Set<User> users = new HashSet<>();
}
