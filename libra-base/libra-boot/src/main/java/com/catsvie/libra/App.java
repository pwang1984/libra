package com.catsvie.libra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.catsvie.libra.log.NoLogging;

/**
 * 
 * @author Peng Wang <br/>
 *         Feb 9, 2016
 * @version 1.0 <br/>
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App {
	@NoLogging
	public static void main(String[] args) {
		//		@SuppressWarnings("resource")
		//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//		ctx.register(LogModuleConfig.class);
		//		ctx.register(DatabaseConfig.class);
		//		ctx.register(JacksonModuleConfig.class);
		//		ctx.register(MenuModuleConfig.class);

		SpringApplication.run(App.class, args);
	}
}
