package com.All_Relation.JPA_Annotation.Service;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.BookRequestDto;
import com.All_Relation.JPA_Annotation.Dto.ResponseDto.BookResponseDto;
import com.All_Relation.JPA_Annotation.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public BookResponseDto addBook(BookRequestDto bookRequestDto);
    public BookResponseDto getBookById(Long bookId);
    public Book getBook(Long bookId);
    public List<BookResponseDto> getBooks();
    public BookResponseDto deleteBook(Long bookId);
    public BookResponseDto editBook(Long bookId,BookRequestDto bookRequestDto);
    public BookResponseDto addAuthorToBook (Long bookId, Long authorId);
    public BookResponseDto deleteAuthorFromBook(Long bookId , Long authorId);
    public BookResponseDto addCategoryToBook(Long bookId, Long categoryId);
    public BookResponseDto deleteCategoryFromBook(Long bookId,Long categoryId);


}
