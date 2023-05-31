package io.spring.test.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value="", method = RequestMethod.GET)
    public HashMap<String, Object> getAll() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        log.info("test");
        map.put("Result", "test");
        return map;
    }
}
