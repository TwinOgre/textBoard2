package org.example;

import org.example.system.SystemController;
import org.example.wiseSaying.WiseSaying;
import org.example.wiseSaying.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    SystemController systemController;
    WiseSayingController wiseSayingController;



    App(Scanner sc) {
        this.sc = sc;
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController(sc);
    }

    void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        System.out.println("실행됨");


        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")){
                wiseSayingController.write();

            } else if(command.equals("목록")){
                wiseSayingController.list();
            }
        }
    }
}
