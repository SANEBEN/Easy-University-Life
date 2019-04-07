package com.eul.eulproject.service;

import java.util.List;

public interface subscribeService {

    boolean add(int author ,int customer);

    List<String> get(int author);
}
