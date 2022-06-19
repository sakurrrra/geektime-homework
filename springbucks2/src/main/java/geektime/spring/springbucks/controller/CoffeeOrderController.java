package geektime.spring.springbucks.controller;

import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.model.CoffeeOrder;
import geektime.spring.springbucks.service.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-19 16:14
 */
@RestController
@RequestMapping("/coffeeOrder")
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @RequestMapping(value = "/list", produces = MediaType.APPLICATION_XML_VALUE)
    public List<CoffeeOrder> getList() {
        return coffeeOrderService.getList();
    }

    @GetMapping(value = "/getCoffeeByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee getCoffeeByName(String name) {
        return coffeeOrderService.getCoffeeByName(name);
    }
}
