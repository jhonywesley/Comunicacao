package api.comunicacao.org.plataforma.de.comunicacao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitialController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    @ResponseBody
    public String initial() {
        return "REST API is running!";
    }

    
}


