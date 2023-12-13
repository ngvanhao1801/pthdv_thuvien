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
		Optional<?> student = libraryService.findById(maSach);

		return ResponseEntity.ok(student);
	}

	@PostMapping("/library/save")
	public ResponseEntity<?> createNewLibrary(@RequestBody Library library) {

		return new ResponseEntity<>(libraryService.save(library), HttpStatus.OK);
	}

	@PutMapping("/library/update/{id}")
	public ResponseEntity<?> updateLibrary(@PathVariable("id") Integer maSach, @RequestBody Library library) {
		Library updatedLibrary = libraryService.updateLibrary(maSach, library);

		return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
	}

	@DeleteMapping("/library/delete/{id}")
	public ResponseEntity<?> deleteLibrary(@PathVariable("id") Integer maSach) {
		libraryService.deleteLibrary(maSach);

		return new ResponseEntity<>("Đã xóa thành công", HttpStatus.OK);
	}

}
