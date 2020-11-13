package api.comunicacao.org.plataforma.de.comunicacao.controllers;

@RestController
public class ComunicacaoController {

    @Autowired
    MensagemRepository mensagemRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/mensagens")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(mensagemRepository.findAll(), HttpStatus.OK);
    }

}
