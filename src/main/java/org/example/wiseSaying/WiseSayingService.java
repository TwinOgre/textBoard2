package org.example.wiseSaying;

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
}
