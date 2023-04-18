package com.mandat.affecationf.service;

import com.mandat.affecationf.entity.Utilisateur;
import com.mandat.affecationf.model.TokenResponse;
import com.mandat.affecationf.model.UtilisateurDto;

import java.util.Optional;

public interface UtilisateurService {
    void saveUser(UtilisateurDto utilisateurDto);
     Optional<Utilisateur> findByUsername(String username);
}
