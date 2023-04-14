package com.mandat.affecationf.delegate;


import com.mandat.affecationf.api.ProjetsApiDelegate;
import com.mandat.affecationf.model.ProjetDto;
import com.mandat.affecationf.model.ProjetResponse;
import com.mandat.affecationf.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Point d'entrée du controle pour le projet comme Controller normale
 */
@Service
public class ProjetDelegate implements ProjetsApiDelegate {

    @Autowired
    ProjetService projetService;

    /**
     * DELETE /projets/{projet_id} : Supprimer un client par ID
     *
     * @param projetId ID du projet à supprimer (required)
     * @return Aucun contenu (status code 204)
     * or client non trouvé (status code 404)
     * @see ProjetsApi#deleteProjetById
     */
    @Override
    public ResponseEntity<Void> deleteProjetById(Integer projetId) {
        projetService.deleteProjetById(projetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * GET /projets : Récupérer la liste des toutes les projets disponibles
     *
     * @return OK (status code 200)
     * or Erreur interne du serveur (status code 500)
     * @see ProjetsApi#getAllListProjet
     */
    @Override
    public ResponseEntity<List<ProjetResponse>> getAllListProjet() {
        List<ProjetResponse> projetList = projetService.getAllProjet();
        return ResponseEntity.ok(projetList);
    }

    /**
     * GET /projets/{projet_id} : Obtenir un projet par ID
     * Récupère un Projet spécifique en fonction de son ID.
     *
     * @param projetId ID du projet à récupérer (required)
     * @return Succès - Ressource récupérée (status code 200)
     * or Ressource non trouvée (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see ProjetsApi#getProjetById
     */
    @Override
    public ResponseEntity<ProjetResponse> getProjetById(Integer projetId) {
        ProjetResponse projetDto = projetService.getProjetById(projetId);
        return new ResponseEntity<>(projetDto,HttpStatus.OK);
    }

    /**
     * POST /projets : Enregistrement des projets
     *
     * @param projetDto (optional)
     * @return Ajout success (status code 201)
     * or Erreur interne du serveur (status code 500)
     * @see ProjetsApi#saveProjets
     */
    @Override
    public ResponseEntity<ProjetDto> saveProjets(ProjetDto projetDto) {
        ProjetDto projetDto1 = projetService.saveProjet(projetDto);
        return new ResponseEntity<>(projetDto1, HttpStatus.CREATED);
    }

    /**
     * PUT /projets/{projet_id} : Mettre à jour la table projet
     *
     * @param projetId  ID du projet à mettre à jour&#39; (required)
     * @param projetDto (optional)
     * @return Data mis à jour avec succès (status code 200)
     * or data non trouvé (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see ProjetsApi#updateProjet
     */
    @Override
    public ResponseEntity<ProjetDto> updateProjet(Integer projetId, ProjetDto projetDto) {
        ProjetDto dto = projetService.updateProjet(projetId,projetDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
