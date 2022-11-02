package kr.co.itwill.spring04_mymelon.mediagroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

import static com.sun.tools.attach.VirtualMachine.list;

@Controller
public class MediagroupCont {

    @Autowired
    private MediagroupDAO dao;


    public MediagroupCont() {
        System.out.println("-----MediagroupCont() 객체 생성됨");
    } // end

    // 미디어그룹 쓰기 페이지 호출
    // http://localhost:9095/mediagroup/create.do
    @RequestMapping(value = "/mediagroup/create.do", method = RequestMethod.GET)
    public String createForm() {
        return "mediagroup/createForm";
    } // createForm() end

    @RequestMapping(value = "mediagroup/create.do", method = RequestMethod.POST)
    public ModelAndView createProc(@ModelAttribute MediagroupDTO dto) {
        ModelAndView mav = new ModelAndView();

        int cnt = dao.create(dto);
        if (cnt == 0) {
            mav.setViewName("mediagroup/msgView");
            String msg1 = "<p>미디어 그룹 등록 실패</p>";
            String img = "<img src='../images/fail.png' style='width:100px;'>";
            String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2 = "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";
            mav.addObject("msg1", msg1);
            mav.addObject("img", img);
            mav.addObject("link1", link1);
            mav.addObject("link2", link2);
        } else {
            mav.setViewName("redirect:/mediagroup/list.do");
        } // if end

        return mav;
    } // createProc() end

    @RequestMapping(value = "/mediagroup/list.do")
    public ModelAndView list(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mediagroup/list.do");
        int totalRowCount = dao.totalRowCount();
        int numPerPage = 5;
        int pagePerBlock = 10;
        String pageNum = req.getParameter("pageNum");
        if (pageNum == null) {
            pageNum = "1";
        }

        int startRow = ((Integer.parseInt(pageNum) - 1) * numPerPage) + 1;
        int endRow = Integer.parseInt(pageNum) * numPerPage;
        //페이지수
        double totcnt = (double) totalRowCount / numPerPage;
        int totalpage = (int) Math.ceil(totcnt);


        List list = null;
        if (totalRowCount > 0) {
            list = dao.paging(startRow, endRow);
        } else {
            list = Collections.emptyList();
        }
        mav.addObject("count", totalRowCount);
        mav.addObject("list", list);
        mav.addObject("totalpage", totalpage);
        mav.addObject("pageNum", pageNum);
        mav.addObject("statPage", startPage);

        return mav;
    }


//    @RequestMapping(value = "mediagroup/list.do", method = RequestMethod.GET)
//    public ModelAndView list() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("mediagroup/list");
//        List<MediagroupDTO> list = dao.list();
//        mav.addObject("list", list);
//        mav.addObject("count", dao.totalRowCount());
//        return mav;
//    }//end of list


} // class end
