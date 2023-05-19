package ru.itmo.coursePaper.coursePaper_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paragraph {
    public String name = "";
    public String text = "";
    public Paragraph answer_1;
    public Paragraph answer_2;

    public Paragraph(String name, String text, Paragraph answer_1, Paragraph answer_2) {
        this.name = name;
        this.text = text;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;

    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Paragraph getAnswer_1() {
        return answer_1;
    }

    public Paragraph getAnswer_2() {
        return answer_2;
    }
}