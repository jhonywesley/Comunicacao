package api.comunicacao.org.plataforma.de.comunicacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.comunicacao.org.plataforma.de.comunicacao.models.Mensagem;
import api.comunicacao.org.plataforma.de.comunicacao.repository.MensagemRepository;

@RestController
public class ComunicacaoController {

    @Autowired
    MensagemRepository mensagemRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/mensagens")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(mensagemRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/mensagem")
    public ResponseEntity<?> add(@RequestBody Mensagem mensagem) {
        return new ResponseEntity<>(mensagemRepository.save(mensagem), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/mensagem")
    public ResponseEntity<?> del(@RequestBody Mensagem mensagem) {
          boolean verificacao = mensagemRepository.existsById(mensagem.getId());
        if(verificacao){
            mensagemRepository.delete(mensagem);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(method = RequestMethod.PUT, path = "/mensagem")
    public ResponseEntity<?> update(@RequestBody Mensagem mensagem) {

        boolean verificacao = mensagemRepository.existsById(mensagem.getId());
        if(verificacao){
        return new ResponseEntity<>(mensagemRepository.save(mensagem), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
    }

}
