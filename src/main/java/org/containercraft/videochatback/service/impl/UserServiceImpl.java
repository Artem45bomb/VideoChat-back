package org.containercraft.videochatback.service.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.entity.User;
import org.containercraft.videochatback.exception.ExistResourceException;
import org.containercraft.videochatback.exception.NotResourceException;
import org.containercraft.videochatback.repository.UserRepository;
import org.containercraft.videochatback.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    //@Cacheable("users")
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "users",key = "#id")
    public User findById(Long id) {
        Optional<User> user = repository.findById(id);

        if(user.isEmpty()) throw new NotResourceException("user is not exist");

        return user.get();
    }

    @Override
    @CachePut(value = "users",key = "#user.id")
    public User update(User user) {
        findById(user.getId());
        return repository.save(user);
    }

    @Override
    public User save(User user) {
        Optional<User> userFind = repository.findByNickname(user.getNickname());

        if(userFind.isPresent()) throw new ExistResourceException("user is exist");

        return repository.save(user);
    }

    @Override
    @CacheEvict(value = "users",key = "#id")
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
