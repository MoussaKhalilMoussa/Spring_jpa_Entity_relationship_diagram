package com.All_Relation.JPA_Annotation.Controller;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.ZipCodeRequestDto;
import com.All_Relation.JPA_Annotation.Model.ZipCode;
import com.All_Relation.JPA_Annotation.Service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zipCode")
public class ZipCodeController {


    private final ZipCodeService zipCodeService;
    @Autowired
    public ZipCodeController(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }


    @PostMapping("/addZipCode")
    public ResponseEntity<ZipCode> addZipCode(@RequestBody final ZipCodeRequestDto zipCodeRequestDto){
        ZipCode zipCode = zipCodeService.addZipCode(zipCodeRequestDto);
        return new ResponseEntity<>(zipCode, HttpStatus.OK);
    }

    @GetMapping("/getZipCodeById/{id}")
    public ResponseEntity<ZipCode> getZipCode(@PathVariable final Long id){
        ZipCode zipCode = zipCodeService.getZipCode(id);
        return new ResponseEntity<>(zipCode,HttpStatus.OK);
    }

    @GetMapping("/getAllZipCodes")
    public ResponseEntity<List<ZipCode>> getZipCodes(){
        List<ZipCode> zipCodes = zipCodeService.getZipCodes();
        return new ResponseEntity<>(zipCodes,HttpStatus.OK);
    }
    @DeleteMapping("deleteZipCode/{id}")
    public ResponseEntity<ZipCode> deleteZipCode(@PathVariable final Long id){
        ZipCode zipCode = zipCodeService.deleteZipCode(id);
        return new ResponseEntity<>(zipCode,HttpStatus.OK);
    }

    @PutMapping("/editZipCode/{id}")
    public ResponseEntity<ZipCode> editZipCode(@RequestBody final ZipCodeRequestDto zipCodeRequestDto,
                                               @PathVariable final Long id){
        ZipCode zipCode = zipCodeService.editZipCode(id,zipCodeRequestDto);
        return new ResponseEntity<>(zipCode,HttpStatus.OK);
    }


    @PostMapping("/addCity/{cityId}/toZipCode{zipCodeId}")
    public ResponseEntity<ZipCode> addCityToZipCode(@PathVariable final Long cityId,
                                                    @PathVariable final Long zipCodeId){
        ZipCode zipCode = zipCodeService.addCityToZipCode(zipCodeId,cityId);
        return new ResponseEntity<>(zipCode,HttpStatus.OK);
    }

    @DeleteMapping("/deleteCity/FromZipCode{zipCodeId}")
    public ResponseEntity<ZipCode> deleteCityFromZipCode(@PathVariable final Long zipCodeId){
        ZipCode zipCode = zipCodeService.removeCityFromZipCode(zipCodeId);
        return new ResponseEntity<>(zipCode,HttpStatus.OK);

    }
















}
