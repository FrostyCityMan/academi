package kr.co_itwill.mediagroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MediagroupCont {
    @Autowired
    private MediagroupDAO dao;

    public MediagroupCont() {
        System.out.println("-----------Mediagroup start ----------------");
    }

    //미디어 그룹 쓰기 페이지 호출
    //https://localhost:9095/mediagroup/create.do
    @RequestMapping(value = "/mediagroup/create.do", method = RequestMethod.GET)
    public String createForm() {
        return "mediagroup/createForm";
    }//end of createForm

    @RequestMapping(value = "/mediagroup/create.do", method = RequestMethod.POST)
    public ModelAndView createProc(@ModelAttribute MediagroupDTO dto) {
        ModelAndView mav = new ModelAndView();


        int cnt = dao.create(dto);
        if (cnt == 0) {
            mav.setViewName("mediagroup/msgView");
            String msg1 = "<P>미디어 그룹 등록 실패</P>";
            String img = "<img src='../images/fail.png'>";
            String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2 = "<input type='button' value='그룹목록' onclick='loaction.href=\"list.do\"'>";
            mav.addObject("msg1", msg1);
            mav.addObject("img", img);
            mav.addObject("link1", link1);
            mav.addObject("link2", link2);
        } else {
            mav.setViewName("redirect:/mediagroup/list.do");
        }


        return mav;

    }
}//end of class


