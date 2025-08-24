package ir.speedy.libraryservice.controllers;

import ir.speedy.libraryservice.models.Library;
import ir.speedy.libraryservice.services.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/v1")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/show")
    public List<Library> findAll() {
        return libraryService.findAllLibraries();
    }

    @GetMapping("/{id}")
    public Library findById(@PathVariable int id) {
        return libraryService.findLibraryById(id);
    }

    @PostMapping("/insert")
    public Library insert(@RequestBody Library library) {
        return libraryService.insertLibrary(library);
    }
}
