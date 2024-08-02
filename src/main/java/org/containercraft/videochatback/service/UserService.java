package org.containercraft.videochatback.service;

import org.containercraft.videochatback.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User update(User role);

    User save(User role);

    void deleteById(Long id);
}
