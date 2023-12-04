package org.example.wiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;
    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int lastId = 1;
    public WiseSayingController(Scanner sc){
        this.sc = sc;
    }
    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying ws =new WiseSaying(lastId,content,author);

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
        for(WiseSaying ws : wiseSayingList){
            System.out.println(ws.getId()+ " / " +ws.getAuthor() + " / " + ws.getContent());
        }
    }
}
