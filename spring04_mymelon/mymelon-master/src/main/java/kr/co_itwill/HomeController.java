package kr.co_itwill;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    public HomeController(){
        System.out.println("--------HomeController Start-----------");
    }

    @RequestMapping("/home.do")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        //redirect : 등록한 명령어를 호출 할 수 있다.
        mav.setViewName("redirect:/mediagroup/list.do");
        return mav;
    }//end of home

}//end of class
