package io.mglobe.africa.caching

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@SpringBootApplication
@ComponentScan(basePackages = ["io.mglobe.africa.caching"])
@EnableCaching
@Component
@EnableConfigurationProperties
@Configuration
open class Application {
	companion object {
		@Throws(Exception::class)
		@JvmStatic
		fun main(args: Array<String>) {
			val LOGGER: org.slf4j.Logger? = LoggerFactory.getLogger(Application::class.java)
			LOGGER?.info("===================================== STARTING ====================================")
			runApplication<Application>(*args)
			LOGGER?.info("===================================================================================")
			LOGGER?.info("====================== REDIS CACHING DEMO APP ======================")
			LOGGER?.info("===================================================================================")
			LOGGER?.info("===================================== STARTED =====================================")
		}
	}
}