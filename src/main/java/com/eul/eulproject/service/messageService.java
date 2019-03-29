package com.eul.eulproject.service;

import com.eul.eulproject.entity.information.message;
import com.eul.eulproject.entity.information.messageSimple;

public interface messageService {
    message getMessage(String Uid);

    messageSimple getSimpleMessage(String Uid);
}
