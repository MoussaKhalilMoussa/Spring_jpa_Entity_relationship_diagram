package com.All_Relation.JPA_Annotation.Dto.RequestDTO;

import lombok.Data;

import java.util.List;

@Data
public class BookRequestDto {
    private String name;
    private List<Long> authorIds;
    private Long categoryId;

}
