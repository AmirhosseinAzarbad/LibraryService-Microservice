package ir.speedy.libraryservice.services;

import ir.speedy.libraryservice.models.Library;
import ir.speedy.libraryservice.repositories.LibraryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library insertLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library findLibraryById(int id) {
        return libraryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Library not found"));
    }

    public List<Library> findAllLibraries() {
        return libraryRepository.findAll();
    }

}
