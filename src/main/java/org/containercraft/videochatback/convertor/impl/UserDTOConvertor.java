package org.containercraft.videochatback.convertor.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.UserDTO;
import org.containercraft.videochatback.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDTOConvertor implements ConvertorDTO<UserDTO, User> {
    private final ModelMapper mapper;

    @Override
    public UserDTO convertObjectToDTO(User object) {
        return mapper.map(object,UserDTO.class);
    }

    @Override
    public User convertDTOToObject(UserDTO userDTO) {
        return mapper.map(userDTO,User.class);
    }
}
