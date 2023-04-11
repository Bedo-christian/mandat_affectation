package com.mandat.affecationf.dao;

import com.mandat.affecationf.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeDao extends JpaRepository<Employe,Integer> {
}
