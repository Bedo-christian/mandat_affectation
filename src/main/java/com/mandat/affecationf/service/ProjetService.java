package com.mandat.affecationf.service;

import com.mandat.affecationf.model.ProjetDto;
import com.mandat.affecationf.model.ProjetResponse;

import java.util.List;

/**
 * service interface pour Projet
 */
public interface ProjetService {

    List<ProjetResponse> getAllProjet();
    ProjetDto saveProjet(ProjetDto projetDto);
    ProjetDto updateProjet(Integer idProjet, ProjetDto projetDto);
    ProjetResponse getProjetById(Integer projetId);
    void deleteProjetById(Integer projetId);
}
