package com.mandat.affecationf.mapper;

import com.mandat.affecationf.entity.Client;
import com.mandat.affecationf.entity.Projet;
import com.mandat.affecationf.model.ClientDto;
import com.mandat.affecationf.model.ProjetDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjetMapper {
    ProjetMapper INSTANCE = Mappers.getMapper(ProjetMapper.class);
    ProjetDto EntityToProjetDto (Projet projet);
    Projet dtoToProjetEntity (ProjetDto projetDto);
    void updateEntityFromDto (ProjetDto projetDto, @MappingTarget Projet projet);
}
