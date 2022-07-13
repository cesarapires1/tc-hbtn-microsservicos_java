package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        int numero;
        List <Integer> sorteioMegaSena = new ArrayList<>();
        Random sorteio = new Random();

        while(sorteioMegaSena.size() < 6){
            numero = sorteio.nextInt(60);

            if (!sorteioMegaSena.contains(numero)) {
                sorteioMegaSena.add(numero);
            }
        }

        Collections.sort(sorteioMegaSena);

        return sorteioMegaSena;
    }
}
