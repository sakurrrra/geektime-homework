package geektime.spring.springbucks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("geektime.spring.**.mapper")
@ImportResource(locations={"classpath:applicationContext.xml"})
public class SpringbucksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbucksApplication.class, args);
    }

}
