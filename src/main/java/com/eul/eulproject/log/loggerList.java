package com.eul.eulproject.log;

import java.util.LinkedList;
import java.util.List;

public class loggerList {

    private static loggerList loggerList = new loggerList();
    private static List<loggerMessage> data = new LinkedList<>();

    private loggerList() {
    }

    static loggerList getInstance() {
        return loggerList;
    }

    /**
     * 消息入队
     */
    void push(loggerMessage log) {
        data.add(log);//队列满了就抛出异常，不阻塞
    }

    /**
     * 消息出队
     */
    public List<loggerMessage> getData() {
        return data;
    }

}
