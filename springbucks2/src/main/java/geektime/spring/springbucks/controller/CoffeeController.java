package geektime.spring.springbucks.controller;

import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.service.CoffeeService;
import geektime.spring.springbucks.service.CoffeeServiceI;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-19 16:14
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> getList() {
        return coffeeService.getList();
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee getCoffeeByName(@PathVariable String name) {
        return coffeeService.getCoffeeByName(name);
    }

    @GetMapping(value = "/name-xml/{name}")
    public Coffee getCoffeeByNameWithXml(@PathVariable String name) {
        return coffeeService.getCoffeeByName(name);
    }

    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(CoffeeServiceI.class);
        factory.setAddress("http://localhost:8080/ws/CoffeeService?wsdl");
        CoffeeServiceI client = (CoffeeServiceI) factory.create();
        System.out.println(client.getCoffeeByName("espresso"));
    }
}
