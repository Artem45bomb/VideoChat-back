package org.containercraft.videochatback.service;

import org.containercraft.videochatback.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    Role findById(UUID id);
    Role update(Role role);

    Role save(Role role);

    List<Role> findAll();

    void deleteById(UUID id);
}
