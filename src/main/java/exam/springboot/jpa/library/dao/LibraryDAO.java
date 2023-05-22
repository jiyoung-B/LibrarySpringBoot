package exam.springboot.jpa.library.dao;

import exam.springboot.jpa.library.model.Library;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibraryDAO {

    int insertLibrary(Library lib);
    List<Library> selectLibrary(Pageable pageable);
    List<Library> selectLibrary(int cpage);

    int countLibrary();
    Library selectOneLibrary(int lbno);
    int updateLibrary(Library lib);
    int deleteLibrary(int lbno);


}
