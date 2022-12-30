package com.pixel;

import com.pixel.model.User;
import com.pixel.repository.UserRepository;
import com.pixel.runasyncdemo.RunAsyncDemo;
import com.pixel.service.EmployeeRemainderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Flux;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor
@Log4j2
public class ReactJsSbMysqlApp {

	private final UserRepository userRepository;
	private final RunAsyncDemo runAsyncDemo;
	private final EmployeeRemainderService employeeRemainderService;

	public static void main(String[] args) {
		SpringApplication.run(ReactJsSbMysqlApp.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void go() throws ExecutionException, InterruptedException {
//		userRepository.deleteAll();
//		var userFlux = Flux.range(1,5)
//						.map(i -> new User(i, "User " + i, "Address " + i, i, new Random().nextInt(100)));
//		userFlux.subscribe(log::info);
//		//userRepository.saveAll(userFlux);public
		//runAsyncDemo.saveEmployees(new File("empData.json"));
		//employeeRemainderService.sendRemainderToEmployee().get();
	}
	public List<User> loadEmployeeFromDB() {
		return IntStream.rangeClosed(1,10)
				.mapToObj(i -> new User(i, "User " + i, "Address " + i, i, new Random().nextInt(100)))
				.collect(Collectors.toList());
	}
}
