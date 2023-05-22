package exam.springboot.jpa.library.repository;


import exam.springboot.jpa.library.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LibraryRepository extends PagingAndSortingRepository<Library, Long> {

    Page findAll(Pageable pageable);
    @Query("select ceil(count(lbno)/25) from Library ")
    int countLibraryBy();
}
