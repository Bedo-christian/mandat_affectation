package com.mandat.affecationf.mapper;

import com.mandat.affecationf.entity.EmployeEntity;
import com.mandat.affecationf.model.EmployeReq;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeMapper {
    EmployeReq toEmployeDto (EmployeEntity employeEntity);
    EmployeEntity dtoToEmployEntity (EmployeReq employeReq);
}
