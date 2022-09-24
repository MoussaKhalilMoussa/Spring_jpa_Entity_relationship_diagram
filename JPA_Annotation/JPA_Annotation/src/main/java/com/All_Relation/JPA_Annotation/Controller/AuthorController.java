package com.All_Relation.JPA_Annotation.Controller;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.AuthorRequestDto;
import com.All_Relation.JPA_Annotation.Dto.ResponseDto.AuthorResponseDto;
import com.All_Relation.JPA_Annotation.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody final AuthorRequestDto authorRequestDto){
        AuthorResponseDto authorResponseDto = authorService.addAuthor(authorRequestDto);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }
    @GetMapping("/getByAuthorById{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable final Long id){
        AuthorResponseDto authorResponseDto = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorResponseDto,HttpStatus.OK);
    }
    @GetMapping("/getAllAuthors")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors(){
        List<AuthorResponseDto> authorResponseDtos = authorService.getAuthors();
        return new ResponseEntity<List<AuthorResponseDto>>(authorResponseDtos,HttpStatus.OK);
    }
    @DeleteMapping("/deleteAuthor/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable final Long id){
        AuthorResponseDto authorResponseDto = authorService.deleteAuthor(id);
        return new ResponseEntity<>(authorResponseDto,HttpStatus.OK);
    }
    @PutMapping("/editAuthor/{id}")
    public ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable final Long id,
                                                        @RequestBody final AuthorRequestDto authorRequestDto){
       AuthorResponseDto authorResponseDto = authorService.editAuthor(id,authorRequestDto);
       return new ResponseEntity<>(authorResponseDto,HttpStatus.OK);
    }
    @PostMapping("/addZipCode/{zipCodeId}/to/{authorId}")
    public ResponseEntity<AuthorResponseDto> addZipCode(@PathVariable final Long zipCodeId,
                                                         @PathVariable final Long authorId){
        AuthorResponseDto authorResponseDto = authorService.addZipCodeToAuthor(authorId,zipCodeId);
        return new ResponseEntity<>(authorResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/removeZipCode/{id}")
    public ResponseEntity<AuthorResponseDto> removeZipCode(@PathVariable final Long id){
        AuthorResponseDto authorResponseDto = authorService.deleteZipCodeFromAuthor(id);
        return new ResponseEntity<>(authorResponseDto,HttpStatus.OK);

    }























}
