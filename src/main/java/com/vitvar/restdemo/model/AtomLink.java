package com.vitvar.restdemo.model;

import com.fasterxml.jackson.annotation.JsonView;

public class AtomLink {

    @JsonView()
    private String rel;

    @JsonView()
    private String href;

    public AtomLink(String rel, String href) {
        this.rel=rel;
        this.href=href;
    }

    public String href() {
        return this.href;
    }
}
