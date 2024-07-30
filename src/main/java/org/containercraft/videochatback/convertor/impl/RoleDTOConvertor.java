package org.containercraft.videochatback.convertor.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.RoleDTO;
import org.containercraft.videochatback.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleDTOConvertor implements ConvertorDTO<RoleDTO, Role> {
    private final ModelMapper mapper;


    @Override
    public RoleDTO convertObjectToDTO(Role object) {
        return mapper.map(object,RoleDTO.class);
    }

    @Override
    public Role convertDTOToObject(RoleDTO roleDTO) {
        return mapper.map(roleDTO,Role.class);
    }
}
