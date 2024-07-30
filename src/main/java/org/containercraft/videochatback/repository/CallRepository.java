package org.containercraft.videochatback.repository;


import org.containercraft.videochatback.entity.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CallRepository extends JpaRepository<Call, UUID> {
}
