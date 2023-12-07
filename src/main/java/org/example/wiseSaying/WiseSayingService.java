package org.example.wiseSaying;

import org.example.Request;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int lastId = 1;


    public int write(String content, String author) {
        WiseSaying ws = new WiseSaying(lastId, content, author);

        wiseSayingList.add(ws);

        lastId++;
        return ws.getId();
    }
    public List<WiseSaying> findByAll(){
        return wiseSayingList;
    }
    public int delete(Request request){
        int id = _getIntParam(request.getParams("id"));

        WiseSaying ws = _getFindById(id);

        if (ws == null) {
            if(id == -1 ){
                return id;
            }else {
                
                return -id;
            }

        }
        wiseSayingList.remove(ws);
        return ws.getId();
    }
    public WiseSaying modifyWiseSaying (Request request){
        int id = _getIntParam(request.getParams("id"));

        if(id == -1 ){
            return null;
        }

        WiseSaying ws = _getFindById(id);

        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return null;
        }
        
        return ws;
        

    }
    public void modify(WiseSaying ws, String content, String author){
        ws.setContent(content);
        ws.setAuthor(author);
        
    }
    
    private int _getIntParam(String id) {
        int defaultValue = -1;
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("id는 정수만 입력이 가능합니다.");
            return defaultValue;
        }
    }

    public WiseSaying _getFindById(int id) {
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == id) {
                return wiseSayingList.get(i);
            }
        }
        return null;
    }
}
