package com.mandat.affecationf.delegate;


import com.mandat.affecationf.api.ClientsApiDelegate;
import com.mandat.affecationf.model.ClientDto;
import com.mandat.affecationf.model.ClientResponse;
import com.mandat.affecationf.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;


import java.util.List;
import java.util.Optional;

/**
 *  Point d'entrée du controle pour le Client comme Controller normale
 *
 */ /**
 * Point d'entrée du controle pour le Client comme Controller normale
 */
@Service
public class ClientDelegate implements ClientsApiDelegate {

    @Autowired
    ClientService clientService;

    @Override
    public ResponseEntity<Void> deleteClientById(Integer clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clientDtoList = clientService.getAllClients();
        return ResponseEntity.ok(clientDtoList);
    }

    @Override
    public ResponseEntity<ClientResponse> getClientById(Integer clientId) {
        ClientResponse clientDto = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDto);
    }


    @Override
    public ResponseEntity<ClientDto> saveClient(ClientDto clientDto) {
        ClientDto dto = clientService.saveClient(clientDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientDto> updateClientById(Integer clientId, ClientDto clientDto) {
        ClientDto  dto = clientService.updateClient(clientId,clientDto);
        return ResponseEntity.ok(dto);
    }
}
