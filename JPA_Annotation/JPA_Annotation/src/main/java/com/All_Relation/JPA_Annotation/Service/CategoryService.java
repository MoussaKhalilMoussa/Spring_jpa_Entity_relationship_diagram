package com.All_Relation.JPA_Annotation.Service;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.CategoryRequestDto;
import com.All_Relation.JPA_Annotation.Dto.ResponseDto.CategoryResponseDto;
import com.All_Relation.JPA_Annotation.Model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public Category getCategory(Long categoryId);
    public CategoryResponseDto addCategory (CategoryRequestDto categoryRequestDto);
    public CategoryResponseDto getCategoryById(Long categoryId);
    public List<CategoryResponseDto> getCategories();
    public CategoryResponseDto deleteCategory (Long categoryId);
    public CategoryResponseDto editCategory(Long categoryId , CategoryRequestDto categoryRequestDto);

}
