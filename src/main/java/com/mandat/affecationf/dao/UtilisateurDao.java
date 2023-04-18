package com.mandat.affecationf.dao;

import com.mandat.affecationf.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurDao extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findByLogin(String login);
}
