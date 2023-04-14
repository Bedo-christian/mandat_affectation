package com.mandat.affecationf.service;

import com.mandat.affecationf.model.ClientDto;
import com.mandat.affecationf.model.EmployeReq;
import com.mandat.affecationf.model.EmployesRep;

import java.util.List;

public interface ClientService {

    List<ClientDto> getAllClients();
    ClientDto saveClient(ClientDto clientDto);
    ClientDto updateClient(Integer idClient, ClientDto clientDto);
    ClientDto getClientById(Integer clientId);
    void deleteClientById(Integer clientId);
}
