package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo a API Calculator";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        Calculator calculadora = new Calculator();
        String resultado;
        try {
            resultado = String.valueOf(calculadora.sum(n1, n2));
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return resultado;
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        Calculator calculadora = new Calculator();
        String resultado;
        try {
            resultado = String.valueOf(calculadora.sub(n1, n2));
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return resultado;
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        Calculator calculadora = new Calculator();
        String resultado;
        try {
            resultado = String.valueOf(calculadora.divide(n1, n2));
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return resultado;
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        Calculator calculadora = new Calculator();
        String resultado;
        try {
            resultado = String.valueOf(calculadora.factorial(factorial));
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return resultado;
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        Calculator calculadora = new Calculator();
        String resultado;
        try {
            resultado = String.valueOf(calculadora.calculeDayBetweenDate(localDate1, localDate2));
        } catch (Exception ex){
            return ex.getMessage();
        }
        return resultado;
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        Calculator calculadora = new Calculator();
        String resultado;
        try {
            resultado = String.valueOf(calculadora.integerToBinary(n1));
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return resultado;
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        Calculator calculadora = new Calculator();
        String resultado;
        try {
            resultado = String.valueOf(calculadora.integerToHexadecimal(n1));
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return resultado;
    }
}
