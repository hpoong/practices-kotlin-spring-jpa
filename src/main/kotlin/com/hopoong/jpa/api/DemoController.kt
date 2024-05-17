package com.hopoong.jpa.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity

@RestController
class DemoController {

    @GetMapping("/demo")
    fun demo(): String {
        return "demo-test"
    }
}