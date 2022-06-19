package geektime.spring.springbucks.mapper;

import geektime.spring.springbucks.model.Coffee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xierl
 * @Email ronglong.xie@pactera.com
 * date 2022-06-04 17:06
 */
@Mapper
public interface CoffeeMapper {

    @Select("SELECT * FROM T_COFFEE")
    List<Coffee> getList();

    @Select("SELECT * FROM T_COFFEE WHERE NAME = #{name}")
    Coffee getCoffeeByName(@Param("name") String name);


    @Insert("insert into t_coffee (id, name, price, create_time, update_time) values (#{dto.id}, #{dto.name}, #{dto.price}, now(), now())")
    int insert(@Param("dto") Coffee coffee);

    @Update("update t_coffee set name=#{dto.name}, price=#{dto.price}, update_time=now() where id = #{dto.id}")
    int updateById(@Param("dto") Coffee coffee);

    @Delete("delete from t_coffee where id = #{id}")
    int deleteById(@Param("id") Long coffeeId);

    @Delete("delete from t_coffee where name = #{name}")
    int deleteByName(@Param("name") String name);
}
