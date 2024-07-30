package org.containercraft.videochatback.service.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.entity.Role;
import org.containercraft.videochatback.exception.ExistResourceException;
import org.containercraft.videochatback.exception.NotResourceException;
import org.containercraft.videochatback.repository.RoleRepository;
import org.containercraft.videochatback.service.RoleService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    //@Cacheable(value = "roles")
    public List<Role> findAll(){
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "roles",key = "#id")
    public Role findById(UUID id) {
        Optional<Role> role = repository.findById(id);

        if(role.isEmpty()) throw new NotResourceException("role is not exist");

        return role.get();
    }

    @Override
    @CachePut(value = "roles",key = "#role.id")
    public Role update(Role role) {
        findById(role.getId());
        return repository.save(role);
    }

    @Override
    public Role save(Role role) {
        Optional<Role> roleFind = repository.findByName(role.getName());

        if(roleFind.isPresent()) throw new ExistResourceException("role is exist");

        return repository.save(role);
    }

    @Override
    @CacheEvict(value = "roles",key = "#id")
    public void deleteById(UUID id) {
        findById(id);
        repository.deleteById(id);
    }
}
