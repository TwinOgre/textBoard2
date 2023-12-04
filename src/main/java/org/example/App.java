package org.example;

import java.util.Scanner;

public class App {
    Scanner sc;
    App(Scanner sc){
        this.sc = sc;
    }
    void run(){
        System.out.println("실행됨");
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();
            if(command.equals("종료")){
                break;
            }
        }
    }
}
