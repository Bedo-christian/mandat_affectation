package com.mandat.affecationf.mapper;

import com.mandat.affecationf.entity.Employe;
import com.mandat.affecationf.model.EmployeReq;
import com.mandat.affecationf.model.EmployesRep;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeMapper {
    EmployeMapper INSTANCE = Mappers.getMapper(EmployeMapper.class);
    EmployesRep toEmployeDto (Employe employe);
    Employe dtoToEmployEntity (EmployeReq employeReq);
    void updateEntityFromDto (EmployeReq employeReq, @MappingTarget Employe employe);
}
