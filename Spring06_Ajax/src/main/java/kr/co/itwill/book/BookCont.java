package kr.co.itwill.book;

//Controller

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class BookCont {

    //public BookCont
    public BookCont() {
        //print name
        System.out.println("I am Book Cont");
    }

    @RequestMapping("book/book.do")
    public String bookTest() {
        return "book/bookTest";
    }// end of book

    @RequestMapping("book/booksend.do")
    @ResponseBody
    public String bookSend(HttpServletRequest request) {
        int bookIndex = Integer.parseInt(request.getParameter("book"));
        String img[] = {"spring.jpg", "android.jpg", "jquery.jpg", "jsmasterbook.jpg"};
        return img[bookIndex];//응답메시지
    }

    @RequestMapping("book/searchform.do")
    public String bookSearch() {
        return "book/searchTest";

    }//end of bookSearch

    @RequestMapping("book/searchproc.do")
    @ResponseBody
    //searchProc
    public String searchProc(HttpServletRequest request) {
        String keyword = request.getParameter("keyword");
        String message = "";
        //if keyword is not null

        if (keyword != null) {
            // "%자바%" 반환
            ArrayList<String> result = search(keyword);
            // message = result.toString();
            //응답메시지 -> 갯수|찾은 문자열, 찾은문자열 ~~
            //          예)2|문자열~~

            int size = result.size();
            if (size > 0) {
                message = size + "| ";
                for (int i = 0; i < size; i++) {
                    String title = result.get(i);
                    message += title;
                    if (i < size - 1) {
                        message += ", ";
                    }
                }//end of for
            } else {
                message = "";
            }//end of if size
        }//end of if keyword
        return message;
    }

    public ArrayList<String> search(String keyword) {
        //검색하고자 하는 문자열 목록
        // where title like '%자바%'
        String[] keywords = {"Ajax", "Ajax 실전 프로그래밍", "자바",
                "웹프로그래밍", "웹마스터", "자바 프로그래밍",
                "자전거", "자라", "JSP 프로그래밍",
                "자바 안드로이드", "안자바가요"};
        //keyword를 keywords배열에서 첫글자부터 비교해서 ArrayList에 저장
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < keywords.length; i++) {
            keywords[i] = keywords[i].toUpperCase();
            keyword = keyword.toUpperCase();
            if (keyword == "") {
                break;
            } else {
                if (keywords[i].contains(keyword)) {
                    result.add(keywords[i]);
                }
            }
        }
        return result;
    }//end of ArrayList

} //end of BookCont class
