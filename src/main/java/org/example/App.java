package org.example;

import org.example.system.SystemController;
import org.example.wiseSaying.WiseSaying;
import org.example.wiseSaying.WiseSayingController;

import java.util.*;

public class App {

    SystemController systemController;
    WiseSayingController wiseSayingController;


    App() {

        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController();
    }

    void run() {
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();
        System.out.println("실행됨");


        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);

            switch (request.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(request);
                    break;
            }
        }
    }
}

