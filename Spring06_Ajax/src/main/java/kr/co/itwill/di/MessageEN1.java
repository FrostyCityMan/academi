package kr.co.itwill.di;

public class MessageEN1 implements IHello {
    public MessageEN1(){
        System.out.println("----------MessageEN1() 객체 생성");
    }//end

    // override sayhello
    @Override
    public void sayHello(String name) {
        System.out.println("hello "+name);
    }//end of sayhello
}//end of class
