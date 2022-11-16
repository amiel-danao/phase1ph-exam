package com.phase1ph.exam2.controller;

import com.phase1ph.exam2.model.Pythagorean;
import com.phase1ph.exam2.model.Response;
import com.phase1ph.exam2.service.PythagoreanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class PythagoreanController {

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String goHome(){
        return "index";
    }


}
