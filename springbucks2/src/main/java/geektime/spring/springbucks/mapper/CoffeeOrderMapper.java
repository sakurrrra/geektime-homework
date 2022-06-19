package geektime.spring.springbucks.mapper;

import geektime.spring.springbucks.model.CoffeeOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-04 17:06
 */
@Mapper
public interface CoffeeOrderMapper {

    @Select("SELECT * FROM T_ORDER")
    List<CoffeeOrder> getList();
}
