package kr.co_itwill.test01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CalcController {
    public CalcController() {
        System.out.println("---------Clac객체 생성됨");
    }//end

//@RequestMapping(value ="", method = GET|POST){
//
//    }

    //    http://localhost:9095/add.do?no1=3&no2=5
    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest req) {
        int no1 = Integer.parseInt(req.getParameter("no1"));
        int no2 = Integer.parseInt(req.getParameter("no2"));
        int result = no1 + no2;

        ModelAndView mv = new ModelAndView();
        mv.setViewName("calcResult");
        req.setAttribute("no1", no1);
        req.setAttribute("no2", no2);
        req.setAttribute("result", result);
        req.setAttribute("message", "<h3>두수 사이의 합</h3>");

        return mv;


    }

    //    http://localhost:9095/sub.do?no1=5&no2=2
    @RequestMapping(value = "/sub.do", method = RequestMethod.GET)
    public ModelAndView sub(HttpServletRequest req) {
        int no1 = Integer.parseInt(req.getParameter("no1"));
        int no2 = Integer.parseInt(req.getParameter("no2"));
        int result = no1 - no2;

        ModelAndView mv = new ModelAndView();
        mv.setViewName("calcResult");
        req.setAttribute("no1", no1);
        req.setAttribute("no2", no2);
        req.setAttribute("result", result);
        req.setAttribute("message", "<h3>두수 사이의 합</h3>");

        return mv;
    }
}



