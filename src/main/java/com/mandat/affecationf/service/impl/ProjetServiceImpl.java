package com.mandat.affecationf.service.impl;

import com.mandat.affecationf.dao.ProjetDao;
import com.mandat.affecationf.entity.Projet;
import com.mandat.affecationf.exception.NotFoundException;
import com.mandat.affecationf.mapper.ProjetMapper;
import com.mandat.affecationf.model.ProjetDto;
import com.mandat.affecationf.service.ProjetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {

    Logger logger = LoggerFactory.getLogger(ProjetServiceImpl.class);

    private final ProjetMapper projetMapper;
    private final ProjetDao projetDao;
    public ProjetServiceImpl(ProjetMapper projetMapper, ProjetDao projetDao){
        this.projetMapper = projetMapper;
        this.projetDao = projetDao;
    }

    @Override
    public List<ProjetDto> getAllProjet() {
        logger.info("PRecuperer toutes les Projet");
        List<Projet> projetList = projetDao.findAll();
        List<ProjetDto> repList = new ArrayList<>();
        for (Projet projet: projetList){
            repList.add(projetMapper.EntityToProjetDto(projet));
        }
        return repList;
    }

    @Override
    public ProjetDto saveProjet(ProjetDto projetDto) {
        logger.info("P002, Enregistrement projet");
        projetDao.save(projetMapper.dtoToProjetEntity(projetDto));
        return projetDto;
    }

    @Override
    public ProjetDto updateProjet(Integer idProjet, ProjetDto projetDto) {
        Optional<Projet> projet = projetDao.findById(idProjet);
        logger.info("P003 mis à jour projet");
        if (projet.isPresent()){
            Projet  projetEntity = projet.get();
            projetMapper.updateEntityFromDto(projetDto,projetEntity);
            projetDao.save(projetEntity);
            return projetDto;
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public ProjetDto getProjetById(Integer projetId) {
        logger.info("P003 getByIdprojet");
        Optional<Projet> projet = projetDao.findById(projetId);
        if (projet.isPresent()){
            return projetMapper.EntityToProjetDto(projet.get());
        }else{
            throw new NotFoundException();
        }    }

    @Override
    public void deleteProjetById(Integer projetId) {
        logger.info("P005 supprime projet");
        projetDao.deleteById(projetId);
    }

}
