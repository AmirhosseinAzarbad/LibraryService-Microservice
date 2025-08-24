package ir.speedy.libraryservice.controllers;

import ir.speedy.libraryservice.models.Book;
import ir.speedy.libraryservice.models.Library;
import ir.speedy.libraryservice.services.LibraryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/library/v1")
public class LibraryController {
    private final RestTemplate restTemplate;
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService, RestTemplate restTemplate) {
        this.libraryService = libraryService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/show")
    public List<Library> findAll() {
        return libraryService.findAllLibraries();
    }

    @GetMapping("/{id}")
    public Library findById(@PathVariable int id) {
        Book book = restTemplate.getForObject("http://localhost:9093/api/book/v1/" + id, Book.class);
        Library library = libraryService.findLibraryById(id);
        library.setBook(book);
        return library;
    }

    @PostMapping("/insert")
    public Library insert(@RequestBody Library library) {
        return libraryService.insertLibrary(library);
    }
}
