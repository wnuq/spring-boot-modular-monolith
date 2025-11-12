package com.wnuq.spring.boot.modular.monolith

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootModularMonolithApplication

fun main(args: Array<String>) {
	runApplication<SpringBootModularMonolithApplication>(*args)
}
