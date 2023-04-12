package com.mandat.affecationf.service;

import com.mandat.affecationf.model.EmployeReq;
import com.mandat.affecationf.model.EmployesRep;

import java.util.List;

public interface EmployeService {

    List<EmployesRep> getAllEmployes();
    EmployeReq saveEmploye(EmployeReq employeReq);
    EmployeReq updateEmploye(Integer idEmploye, EmployeReq employeReq);
    EmployesRep getEmployeById(Integer employeId);
    void deleteEmployeById(Integer employeId);
}
