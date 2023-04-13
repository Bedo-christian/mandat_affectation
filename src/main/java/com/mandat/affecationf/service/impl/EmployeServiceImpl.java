package com.mandat.affecationf.service.impl;

import com.mandat.affecationf.dao.EmployeDao;
import com.mandat.affecationf.entity.Employe;
import com.mandat.affecationf.exception.CustomException;
import com.mandat.affecationf.exception.NotFoundException;
import com.mandat.affecationf.mapper.EmployeMapper;
import com.mandat.affecationf.model.EmployeReq;
import com.mandat.affecationf.model.EmployesRep;
import com.mandat.affecationf.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public EmployeReq saveEmploye(EmployeReq employeReq) {
        employeReq.setDateEmbauche(new Date());
        employeDao.save(employeMapper.dtoToEmployEntity(employeReq));
        return employeReq;
    }

    @Override
    public EmployeReq updateEmploye(Integer idEmploye, EmployeReq employeReq) {
        Optional<Employe> employe = employeDao.findById(idEmploye);
        try{
            Employe  employeEntity = employe.get();
             employeMapper.updateEntityFromDto(employeReq,employeEntity);
             employeDao.save(employeEntity);
           return employeReq;
        }catch (CustomException ex){
            throw new CustomException("BAD REQUEST", HttpStatus.BAD_REQUEST.value());
        }
    }

    @Override
    public EmployesRep getEmployeById(Integer employeId) {
        try {
            Optional<Employe> employe = employeDao.findById(employeId);
            if (employe.isPresent()){
                EmployesRep employesRep = employeMapper.toEmployeDto(employe.get());
                return employesRep;
            }else {
                System.out.println("TSY MANDALO");
                throw new CustomException("ID" + employeId + "NOT FOUND", HttpStatus.NOT_FOUND.value());
            }

        } catch (NotFoundException ex) {
            System.out.println("TESTTESTTTE");
            throw new NotFoundException();
        }
    }
    @Override
    public void deleteEmployeById(Integer employeId) {
        try {
            employeDao.deleteById(employeId);
        }catch (CustomException ex){
            throw new CustomException("BAD REQUEST", HttpStatus.BAD_REQUEST.value());
        }
    }

}
