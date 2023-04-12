package com.mandat.affecationf.delegate;

import com.mandat.affecationf.api.EmployesApiDelegate;
import com.mandat.affecationf.model.EmployeReq;
import com.mandat.affecationf.model.EmployesRep;
import com.mandat.affecationf.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeDelegate implements EmployesApiDelegate {

    @Autowired
    EmployeService employeService;

    @Override
    public ResponseEntity<List<EmployesRep>> employesGet() {

        List<EmployesRep> repList = employeService.getAllEmployes();

        return ResponseEntity.ok(repList);
    }

    @Override
    public ResponseEntity<Void> employesEmployeIdDelete(Integer employeId) {
        employeService.deleteEmployeById(employeId);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<EmployesRep> employesEmployeIdGet(Integer employeId) {
        EmployesRep employeReturn = employeService.getEmployeById(employeId);
        return ResponseEntity.ok(employeReturn);
    }

    @Override
    public ResponseEntity<EmployeReq> employesEmployeIdPut(Integer employeId, EmployeReq employeReq) {
        EmployeReq employeDto = employeService.updateEmploye(employeId,employeReq);
        return ResponseEntity.ok(employeDto);
    }

    @Override
    public ResponseEntity<EmployeReq> saveEmployer(EmployeReq employeReq) {
        EmployeReq employeDto = employeService.saveEmploye(employeReq);
        return ResponseEntity.ok(employeDto);
    }
}
