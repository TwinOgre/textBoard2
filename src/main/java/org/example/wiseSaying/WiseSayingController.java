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

        int id = _getIntParam(request.getParams("id"));

        WiseSaying ws = _getFindById(id);

        wiseSayingList.remove(ws);

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    private int _getIntParam(String id){
        int defaultValue = -1;
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("id는 정수만 입력이 가능합니다.");
            return defaultValue;
        }
    }
    private WiseSaying _getFindById(int id){
        for(int i = 0; i < wiseSayingList.size();i++){
            if(wiseSayingList.get(i).getId() == id){
                return  wiseSayingList.get(i);
            }
        }
        return null;
    }
}
