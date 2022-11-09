package kr.co.itwill.book;

//Controller

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

} //end of BookCont class
