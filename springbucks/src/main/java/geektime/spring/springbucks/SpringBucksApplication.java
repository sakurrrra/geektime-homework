package geektime.spring.springbucks;

import com.github.pagehelper.PageHelper;
import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Cacheable;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication
//@EnableJpaRepositories
@MapperScan("geektime.spring.**.mapper")
@EnableCaching
public class SpringBucksApplication implements ApplicationRunner {
	@Autowired
	private CoffeeService coffeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBucksApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		coffeeService.getList();

		Coffee latte = coffeeService.getCoffeeByName("latte");
		Coffee coffee = new Coffee();
		coffee.setName("new Coffee");
		coffee.setPrice(3500);
//		coffee.setPrice(Money.of(CurrencyUnit.of("CNY"), 35));
		coffeeService.insert(coffee);

		// 取更新前的数据，存入缓存
		log.info("get Coffee from Cache: {}", coffeeService.getCoffeeByNameFromCache("latte"));
		latte.setPrice(1231231);
		// 更新数据
		coffeeService.updateById(latte);
		// 更新后，取缓存数据
		log.info("get Coffee from Cache: {}", coffeeService.getCoffeeByNameFromCache("latte"));
		coffeeService.getCoffeeByName("latte");
		// 取数据库数据
		coffeeService.deleteByName(coffee.getName());

		try {
			// 事务
			log.info("insert by error Coffee: {}", coffeeService.insertByError(coffee));
		} catch (Exception e){

		} finally {
			log.info("All Coffee: {}", coffeeService.getList().size());
		}

		// 分页
		coffeeService.getPageList(2,4);
	}
}

