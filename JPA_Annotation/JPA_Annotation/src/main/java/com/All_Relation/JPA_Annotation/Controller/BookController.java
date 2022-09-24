package com.All_Relation.JPA_Annotation.Controller;

import com.All_Relation.JPA_Annotation.Dto.RequestDTO.BookRequestDto;
import com.All_Relation.JPA_Annotation.Dto.ResponseDto.BookResponseDto;
import com.All_Relation.JPA_Annotation.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponseDto> addBook(@RequestBody final BookRequestDto bookRequestDto){
        BookResponseDto bookResponseDto = bookService.addBook(bookRequestDto);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable final Long id){
        BookResponseDto bookResponseDto = bookService.getBookById(id);
        return new ResponseEntity<>(bookResponseDto,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponseDto>> getBooks(){
        List<BookResponseDto> bookResponseDtos = bookService.getBooks();
        return new ResponseEntity<>(bookResponseDtos,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponseDto> deleteBook(@PathVariable final Long id){
      BookResponseDto bookResponseDto = bookService.deleteBook(id);
      return new ResponseEntity<>(bookResponseDto,HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<BookResponseDto> editBook(@RequestBody final  BookRequestDto bookRequestDto,
                                                    @PathVariable final Long id){
       BookResponseDto bookResponseDto = bookService.editBook(id,bookRequestDto);
       return new ResponseEntity<>(bookResponseDto,HttpStatus.OK);
    }

    @PostMapping("/addCategory/{categoryId}/toBook/{bookId}")
    public ResponseEntity<BookResponseDto> addCategoryToBook(@PathVariable final Long categoryId,
                                                       @PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.addCategoryToBook(bookId,categoryId);
        return new ResponseEntity<>(bookResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/removeCategory/{categoryId}/fromBook/{bookId}")
    public ResponseEntity<BookResponseDto> removeCategoryFromBook(@PathVariable final Long categoryId,
                                                                  @PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.deleteCategoryFromBook(bookId,categoryId);
        return new ResponseEntity<>(bookResponseDto,HttpStatus.OK);
    }


    @PostMapping("/addAuthor/{authorId}/toBook/{bookId}")
    public ResponseEntity<BookResponseDto> addAuthorToBook(@PathVariable final Long authorId,
                                                           @PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.addAuthorToBook(bookId,authorId);
        return new ResponseEntity<>(bookResponseDto,HttpStatus.OK);
    }


    @DeleteMapping("/removeAuthor/{authorId}/fromBook/{bookId}")
    public ResponseEntity<BookResponseDto> removeAuthorFromBook(@PathVariable final Long authorId,
                                                                @PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.deleteAuthorFromBook(bookId,authorId);
        return new ResponseEntity<>(bookResponseDto,HttpStatus.OK);
    }


































}
