package com.mandat.affecationf.service;

import com.mandat.affecationf.model.AffectationDto;
import com.mandat.affecationf.model.AffectationResponse;
import com.mandat.affecationf.model.ProjetDto;
import com.mandat.affecationf.model.ProjetResponse;

import java.util.List;

/**
 * service interface pour Affectation
 */
public interface AffectationService {

    List<AffectationResponse> getAllAffectation();
    AffectationDto saveAffectation(AffectationDto dto);
    AffectationDto updateAffectation(Integer idAffectation, AffectationDto dto);
    AffectationResponse getAffectationById(Integer affectationId);
    void deleteAffectationById(Integer affectId);
}
