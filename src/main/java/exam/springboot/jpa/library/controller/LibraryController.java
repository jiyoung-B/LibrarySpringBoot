package exam.springboot.jpa.library.controller;

import exam.springboot.jpa.library.model.Library;
import exam.springboot.jpa.library.service.LibraryService;
import exam.springboot.jpa.library.service.LibraryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibraryController {
    @Autowired
    private LibraryServiceImpl libsrv;
    @GetMapping("/")
    public ModelAndView mainList(Integer cpg){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("list");
        if (cpg == null || cpg == 0) cpg = 1;
        mv.addObject("lib", libsrv.readLibrary(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", libsrv.countLibrary()); // startPage = ((cpg - 1) / 10) * 10 + 1);

        return mv;
    }

    @GetMapping("/page")
    public ModelAndView list(@RequestParam Integer cpg){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("librarylist");
        if (cpg == null || cpg == 0) cpg = 1;
        // sungjuklist.jsp에 성적조회결과를 sjs라는 이름으로 넘김
        mv.addObject("lib", libsrv.readLibrary(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", libsrv.countLibrary()); // startPage = ((cpg - 1) / 10) * 10 + 1);
        //mv.setViewName("board/list");

        return mv;
    }

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(sort="regdate", direction = Sort.Direction.DESC, size = 25)Pageable pageable) {
        ModelAndView mv = new ModelAndView();
        String view = "libfail";
        mv.addObject("lib", libsrv.readLibrary(pageable));

        mv.setViewName("librarylist");
        return mv;
    }

    @GetMapping("/newlib")
    public String register(){
        return "newlibrary";
    }


    @PostMapping("/newlib")
    public ModelAndView registerok(Library lib){
        ModelAndView mv = new ModelAndView();
        String view = "libraryfail";
        if(libsrv.newLibrary(lib)){
        mv.addObject("lib", lib);
            view = "redirect:/list";
        }
        mv.setViewName(view);
        return mv;

    }
// http://localhost:8080/view?lbno=1

    // 성적 본문조회 처리
    @GetMapping("/view")
    public ModelAndView view(@RequestParam int lbno){
        ModelAndView mv = new ModelAndView();
        String view = "libraryfail";

        Library lib = libsrv.readOneLibrary(lbno);
        if (lib != null) {
            mv.addObject("lib", lib);
            view = "libraryview";
        }
        mv.setViewName(view);
        return mv;

    }

    // 삭제
    @GetMapping("/remove")
    public String remove(int lbno) {
        libsrv.removeLibrary(lbno);

        // 클라이언트에게 /list를 서버에 요청하도록 지시
        return "redirect:/list";

    }

    // 성적 입력폼 표시
    @GetMapping("/modify")
    public ModelAndView modify(@RequestParam int lbno) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("lib", libsrv.readOneLibrary(lbno));
        mv.setViewName("libmodify");

        return mv;
    }

    // 성적 입력 처리
    @PostMapping("/modify")
    public ModelAndView modifyok(Library lib) {

        String view = "libfail";
        ModelAndView mv = new ModelAndView();
        if(libsrv.modifyLibrary(lib)){
            view = "redirect:/view?lbno=" + lib.getLbno();
        }
        mv.setViewName(view);

        return mv;
    }



}
