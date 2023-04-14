package com.mandat.affecationf.mapper;

import com.mandat.affecationf.entity.Client;
import com.mandat.affecationf.model.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    ClientDto EntityToClientDto (Client client);
    Client dtoToClientEntity (ClientDto clientDto);
    void updateEntityFromDto (ClientDto clientDto, @MappingTarget Client client);
}
