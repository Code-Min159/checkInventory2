package com.workExample.checkInventory.controller;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class LineMessageController {

    static final Logger logger = LoggerFactory.getLogger(LineMessageController.class);

    @PostMapping("back")
    public void back(@RequestBody String message) {
//        logger.info(message);
        System.out.println("Received message: " + message);
    }

}
