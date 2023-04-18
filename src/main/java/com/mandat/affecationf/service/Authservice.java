package com.mandat.affecationf.service;

import com.mandat.affecationf.model.TokenResponse;
import com.mandat.affecationf.model.UtilisateurDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Authservice {
    private JwtEncoder jwtEncoder;
    private JwtDecoder jwtDecoder;
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;

    @Value("${jwt.token.expiration}")
    private int minutesJwt;

    public Authservice(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    /**
     * function to get access Token
     * @param utilisateurDto
     * @return
     */
    public TokenResponse getTokenWithRefresh( UtilisateurDto utilisateurDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(utilisateurDto.getLogin(), utilisateurDto.getPassword())
        );
       String subject = authentication.getName();
       String  scope = authentication.getAuthorities().stream().map(auth->auth.getAuthority()).collect(Collectors.joining(" "));

        return responseTokenUtil(subject,scope);
    }

    /**
     * refresh token by the old access token
     * @param refreshToken
     * @return
     */
    public TokenResponse refreshToken(String refreshToken){
        TokenResponse tokenResponse = new TokenResponse();

        //decode token to get the get the information of connection
        Jwt decodeJWT = jwtDecoder.decode(refreshToken);
        String subject =  decodeJWT.getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        String scope = authorities.stream().map(auth->auth.getAuthority()).collect(Collectors.joining(" "));

        return responseTokenUtil(subject,scope);
    }

    /**
     * function to get
     * @param subject
     * @param scope
     * @return
     */
    private TokenResponse responseTokenUtil(String subject, String scope){
        Instant instant = Instant.now();
        TokenResponse tokenResponse = new TokenResponse();
        //For access token
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(minutesJwt, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("scope",scope)
                .build();

        String jwtAccessToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();

        //For Refresh Token
        JwtClaimsSet jwtClaimsSetRefresh = JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(30, ChronoUnit.MINUTES))
                .issuer("security-service")
                // .claim("scope",scope)
                .build();
        String jwtRefreshToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
        tokenResponse.setAccessToken(jwtAccessToken);
        tokenResponse.setRefreshToken(jwtRefreshToken);

        return tokenResponse;
    }
}
