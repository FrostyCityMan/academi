package kr.co.itwill.di;

public class MessageKO1 implements IHello {
    public MessageKO1(){
        System.out.println("----MessageKO1 생성됨");
    }//end of MessageKO1

    @Override
    public void sayHello(String name){
        System.out.println("안녕하세요 "+name);
        }//end of sayhello
}//end of class
