package org.containercraft.videochatback.controller;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.UserDTO;
import org.containercraft.videochatback.entity.User;
import org.containercraft.videochatback.exception.NotValidateParamException;
import org.containercraft.videochatback.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class UserController {
    public final ConvertorDTO<UserDTO, User> convertorDTO;
    public final UserService service;

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }

    @PostMapping("/id")
    public UserDTO findById(@RequestBody Long id){
        return convertorDTO.convertObjectToDTO(service.findById(id));
    }

    @PostMapping("/add")
    public UserDTO save(@RequestBody UserDTO dto){
        if(dto.getId() != null) throw new NotValidateParamException("missed param: id");
        User user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.save(user));
    }

    @PutMapping("/update")
    public UserDTO update(@RequestBody UserDTO dto){
        if(dto.getId() == null) throw new NotValidateParamException("missed param: id");
        User user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.update(user));
    }

    @PutMapping("/delete")
    public void delete(@RequestBody Long id){
        if(id == null) throw new NotValidateParamException("missed param: id");
        service.deleteById(id);
    }
}
