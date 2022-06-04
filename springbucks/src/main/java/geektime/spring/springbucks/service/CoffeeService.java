package geektime.spring.springbucks.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import geektime.spring.springbucks.mapper.CoffeeMapper;
import geektime.spring.springbucks.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.regex;

@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeMapper coffeeMapper;

    public List<Coffee> getList() {
        log.info("getList start============>");
        List<Coffee> result = coffeeMapper.getList();
        log.info("size: {}; All Coffee: {}", result.size(), result);
        log.info("getList end==============>");
        return result;
    }

    public List<Coffee> getPageList() {
        return getPageList(1, 10);
    }
    public List<Coffee> getPageList(Integer pageNum, Integer pageSize) {
        log.info("getPageList start==============>");
        PageHelper.startPage(pageNum, pageSize);
        List<Coffee> result = coffeeMapper.getList();
        PageInfo pageInfo = new PageInfo<>(result);
        log.info("total: {}; current page size: {}; All Coffee: {}", pageInfo.getTotal(), result.size(), result);
        log.info("getPageList end==============>");
        return result;
    }

    public Coffee getCoffeeByName(String name) {
        log.info("getCoffeeByName start============>");
        Coffee result = coffeeMapper.getCoffeeByName(name);
        log.info("get Coffee-{}: {}", name, result);
        log.info("getCoffeeByName end==============>");
        return result;
    }

    @Cacheable(cacheNames = "cnc", key="#name")
    public Coffee getCoffeeByNameFromCache(String name) {
        log.info("getCoffeeByNameFromCache start============>");
        Coffee result = coffeeMapper.getCoffeeByName(name);
        log.info("get Coffee-{}: {}", name, result);
        log.info("getCoffeeByNameFromCache end==============>");
        return result;
    }

    public int insert(Coffee coffee) {
        log.info("insert start============> beforeSize:{}", coffeeMapper.getList().size());
        int result = coffeeMapper.insert(coffee);
        log.info("insert Coffee: {}", result);
        log.info("insert end==============> endSize:{}", coffeeMapper.getList().size());
        return result;
    }

    public int updateById(Coffee coffee) {
        log.info("updateById start============> beforeSize:{}", coffeeMapper.getList().size());
        int result = coffeeMapper.updateById(coffee);
        log.info("update Coffee: {}", result);
        log.info("updated Coffee entity: {}", coffeeMapper.getCoffeeByName(coffee.getName()));
        log.info("updateById end==============> endSize:{}", coffeeMapper.getList().size());
        return result;
    }

    public int deleteById(Long coffeeId) {
        log.info("deleteById start============> beforeSize:{}", coffeeMapper.getList().size());
        int result = coffeeMapper.deleteById(coffeeId);
        log.info("deleteById Coffee: {}", result);
        log.info("deleteById end==============> endSize:{}", coffeeMapper.getList().size());
        return result;
    }

    public int deleteByName(String name) {
        log.info("deleteByName start============> beforeSize:{}", coffeeMapper.getList().size());
        int result = coffeeMapper.deleteByName(name);
        log.info("deleteByName Coffee: {}", result);
        log.info("deleteByName end==============> endSize:{}", coffeeMapper.getList().size());
        return result;
    }

    @Transactional
    public int insertByError(Coffee coffee){
        coffeeMapper.insert(coffee);
        return 1/0;
    }


}
