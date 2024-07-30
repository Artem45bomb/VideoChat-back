package org.containercraft.videochatback.controller;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.RoleDTO;
import org.containercraft.videochatback.entity.Role;
import org.containercraft.videochatback.exception.NotValidateParamException;
import org.containercraft.videochatback.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/role/")
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class RoleController {
    public final ConvertorDTO<RoleDTO, Role> convertorDTO;
    public final RoleService service;

    @GetMapping
    public List<Role> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RoleDTO findById(@PathVariable UUID id){
        return convertorDTO.convertObjectToDTO(service.findById(id));
    }

    @PostMapping("/add")
    public RoleDTO save(@RequestBody RoleDTO dto){
        if(dto.getId() != null) throw new NotValidateParamException("missed param: id");
        Role user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.save(user));
    }

    @PutMapping("/update")
    public RoleDTO update(@RequestBody RoleDTO dto){
        if(dto.getId() == null) throw new NotValidateParamException("missed param: id");
        Role user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.update(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        if(id == null) throw new NotValidateParamException("missed param: id");
        service.deleteById(id);
    }
}
