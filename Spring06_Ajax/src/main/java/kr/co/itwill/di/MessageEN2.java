package kr.co.itwill.di;

import javax.swing.*;

public class MessageEN2 implements IHello{
    public MessageEN2(){
        System.out.println("MessageEN2 constructor");
    }

    @Override
    public void sayHello(String name){
       JOptionPane.showMessageDialog(null, "Hello "+name);
    }
} //end of class
