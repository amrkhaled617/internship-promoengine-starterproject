package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }
    @GetMapping("/inquiry")
    public CustomerInfoModel getInfo(@RequestParam String msisdn){

        return service.getInfo(msisdn);
    }
    @GetMapping("/add")
    public void addGift(@RequestParam String msisdn,@RequestParam int offerId){
        service.addGift(msisdn,offerId);
    }
}

