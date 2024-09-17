package com.yield.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YieldApplication

fun main(args: Array<String>) {
	runApplication<YieldApplication>(*args)
}
