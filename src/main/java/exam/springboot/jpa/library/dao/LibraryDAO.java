package exam.springboot.jpa.library.dao;

import exam.springboot.jpa.library.model.Library;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface LibraryDAO {

    int insertLibrary(Library lib);
    List<Library> selectLibrary(Pageable pageable);
    /*List<Library> selectLibrary(int cpage);*/

    Map<String, Object> selectLibrary(int cpage);
    /*int countLibrary(); // 이제 필요없어*/

    Library selectOneLibrary(int lbno);
    int updateLibrary(Library lib);
    int deleteLibrary(int lbno);


}
