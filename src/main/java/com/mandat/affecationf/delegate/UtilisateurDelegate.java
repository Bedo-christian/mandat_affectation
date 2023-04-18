package com.mandat.affecationf.delegate;

import com.mandat.affecationf.api.UserApiDelegate;
import com.mandat.affecationf.entity.Utilisateur;
import com.mandat.affecationf.model.TokenResponse;
import com.mandat.affecationf.model.UtilisateurDto;
import com.mandat.affecationf.service.Authservice;
import com.mandat.affecationf.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UtilisateurDelegate implements UserApiDelegate {

    Logger logger = LoggerFactory.getLogger(UtilisateurDelegate.class);
    private UtilisateurService utilisateurService;
    private Authservice authservice;
    public UtilisateurDelegate(UtilisateurService utilisateurService, Authservice authservice) {
        this.utilisateurService = utilisateurService;
        this.authservice = authservice;
    }

    /**
     * POST /user/authentification : Obtenir un token pour s&#39;authentifier
     *
     * @param utilisateurDto (optional)
     * @return authentification Ok (status code 200)
     * or Utilisateur non autorisé login/mot de pass incorrect (status code 401)
     * or Erreur interne du serveur (status code 500)
     * @see UserApi#getToken
     */
    @Override
    public ResponseEntity<TokenResponse> getToken(UtilisateurDto utilisateurDto) {
        TokenResponse tokenResponse = authservice.getTokenWithRefresh(utilisateurDto);
        return new ResponseEntity<>(tokenResponse,HttpStatus.OK);
    }

    /**
     * POST /user : enregistrer un utilisateur avec mot de passe
     *
     * @param utilisateurDto (optional)
     * @return Utilisateur ajouté avec success (status code 201)
     * or login ou username existe déjà (status code 409)
     * or Erreur interne du serveur (status code 500)
     * @see UserApi#saveUser
     */
    @Override
    public ResponseEntity<Void> saveUser(UtilisateurDto utilisateurDto) {
        logger.info("*****CTRL0001, entry in controller to save User*****");
        Optional<Utilisateur> utilisateur =  utilisateurService.findByUsername(utilisateurDto.getLogin());
        if (utilisateur.isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        utilisateurService.saveUser(utilisateurDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
