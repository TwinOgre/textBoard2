package org.example.wiseSaying;

import org.example.Container;
import org.example.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
        WiseSayingService wiseSayingService;

    public WiseSayingController() {
        wiseSayingService = new WiseSayingService();
    }

    public void write() {
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine().trim();

        int id = wiseSayingService.write(content,author);


        System.out.println(id + "번 명언이 등록 되었습니다.");

    }

    public void list() {
        System.out.println("번호/ 작가 /명언");
        System.out.println("-------------------");
//                for(int i = 0; i < wiseSayingList.size(); i++){
//                    WiseSaying ws =wiseSayingList.get(i);
//                    System.out.println(ws.getId()+ " / " +ws.getAuthor() + " / " + ws.getContent());
//                }
//        List<WiseSaying> wiseSayingList = this.wiseSayingService.findByAll();

        for (WiseSaying ws : wiseSayingService.findByAll()) {
            System.out.println(ws.getId() + " / " + ws.getAuthor() + " / " + ws.getContent());
        }
    }

    public void delete(Request request) {

        int id = wiseSayingService.delete(request);

        if(id == -1){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }


        System.out.println(id + "번 명언이 삭제되었습니다.");
    }



    public void modify(Request request) {

        WiseSaying ws = wiseSayingService.modifyWiseSaying(request);

        System.out.println("기존명언: " + ws.getContent());
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine();

        System.out.println("기존작가: " + ws.getAuthor());
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine();

        this.wiseSayingService.modify(ws,content,author);

        System.out.println(ws.getId() + "번 명언이 수정되었습니다.");
    }

}
