package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;

    App(Scanner sc) {
        this.sc = sc;
    }

    void run() {
        System.out.println("실행됨");
        List<WiseSaying> wiseSayingList = new ArrayList<>();
        int lastId = 1;
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")){
                System.out.print("명언 : ");
                String content = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                WiseSaying ws =new WiseSaying(lastId,content,author);

                wiseSayingList.add(ws);

                System.out.println(lastId + "번 명언이 등록 되었습니다.");
                lastId++;

            } else if(command.equals("목록")){
                System.out.println("번호/ 작가 /명언");
                System.out.println("-------------------");
//                for(int i = 0; i < wiseSayingList.size(); i++){
//                    WiseSaying ws =wiseSayingList.get(i);
//                    System.out.println(ws.getId()+ " / " +ws.getAuthor() + " / " + ws.getContent());
//                }
                for(WiseSaying ws : wiseSayingList){
                    System.out.println(ws.getId()+ " / " +ws.getAuthor() + " / " + ws.getContent());
                }
            }
        }
    }
}
