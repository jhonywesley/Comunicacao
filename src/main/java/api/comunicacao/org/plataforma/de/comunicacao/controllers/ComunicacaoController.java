package api.comunicacao.org.plataforma.de.comunicacao.controllers;

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
