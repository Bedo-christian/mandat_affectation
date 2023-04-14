package com.mandat.affecationf.service.impl;

import com.mandat.affecationf.dao.AffectationDao;
import com.mandat.affecationf.entity.Affectation;
import com.mandat.affecationf.exception.NotFoundException;
import com.mandat.affecationf.mapper.AffectationMapper;
import com.mandat.affecationf.model.AffectationDto;
import com.mandat.affecationf.model.AffectationResponse;
import com.mandat.affecationf.service.AffectationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AffectaionServiceImpl implements AffectationService {

    Logger logger = LoggerFactory.getLogger(AffectaionServiceImpl.class);

    private final AffectationMapper mapper;
    private final AffectationDao dao;
    public AffectaionServiceImpl(AffectationMapper affectationMapper, AffectationDao affectationDao){
        this.mapper = affectationMapper;
        this.dao = affectationDao;
    }

    /**
     * @return
     */
    @Override
    public List<AffectationResponse> getAllAffectation() {
        List<Affectation> affectationList = dao.findAll();
        List<AffectationResponse> repList = new ArrayList<>();
        for (Affectation affectation: affectationList){
            repList.add(mapper.EntityToAffectDto(affectation));
        }
        return repList;
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public AffectationDto saveAffectation(AffectationDto dto) {
        logger.info("AFF002, Enregistrement projet");
        dao.save(mapper.dtoToAffectationEntity(dto));
        return dto;
    }

    /**
     * @param idAffectation
     * @param dto
     * @return
     */
    @Override
    public AffectationDto updateAffectation(Integer idAffectation, AffectationDto dto) {
        Optional<Affectation> affectation = dao.findById(idAffectation);
        logger.info("AFF003 mis à jour affectation");
        if (affectation.isPresent()){
            Affectation affectEntity = affectation.get();
            mapper.updateEntityFromDto(dto,affectEntity);
            dao.save(affectEntity);
            return dto;
        }else{
            throw new NotFoundException();
        }
    }

    /**
     * @param affectationId
     * @return
     */
    @Override
    public AffectationResponse getAffectationById(Integer affectationId) {
        logger.info("AFF003 get affectationById"+affectationId);
        Optional<Affectation> affectation = dao.findById(affectationId);
        if (affectation.isPresent()){
            return mapper.EntityToAffectDto(affectation.get());
        }else{
            throw new NotFoundException();
        }
    }

    /**
     * @param affectId
     */
    @Override
    public void deleteAffectationById(Integer affectId) {
        logger.info("AFF005 supprime une affectation");
        dao.deleteById(affectId);
    }
}
