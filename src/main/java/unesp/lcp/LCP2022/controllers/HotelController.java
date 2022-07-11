/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unesp.lcp.LCP2022.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import unesp.lcp.LCP2022.models.Hotel;
import unesp.lcp.LCP2022.services.v1.HotelServiceImpl;

/**
 *
 * @author Bruno
 */
@RestController
public class HotelController {   
    @Autowired
    private HotelServiceImpl hotelServicos;
    
    @PostMapping
    public void novoHotel(@RequestBody Hotel hotel){
        String nome, cidade, cep, numero;
        nome = "Mãe Preta's Palace";
        hotel.setName(nome);
        cidade = "Rio Claro";
        hotel.setCity(cidade);
        cep = "06626080";
        hotel.setCep(cep);
        numero = "3598";
        hotel.setNumber(numero);
        hotelServicos.createNewHotel(hotel);
    }
    
    @RequestMapping("/")
    @ResponseBody
    public List<Hotel> verHoteis(){
        List<Hotel> hoteis;
        hoteis = hotelServicos.listHotels();
        return hoteis; 
    }
}
