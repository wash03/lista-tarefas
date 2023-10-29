package com.example.listadetarefasapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "viacep", url = "https://api.adviceslip.com")
public interface ConselhoService {
    @GetMapping("/advice")
    String getConselho();

}
