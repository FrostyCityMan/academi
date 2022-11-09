package kr.co.itwill.member;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member")
public class MemberCont {
    public MemberCont() {
        System.out.println("Member Cont 생성");
    }

    //아이디 중복확인 페이지 불러오기

    //idCheckForm for String
    @RequestMapping("idcheckform.do")
    public String idCheckForm() {
        return "member/idCheck";
    }

    @RequestMapping("idcheckproc.do")
    @ResponseBody
    public String idCheckProc(HttpServletRequest request, HttpServletResponse response) {
        String userid = request.getParameter("userid");
        //message
        String message = "";
        //if usrid <5 or usrid>15
        if (userid.length() < 5 || userid.length() > 15) {
            //message= span, blue color, bold
            message = "<span style='color:red;font-weight:bold;'>아이디는 5~15글자 이내 입력해주세요</span>";

        } else {
            if (userid.equals("itwill") || userid.equals("webmaster")) {
                //message= span, red color, bold
                message = "<span style='color:red;font-weight:bold;'>중복된 아이디 입니다.</span>";
            } else {
                //message= span, green color, bold
                message = "<span style='color:green;font-weight:bold;'>사용 가능한 아이디 입니다.</span>";
            }//end of if
        }//end of if
        return message;
    }

    //리퀘스트매핑 idcheckcookieform.do
    @RequestMapping("idcheckcookieform.do")
    public String idCheckCookieForm() {
        return "member/idCheck_cookie";
    }

    @RequestMapping("idcheckcookieproc.do")
    @ResponseBody
    public String idCheckCookieProc(HttpServletRequest req) {
        String userid = req.getParameter("userid");

        String cnt = "0";

        if (userid.equals("itwill") || userid.equals("webmaster")) {
            cnt = "1"; // 아이디가 중복되었음
        } //  if end

        // 1) text 응답 ===========================================================
        //  return cnt;

        // 2) json 응답 ===========================================================

        JSONObject json = new JSONObject();
        json.put("count", cnt);
        return json.toString();

    } // idCheckCookieProc() end

    //리퀘스트 매핑 insert.do method post
    @RequestMapping(value = "insert.do", method = RequestMethod.POST)
    public void insert(HttpServletRequest req) {
        System.out.println("ID: " + req.getParameter("userid"));
        //print password
        System.out.println("Password: " + req.getParameter("passwd"));
        //print name
        System.out.println("Name: " + req.getParameter("name"));
        //print email
        System.out.println("Email: " + req.getParameter("email"));


    }
} //end of MemberCont class
