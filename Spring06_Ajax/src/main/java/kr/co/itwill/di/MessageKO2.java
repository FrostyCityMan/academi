package kr.co.itwill.di;

import javax.swing.*;

public class MessageKO2 implements IHello {
    public MessageKO2() {
        System.out.println("MessageKO2 constructor");
    }

    @Override
    public void sayHello(String name) {
        JOptionPane.showMessageDialog(null, "안녕하세요 " + name);
    }
} //end of class
