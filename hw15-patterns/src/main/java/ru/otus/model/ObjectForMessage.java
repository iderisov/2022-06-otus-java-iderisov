package ru.otus.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectForMessage {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    protected ObjectForMessage copy() {
        ObjectForMessage obj = new ObjectForMessage();
        obj.setData(new ArrayList<>(data));
        return obj;
    }
}
