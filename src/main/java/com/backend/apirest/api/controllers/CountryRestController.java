package com.backend.apirest.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.apirest.api.model.entity.Country;
import com.backend.apirest.api.model.services.ICountryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryRestController {

    @Autowired
    private ICountryService countryService;
    
    @GetMapping("/countries")
    public ResponseEntity<?> index(){
        return  new ResponseEntity<List<Country>>(countryService.findall(), HttpStatus.OK);
    }

    @GetMapping("countries/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){

        Country country = null;
        Map<String, Object> response = new HashMap<>();

        try{
            country = countryService.findById(id);
        }catch(DataAccessException e){
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        

        if(country == null){
            response.put("mensaje", "El pais ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }
}
