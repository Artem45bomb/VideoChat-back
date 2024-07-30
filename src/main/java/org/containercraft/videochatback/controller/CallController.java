package org.containercraft.videochatback.controller;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.CallDTO;
import org.containercraft.videochatback.entity.Call;
import org.containercraft.videochatback.exception.NotValidateParamException;
import org.containercraft.videochatback.service.CallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/call")
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class CallController {
    private final CallService service;
    private final ConvertorDTO<CallDTO, Call> convertorDTO;


    @GetMapping("/{id}")
    public CallDTO findById(@PathVariable UUID id){
        return convertorDTO.convertObjectToDTO(service.findById(id));
    }

    @PostMapping("/add")
    public CallDTO save(@RequestBody CallDTO dto){
        if(dto.getId() != null) throw new NotValidateParamException("missed param: id");
        Call user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.save(user));
    }

    @PutMapping("/update")
    public CallDTO update(@RequestBody CallDTO dto){
        if(dto.getId() == null) throw new NotValidateParamException("missed param: id");
        Call user = convertorDTO.convertDTOToObject(dto);

        return convertorDTO.convertObjectToDTO(service.update(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        if(id == null) throw new NotValidateParamException("missed param: id");
        service.deleteById(id);
    }

    @GetMapping
    public List<Call> findAll(){
        return service.findAll();
    }
}
