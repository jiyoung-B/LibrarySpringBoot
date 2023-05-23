package exam.springboot.jpa.library.service;

import exam.springboot.jpa.library.dao.LibraryDAO;
import exam.springboot.jpa.library.model.Library;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("libsrv")
public class LibraryServiceImpl implements LibraryService{
    @Autowired
    private LibraryDAO libdao;


    @Override
    public boolean newLibrary(Library lib) {
        boolean result = false;
        if(libdao.insertLibrary(lib) > 0) result = true;
        return result;
    }

   /* @Override
    public List<Library> readLibrary(int cpage) {

        return libdao.selectLibrary(cpage - 1);
    }*/

    @Override
    public Map<String, Object> readLibrary(int cpage) {

        return libdao.selectLibrary(cpage - 1);
    }


    /*@Override
    public int countLibrary() {
        return libdao.countLibrary();
    }*/

    @Override
    public List<Library> readLibrary(Pageable pageable) {
        return libdao.selectLibrary(pageable);
    }

    @Override
    public Library readOneLibrary(int lbno) {

        return libdao.selectOneLibrary(lbno);
    }

    @Override
    public boolean modifyLibrary(Library lib) {
        boolean result = false;
        if(libdao.updateLibrary(lib) > 0) result = true;
        return result;
    }

    @Override
    public boolean removeLibrary(int lbno) {
        libdao.deleteLibrary(lbno);
        return true;
    }
}
