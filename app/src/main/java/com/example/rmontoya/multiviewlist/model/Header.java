package com.example.rmontoya.multiviewlist.model;

import com.example.rmontoya.multiviewlist.model.typeinterface.ListElement;

public class Header implements ListElement {

    private String headerText;

    public Header(String headerText) {
        this.headerText = headerText;
    }

    @Override
    public String exposeValue() {
        return headerText;
    }
}
