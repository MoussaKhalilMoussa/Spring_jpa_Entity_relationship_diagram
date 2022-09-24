package com.All_Relation.JPA_Annotation.Service;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.ZipCodeRequestDto;
import com.All_Relation.JPA_Annotation.Model.ZipCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZipCodeService {
    public ZipCode addZipCode(ZipCodeRequestDto zipCodeRequestDto);
    public List<ZipCode> getZipCodes();
    public ZipCode getZipCode(Long zipCodeId);
    public ZipCode deleteZipCode(Long zipCodeId);
    public ZipCode editZipCode(Long zipCodeId, ZipCodeRequestDto zipCodeRequestDto);
    public ZipCode addCityToZipCode(Long zipCodeId, Long cityId);
    public ZipCode removeCityFromZipCode(Long zipCodeId);
}
