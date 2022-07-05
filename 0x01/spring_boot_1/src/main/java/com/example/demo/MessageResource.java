package com.example.demo;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {
    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password){
        String message;
        if (user.isEmpty() || password .isEmpty()) {
            message = "USUÁRIO E SENHA NÃO INFORMADOS";
        } else if (user.length() > 16 || password.length() > 16) {
            message = "USUÁRIO E SENHA INVÁLIDOS";
        } else {
            message = "LOGIN EFETUADO COM SUCESSO !!!";
        }
        return message;
    }
}
