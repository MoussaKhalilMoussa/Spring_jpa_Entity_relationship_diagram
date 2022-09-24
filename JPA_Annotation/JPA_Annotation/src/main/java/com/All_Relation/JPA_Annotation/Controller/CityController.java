package com.All_Relation.JPA_Annotation.Controller;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.CityRequestDto;
import com.All_Relation.JPA_Annotation.Model.City;
import com.All_Relation.JPA_Annotation.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping("/addCity")
    public ResponseEntity<City> addCity (@RequestBody final CityRequestDto cityRequestDto){
        City city = cityService.addCity(cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @GetMapping("/getCityById/{id}")
    public ResponseEntity<City> getCityById(@PathVariable final Long id){
        City city = cityService.getCity(id);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }
    @GetMapping("/getAllCities")
    public ResponseEntity<List<City>> getCities(){
        List<City> cities = cityService.getCities();
        return new ResponseEntity<List<City>>(cities,HttpStatus.OK);
    }
    @DeleteMapping("deleteCityById/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable final Long id){
        City city = cityService.deleteCity(id);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }
    @PostMapping("/editCity/{id}")
    public ResponseEntity<City> editCity (@RequestBody final CityRequestDto cityRequestDto,
                                          @PathVariable final Long id){
        City city = cityService.editCity(id,cityRequestDto);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }


























}
