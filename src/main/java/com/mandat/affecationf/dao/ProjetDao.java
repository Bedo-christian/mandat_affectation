package com.mandat.affecationf.dao;

import com.mandat.affecationf.entity.Employe;
import com.mandat.affecationf.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetDao extends JpaRepository<Projet,Integer> {
}
