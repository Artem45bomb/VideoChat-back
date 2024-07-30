package org.containercraft.videochatback.convertor;

public interface ConvertorDTO <DTO,Object> {
    DTO convertObjectToDTO(Object object);

    Object convertDTOToObject(DTO dto);
}
