package com.tz.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author hu jing ling
 * @since 2016-03-18
 */
@RestController
class HelloController {

    HelloController() {
        println 'HelloController...'
    }

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    def resource(){
        return [id:UUID.randomUUID().toString(), content:'Hello World']
    }

}
