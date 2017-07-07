package br.gov.ufms.SGCteam04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Marco Cardoso on 7/6/2017.
 */
@Controller
public class GlobalController {


    @GetMapping("/")
    public String index()
    {
        return "/home/index";
    }
}
