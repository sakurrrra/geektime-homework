package geektime.spring.springbucks.service;

import geektime.spring.springbucks.model.Coffee;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-19 18:13
 */
@WebService(
        //暴露服务名称
        name = "CoffeeService",
        //wsdl命名空间,一般是接口(interface)的包名倒序
        targetNamespace = "service.springbucks.spring.geektime"
)
public interface CoffeeServiceI {

    @WebMethod
    List<Coffee> getList();

    @WebMethod
    Coffee getCoffeeByName(@WebParam(name = "name")String name);
}
