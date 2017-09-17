package edu.msudenver.cs3250.group6.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// the purpose here is to get a mapping to the index.html in templates
// from: https://spring.io/blog/2016/11/21/the-joy-of-mustache-server-side-templates-for-the-jvm
// TODO: make it work for 
@Controller
class HomeController {
  @GetMapping("/")
  String home() {
    return "index";
  }
}