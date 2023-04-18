package com.mandat.affecationf.service.impl;

import com.mandat.affecationf.dao.UtilisateurDao;
import com.mandat.affecationf.entity.Role;
import com.mandat.affecationf.entity.Utilisateur;
import com.mandat.affecationf.mapper.UtilisateurMapper;
import com.mandat.affecationf.model.UtilisateurDto;
import com.mandat.affecationf.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UtilisateurServiceImpl implements UserDetailsService, UtilisateurService {


    private UtilisateurDao utilisateurDao;
    private UtilisateurMapper mapper;
    private PasswordEncoder passwordEncoder;
    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao, UtilisateurMapper mapper, PasswordEncoder passwordEncoder) {
        this.utilisateurDao = utilisateurDao;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    Logger logger = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

    /**
     * load User and add authorities
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurDao.findByLogin(username).orElseThrow(()->new RuntimeException("User not found:"+username));
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : utilisateur.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getCodeRole()));
        }
        logger.info("UTIL0022 Get USERNAME"+username+ "AND ROLE:"+authorities);
        return new User(utilisateur.getLogin(), utilisateur.getPassword(),authorities);
    }

    /**
     * @param utilisateurDto
     */
    @Override
    public void saveUser(UtilisateurDto utilisateurDto) {
        logger.info("UTI002 save utilisateur");
        //hash password before save
        utilisateurDto.setPassword(passwordEncoder.encode(utilisateurDto.getPassword()));
        utilisateurDao.save(mapper.dtoToEntity(utilisateurDto));
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Optional<Utilisateur> findByUsername(String username) {
        Optional<Utilisateur> utilisateur = utilisateurDao.findByLogin(username);
        return utilisateur;
    }
}
