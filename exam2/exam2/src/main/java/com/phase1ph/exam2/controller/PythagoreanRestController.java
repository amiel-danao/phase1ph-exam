package com.phase1ph.exam2.controller;

import com.phase1ph.exam2.model.Pythagorean;
import com.phase1ph.exam2.model.Response;
import com.phase1ph.exam2.service.PythagoreanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PythagoreanRestController {
    @Autowired
    private PythagoreanService pythagoreanService;

    @GetMapping(path="/compute", produces= MediaType.APPLICATION_JSON_VALUE)
    public String compute(@RequestParam("c") int c){

        Response response = new Response();
        Pythagorean pythagorean = pythagoreanService.computePythagorean(c);
        if (pythagorean != null) {
            response.setResponse(pythagorean.toString());
        }
        pythagoreanService.addResponseToDb(response);
        return response.getResponse();
    }
}
