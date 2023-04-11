package com.mandat.affecationf.delegate;

import com.mandat.affecationf.api.EmployesApiDelegate;
import com.mandat.affecationf.model.EmployesRep;
import com.mandat.affecationf.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("List<EmployesRep> repList"+repList.toString());

        return ResponseEntity.ok(repList);
    }
}
