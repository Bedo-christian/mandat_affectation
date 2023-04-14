package com.mandat.affecationf.dao;

import com.mandat.affecationf.entity.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffectationDao extends JpaRepository<Affectation,Integer> {
}
