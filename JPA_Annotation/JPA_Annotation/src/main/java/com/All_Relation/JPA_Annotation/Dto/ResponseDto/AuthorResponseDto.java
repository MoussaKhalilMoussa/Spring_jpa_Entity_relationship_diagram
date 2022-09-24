package com.All_Relation.JPA_Annotation.Dto.ResponseDto;

import lombok.Data;

import java.util.List;
@Data
public class AuthorResponseDto {
        private Long id;
        private String name;
        private List<String> bookNames;
        private String zipCodeName;
}
