package com.example.rmontoya.multiviewlist.model;

import com.example.rmontoya.multiviewlist.model.typeinterface.ListElement;

public class ContentRow implements ListElement {

    private String content;

    public ContentRow(String content) {
        this.content = content;
    }

    @Override
    public String exposeValue() {
        return content;
    }

}
