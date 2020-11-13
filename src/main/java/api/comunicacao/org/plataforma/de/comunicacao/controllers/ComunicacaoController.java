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

}
