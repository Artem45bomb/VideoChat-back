package org.containercraft.videochatback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class VideoChatBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoChatBackApplication.class, args);
	}

}
