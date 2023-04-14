package com.mandat.affecationf.dao;

import com.mandat.affecationf.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client,Integer> {
}
