package org.example.wiseSaying;

import org.example.Container;
import org.example.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int lastId = 1;

    public WiseSayingController() {

    }

    public void write() {
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine().trim();

        WiseSaying ws = new WiseSaying(lastId, content, author);

        wiseSayingList.add(ws);

        System.out.println(lastId + "번 명언이 등록 되었습니다.");
        lastId++;
    }

    public void list() {
        System.out.println("번호/ 작가 /명언");
        System.out.println("-------------------");
//                for(int i = 0; i < wiseSayingList.size(); i++){
//                    WiseSaying ws =wiseSayingList.get(i);
//                    System.out.println(ws.getId()+ " / " +ws.getAuthor() + " / " + ws.getContent());
//                }
        for (WiseSaying ws : wiseSayingList) {
            System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent());
        }
    }

    public void delete(Request request) {
        int id = -1;

        try {
            id = Integer.parseInt(request.getParams("id"));
        } catch (NumberFormatException e) {
            System.out.println("id는 정수만 입력이 가능합니다.");
            return;
        }


        System.out.println(id + "번 명언이 삭제되었습니다.");
    }
}
