package kr.co.itwill.ajaxtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class AjaxtestCont {

    public AjaxtestCont() {
        System.out.println("----AjaxtestCont() Start----");
    }

    @RequestMapping("ajaxtest01.do")
    public String ajaxtest01() {
        return "ajax/ajaxTest01";
    }

    @RequestMapping("ajaxtest02.do")
    public String ajaxtest02() {
        return "ajax/ajaxTest02";
    }

    /*

     1)
    @RequestMapping(value = "message.do", method = RequestMethod.GET)
    public void message(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/plain; charset=UTF-8");

            //요청한 사용자에게 응답하기 위한 출력 객체
            //printwriter
            PrintWriter out = response.getWriter();
            out.println("서버에서 응답해준 메시지 : ");
            out.println("무궁화 꽃이 피었습니다.");
            out.flush(); //out 객체에 남아 있는 버퍼의 내용을 클리어
            out.close();

        } catch (Exception e) {
            System.out.println("Response failed" + e);
        }//end of try-catch
         }//end of message
        */

    //2)@ResponseBody를 활용한 메시지 전송
    //-> jsp view 를 이용하여 출력하지 않고 response 객체에 직접 출력한다.
    //-> return값 그대로 브라우저에 전송
    @RequestMapping(value = "message.do", method = RequestMethod.GET)
    @ResponseBody
    public String message(HttpServletRequest request, HttpServletResponse response) {
        return "Server message : Sucess";
    }//end of message

} //end of AjaxtestCont class
