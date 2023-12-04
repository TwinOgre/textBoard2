package org.example.wiseSaying;

public class WiseSaying {
    private int id;
    private String content;
    private String author;

    public WiseSaying (int id, String content, String  author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }
}
