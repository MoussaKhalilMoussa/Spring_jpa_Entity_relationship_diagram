package com.All_Relation.JPA_Annotation.Service;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.AuthorRequestDto;
import com.All_Relation.JPA_Annotation.Dto.ResponseDto.AuthorResponseDto;
import com.All_Relation.JPA_Annotation.Dto.mapper;
import com.All_Relation.JPA_Annotation.Model.Author;
import com.All_Relation.JPA_Annotation.Model.ZipCode;
import com.All_Relation.JPA_Annotation.Respository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ZipCodeService zipCodeService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ZipCodeService zipCodeService) {
        this.authorRepository = authorRepository;
        this.zipCodeService = zipCodeService;
    }

    @Transactional
    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        if(authorRequestDto.getZipCodeId() == null){
            throw new IllegalArgumentException("author needs a zipCode");
        }
        ZipCode zipCode = zipCodeService.getZipCode(authorRequestDto.getZipCodeId());
        author.setZipcode(zipCode);
        authorRepository.save(author);
        return mapper.authorToAuthorResponseDto(author);
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        List<Author> authors = StreamSupport
                .stream(authorRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return mapper.authorsToAuthorResponseDtos(authors);
    }

    @Override
    public AuthorResponseDto getAuthorById(Long authorId) {
        return mapper.authorToAuthorResponseDto(getAuthor(authorId));
    }

    @Override
    public Author getAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(()->
                new IllegalArgumentException("Author with id :" +authorId+"could not be found"));
        return author;
    }

    @Override
    public AuthorResponseDto deleteAuthor(Long authorId) {
        Author author = getAuthor(authorId);
        authorRepository.delete(author);
        return mapper.authorToAuthorResponseDto(author);
    }

    @Transactional
    @Override
    public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
        Author authorToEdit = getAuthor(authorId);
        authorToEdit.setName(authorRequestDto.getName());
        if(authorRequestDto.getZipCodeId() != null){
            ZipCode zipCode = zipCodeService.getZipCode(authorRequestDto.getZipCodeId());
            authorToEdit.setZipcode(zipCode);
        }
        return mapper.authorToAuthorResponseDto(authorToEdit);

    }

    @Transactional
    @Override
    public AuthorResponseDto addZipCodeToAuthor(Long authorId, Long zipCodeId) {
        Author author = getAuthor(authorId);
        ZipCode zipCode = zipCodeService.getZipCode(zipCodeId);
        if(Objects.nonNull(author.getZipcode())){
            throw new RuntimeException("author already has a zipcode");
        }
        author.setZipcode(zipCode);
        return mapper.authorToAuthorResponseDto(author);
    }

    @Transactional
    @Override
    public AuthorResponseDto deleteZipCodeFromAuthor(Long authorId) {
        Author author = getAuthor(authorId);
        author.setZipcode(null);
        return mapper.authorToAuthorResponseDto(author);
    }
}
