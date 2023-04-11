package com.mandat.affecationf.mapper;

import com.mandat.affecationf.entity.Employe;
import com.mandat.affecationf.model.EmployesRep;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeMapper {
    EmployeMapper INSTANCE = Mappers.getMapper(EmployeMapper.class);
    EmployesRep toEmployeDto (Employe employe);
    Employe dtoToEmployEntity (EmployesRep employeReq);
}
