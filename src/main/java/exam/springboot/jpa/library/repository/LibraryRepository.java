package exam.springboot.jpa.library.repository;


import exam.springboot.jpa.library.model.Library;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LibraryRepository extends PagingAndSortingRepository<Library, Long> {


    int countLibraryBy();
}
