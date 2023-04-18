package com.mandat.affecationf.mapper;

import com.mandat.affecationf.entity.Utilisateur;
import com.mandat.affecationf.model.UtilisateurDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);
    Utilisateur dtoToEntity(UtilisateurDto utilisateurDto);

}
