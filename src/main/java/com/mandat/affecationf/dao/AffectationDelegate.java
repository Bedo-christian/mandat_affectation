package com.mandat.affecationf.dao;

import com.mandat.affecationf.api.AffectationApiDelegate;
import com.mandat.affecationf.model.AffectationDto;
import com.mandat.affecationf.model.AffectationResponse;
import com.mandat.affecationf.service.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffectationDelegate implements AffectationApiDelegate {

    @Autowired
    AffectationService affectationService;

    /**
     * DELETE /affectation/{affectation_id} : Supprimer une affectation par ID
     *
     * @param affectationId ID du affectation à supprimer (required)
     * @return Aucun contenu (status code 204)
     * or client non trouvé (status code 404)
     * @see AffectationApi#deleteAffectationById
     */
    @Override
    public ResponseEntity<Void> deleteAffectationById(Integer affectationId) {
        affectationService.deleteAffectationById(affectationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * GET /affectation/{affectation_id} : Obtenir une affectation par ID
     * Récupère une affectation spécifique en fonction de son ID.
     *
     * @param affectationId ID du affection à récupérer (required)
     * @return Succès - Ressource récupérée (status code 200)
     * or Ressource non trouvée (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see AffectationApi#getAffectById
     */
    @Override
    public ResponseEntity<AffectationResponse> getAffectById(Integer affectationId) {
        AffectationResponse response = affectationService.getAffectationById(affectationId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /**
     * GET /affectation : Récupérer la liste des toutes les affectations disponibles
     *
     * @return OK (status code 200)
     * or Erreur interne du serveur (status code 500)
     * @see AffectationApi#getAllAffectation
     */
    @Override
    public ResponseEntity<List<AffectationResponse>> getAllAffectation() {
        List<AffectationResponse> responseList = affectationService.getAllAffectation();
        return new ResponseEntity<>(responseList,HttpStatus.OK);
    }

    /**
     * POST /affectation : Enregistrement des affectations
     *
     * @param affectationDto (optional)
     * @return Ajout success (status code 201)
     * or Erreur interne du serveur (status code 500)
     * @see AffectationApi#saveAffectations
     */
    @Override
    public ResponseEntity<AffectationDto> saveAffectations(AffectationDto affectationDto) {
        AffectationDto  dto = affectationService.saveAffectation(affectationDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    /**
     * PUT /affectation/{affectation_id} : Mettre à jour la table affectation
     *
     * @param affectationId  (required)
     * @param affectationDto (optional)
     * @return Data mis à jour avec succès (status code 200)
     * or data non trouvé (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see AffectationApi#updateAffectation
     */
    @Override
    public ResponseEntity<AffectationDto> updateAffectation(Integer affectationId, AffectationDto affectationDto) {
        AffectationDto dto = affectationService.updateAffectation(affectationId,affectationDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
