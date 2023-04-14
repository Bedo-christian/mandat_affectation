package com.mandat.affecationf.mapper;

import com.mandat.affecationf.entity.Affectation;
import com.mandat.affecationf.model.AffectationDto;
import com.mandat.affecationf.model.AffectationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AffectationMapper {
    AffectationMapper INSTANCE = Mappers.getMapper(AffectationMapper.class);
    AffectationResponse EntityToAffectDto (Affectation affectation);
    Affectation dtoToAffectationEntity (AffectationDto affectationDto);
    void updateEntityFromDto (AffectationDto affectationDto, @MappingTarget Affectation affectation);
}
