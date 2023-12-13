package hunre.it.library.service;

import hunre.it.library.entity.Library;
import hunre.it.library.exception.NotFoundException;
import hunre.it.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

	private final LibraryRepository libraryRepository;

	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}

	public List<Library> listAll() {
		List<Library> libraries = libraryRepository.findAll();
		if (libraries.isEmpty()) {
			throw new NotFoundException("Không tồn tại số sách nào");
		}
		return libraries;
	}

	public Optional<?> findById(Integer maSach) {
		Optional<Library> libraries = libraryRepository.findById(maSach);
		if (!libraries.isPresent()) {
			throw new NotFoundException("Không tìm thấy sách với mã sách: " + maSach);
		}
		return libraries;
	}

	public Library save(Library library) {
		if (library.getNgayMuon().isAfter(library.getNgayTra())) {
			throw  new NotFoundException("Ngày trả sách không đúng!");
		}
		return libraryRepository.save(library);
	}

	public Library update(Library student) {
		Integer maSach = student.getMaSach();
		Optional<Library> existingLibrary = libraryRepository.findById(maSach);
		if (!existingLibrary.isPresent()) {
			throw new NotFoundException("Không tìm thấy sách với mã sách: " + maSach);
		}
		return libraryRepository.save(student);
	}

	public void deleteLibrary(Integer maSach) {
		if (!libraryRepository.existsById(maSach)) {
			throw new NotFoundException("Không tìm thấy sách với mã sách: " + maSach);
		}
		libraryRepository.deleteById(maSach);
	}

}
