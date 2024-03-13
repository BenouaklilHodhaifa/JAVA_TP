package com.example.tp_javafx;

import java.io.Serializable;

public class Def implements Serializable {
    private String Definition;
    private String rep;

    public Def(String definition, String rep) {
        Definition = definition;
        this.rep = rep;
    }

    public String getDefinition() {
        return Definition;
    }

    public String getRep() {
        return rep;
    }
}
