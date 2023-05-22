package exam.springboot.jpa.library.service;


import exam.springboot.jpa.library.model.Library;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibraryService {

    boolean newLibrary(Library lib);
    List<Library> readLibrary(Pageable pageable);
    List<Library> readLibrary(int cpg);
    int countLibrary();
    Library readOneLibrary(int lbno);

    boolean modifyLibrary(Library lib);

    boolean removeLibrary(int lbno);

}
