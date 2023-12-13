package hunre.it.library.controller;

import hunre.it.library.entity.Library;
import hunre.it.library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class LibraryController {

	private final LibraryService libraryService;

	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}

	@GetMapping("/library")
	public List<?> list() {
		return libraryService.listAll();
	}

	@GetMapping("/library/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer maSach) {
		return ResponseEntity.ok(libraryService.findById(maSach).orElse(null));
	}

	@PostMapping("/library/save")
	public ResponseEntity<?> create(@RequestBody Library library) {
		return ResponseEntity.ok(libraryService.save(library));
	}

	@PutMapping("/library/update/{id}")
	public ResponseEntity<?> update(@RequestBody Library library) {
		Library updatedLibrary = libraryService.update(library);

		return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
	}

	@DeleteMapping("/library/delete/{id}")
	public ResponseEntity<?> deleteLibrary(@PathVariable("id") Integer maSach) {
		libraryService.deleteLibrary(maSach);

		return new ResponseEntity<>("Đã xóa thành công", HttpStatus.OK);
	}

}
