package org.containercraft.videochatback.service;

import org.containercraft.videochatback.entity.Call;

import java.util.List;
import java.util.UUID;

public interface CallService {
    List<Call> findAll();

    Call findById(UUID id);

    Call save(Call call);

    Call update(Call call);

    void deleteById(UUID id);

    boolean existById(UUID id);
}
