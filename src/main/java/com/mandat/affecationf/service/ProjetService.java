package com.mandat.affecationf.service;

import com.mandat.affecationf.model.ClientDto;
import com.mandat.affecationf.model.ProjetDto;

import java.util.List;

/**
 * service interface pour Projet
 */
public interface ProjetService {

    List<ProjetDto> getAllProjet();
    ProjetDto saveProjet(ProjetDto projetDto);
    ProjetDto updateProjet(Integer idProjet, ProjetDto projetDto);
    ProjetDto getProjetById(Integer projetId);
    void deleteProjetById(Integer projetId);
}
