package kr.co.itwill.di;

public class HelloPOJO2 {
    public static void main(String[] args) {
        IHello hello= null;
        hello=new MessageKO2();
        hello.sayHello("박지성");

        hello=new MessageEN2();
        hello.sayHello("John");

    }
} //end of HelloPOJO2 class
