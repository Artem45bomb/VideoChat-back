package org.containercraft.videochatback.convertor.impl;

import lombok.RequiredArgsConstructor;
import org.containercraft.videochatback.convertor.ConvertorDTO;
import org.containercraft.videochatback.dto.CallDTO;
import org.containercraft.videochatback.entity.Call;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CallDTOConvertor implements ConvertorDTO<CallDTO, Call> {
    private final ModelMapper mapper;

    @Override
    public CallDTO convertObjectToDTO(Call object) {
        return mapper.map(object,CallDTO.class);
    }

    @Override
    public Call convertDTOToObject(CallDTO callDTO) {
        return mapper.map(callDTO,Call.class);
    }
}
