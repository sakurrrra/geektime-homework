package geektime.spring.springbucks.config;

import geektime.spring.springbucks.service.CoffeeService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-19 18:18
 */
@Configuration
public class CxfWebServiceConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private CoffeeService coffeeService;

    /**
     * 发布endpoint
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, coffeeService);
        //发布地址
        endpoint.publish("/CoffeeService");
        return endpoint;
    }

}