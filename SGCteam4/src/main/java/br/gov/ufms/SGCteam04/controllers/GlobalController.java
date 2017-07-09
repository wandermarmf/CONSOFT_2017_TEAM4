package br.gov.ufms.SGCteam04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marco Cardoso on 7/6/2017.
 */
@Controller
public class GlobalController {


    @RequestMapping("/")
    public String index()
    {
        return "/default/index";
    }
}
