package exam.springboot.jpa.library.dao;

import exam.springboot.jpa.library.model.Library;
import exam.springboot.jpa.library.repository.LibraryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository("libdao")
public class LibraryDAOImpl implements LibraryDAO{
    @Autowired
    LibraryRepository libraryRepository;


    @Override
    public int insertLibrary(Library lib) {
        return 0;
    }

    @Override
    public List<Library> selectLibrary(Pageable pageable) {

        return libraryRepository.findAll(pageable).getContent();
    }

    @Override
    public Map<String, Object> selectLibrary(int cpage) {
        Pageable paging =
                PageRequest.of(cpage, 25, Sort.Direction.DESC, "lbno");

        List<Library> lblist = libraryRepository.findAll(paging).getContent();
        int cntpg = libraryRepository.findAll(paging).getTotalPages();

        Map<String, Object> libs = new HashMap<>();
        libs.put("lib", lblist);
        libs.put("cntpg", cntpg);

        return libs;
    }

    /*@Override
    public List<Library> selectLibrary(int cpage) {
        Pageable paging =
                PageRequest.of(cpage, 25, Sort.Direction.DESC, "lbno");

        List<Library> lblist = libraryRepository.findAll(paging).getContent();
        int cntpg = libraryRepository.findAll(paging).getContent();
        return ;
    }*/

    /*@Override
    public int countLibrary() {
        // select ceil(count(bno)/25) from board
        *//*int allcnt = libraryRepository.countLibraryBy();
        return (int)Math.ceil(allcnt/25);*//*

        return libraryRepository.countLibraryBy();
    }*/

    @Override
    public Library selectOneLibrary(int lbno) {
        return null;
    }

    @Override
    public int updateLibrary(Library lib) {
        return 0;
    }

    @Override
    public int deleteLibrary(int lbno) {
        return 0;
    }
}
