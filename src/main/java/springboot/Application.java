package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"controller","config","interceptor", "deal", "entity"})
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		System.out.println("初始化完成！");
		
	}

}
