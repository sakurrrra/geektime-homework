package geektime.spring.springbucks.service;

import geektime.spring.springbucks.mapper.CoffeeMapper;
import geektime.spring.springbucks.mapper.CoffeeOrderMapper;
import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.model.CoffeeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-19 16:14
 */
//@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderMapper coffeeOrderMapper;

    private CoffeeService coffeeService;

    public void setCoffeeService(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    public List<CoffeeOrder> getList() {
        return coffeeOrderMapper.getList();
    }

    public Coffee getCoffeeByName(String name) {
        return coffeeService.getCoffeeByName(name);
    }
}
