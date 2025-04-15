/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.temperatura.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/temperatura")
/**
 *
 * @author Alumno-ETI
 */
public class TemperaturaController {
    @GetMapping("/celsius-a-fahrenheit")
    public String convertir(@RequestParam double celsius){
        double fahrenheit = (celsius * 9/5)+32;
        return String.format("%.2f°C = %.2f°F", celsius, fahrenheit);
    }
    
}
