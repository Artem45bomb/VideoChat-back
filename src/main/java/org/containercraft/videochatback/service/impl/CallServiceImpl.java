package org.containercraft.videochatback.service.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.entity.Call;
import org.containercraft.videochatback.exception.NotResourceException;
import org.containercraft.videochatback.repository.CallRepository;
import org.containercraft.videochatback.service.CallService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CallServiceImpl implements CallService {
    private final CallRepository repository;

    @Override
    //@Cacheable("calls")
    public List<Call> findAll() {
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "calls",key = "#id")
    public Call findById(UUID id) {
        Optional<Call> call = repository.findById(id);

        if(call.isEmpty()) throw new NotResourceException("call is not exist");

        return call.get();
    }

    @Override
    public Call save(Call call) {
        return repository.save(call);
    }

    @Override
    @CachePut(value = "calls",key = "#call.id")
    public Call update(Call call) {
        findById(call.getId());
        return repository.save(call);
    }

    @Override
    @CacheEvict(value = "calls",key = "#id")
    public void deleteById(UUID id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public boolean existById(UUID id){
        return repository.existsById(id);
    }
}
