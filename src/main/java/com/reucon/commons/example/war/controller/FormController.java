package com.reucon.commons.example.war.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Part;

@Controller
@RequestMapping("/form")
public class FormController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String post(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/multipart", method = RequestMethod.POST)
    @ResponseBody
    public String postMultipart(@RequestParam("name") String name, @RequestParam("file") Part file) {
        return "Hello " + name + ", you uploaded '" + file.getSubmittedFileName() + "'";
    }
}
