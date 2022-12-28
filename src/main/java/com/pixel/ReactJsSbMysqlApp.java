package com.pixel;

import com.pixel.model.User;
import com.pixel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor
@Log4j2
public class ReactJsSbMysqlApp {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReactJsSbMysqlApp.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void go() {
		userRepository.deleteAll();
		var userFlux = Flux.range(1,5)
						.map(i -> new User(i, "User " + i, "Address " + i, i, new Random().nextInt(100)));
		userFlux.subscribe(log::info);
		//userRepository.saveAll(userFlux);
	}
	public List<User> loadEmployeeFromDB() {
		return IntStream.rangeClosed(1,10)
				.mapToObj(i -> new User(i, "User " + i, "Address " + i, i, new Random().nextInt(100)))
				.collect(Collectors.toList());
	}
}
