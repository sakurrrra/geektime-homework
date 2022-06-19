package geektime.spring.springbucks.service;

import geektime.spring.springbucks.mapper.CoffeeMapper;
import geektime.spring.springbucks.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-19 16:14
 */
@WebService(
        //该WebService服务的名称,与接口中指定的name一致,对外发布的服务名
        serviceName = "CoffeeService",
        //wsdl命名空间,通常使用接口包名反转
        targetNamespace = "service.springbucks.spring.geektime",
        //服务接口全路径
        endpointInterface = "geektime.spring.springbucks.service.CoffeeServiceI")
@Service
public class CoffeeService {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public List<Coffee> getList() {
        return coffeeMapper.getList();
    }

    public Coffee getCoffeeByName(String name) {
        return coffeeMapper.getCoffeeByName(name);
    }
}
