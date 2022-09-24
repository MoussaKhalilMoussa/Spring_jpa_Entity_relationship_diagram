package com.All_Relation.JPA_Annotation.Service;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.AuthorRequestDto;
import com.All_Relation.JPA_Annotation.Dto.ResponseDto.AuthorResponseDto;
import com.All_Relation.JPA_Annotation.Model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    public List<AuthorResponseDto> getAuthors();
    public AuthorResponseDto getAuthorById(Long authorId);
    public Author getAuthor(Long authorId);
    public AuthorResponseDto deleteAuthor(Long authorId);
    public AuthorResponseDto editAuthor( Long authorId , AuthorRequestDto authorRequestDto);
    public AuthorResponseDto addZipCodeToAuthor(Long authorId, Long zipCodeId);
    public AuthorResponseDto deleteZipCodeFromAuthor(Long authorId);
}
