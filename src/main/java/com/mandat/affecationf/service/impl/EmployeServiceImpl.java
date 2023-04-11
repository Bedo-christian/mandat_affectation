package com.mandat.affecationf.service.impl;

import com.mandat.affecationf.api.EmployesApiDelegate;
import com.mandat.affecationf.dao.EmployeDao;
import com.mandat.affecationf.entity.Employe;
import com.mandat.affecationf.mapper.EmployeMapper;
import com.mandat.affecationf.model.EmployeReq;
import com.mandat.affecationf.model.EmployesRep;
import com.mandat.affecationf.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {


    private final EmployeMapper employeMapper;
    private final EmployeDao employeDao;
    public EmployeServiceImpl(EmployeMapper employeMapper, EmployeDao employeDao){
        this.employeMapper = employeMapper;
        this.employeDao = employeDao;
    }

    @Override
    public List<EmployesRep> getAllEmployes() {
        List<Employe> employeList = employeDao.findAll();
        List<EmployesRep> repList = new ArrayList<>();
        for (Employe employe: employeList){
            repList.add(employeMapper.toEmployeDto(employe));
        }
        return repList;
    }
}
