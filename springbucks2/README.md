# 作业2

> 作业题目如下：(大家可根据自身基础情况选择难度合适的作业作答提交)

* 1.写代码实现 Spring Bean的装配，方式越多越好（XML、Annotation 都可以）【简单】
* 2.通过springmvc实现两个restful查询数据接口：第一个返回json数据格式，第二个返回xml数据格式（可通过改造第一次作业的springbuck项目实现）【正常】
* 3.新建一个Springboot项目，通过远程调用方式访问作业2提供的web接口，访问方式越多越好。【较难】



### 第一题

>  xml配置bean

![image-20220619174825596](D:\github\geektime-homework\images\image-20220619174825596.png)

![image-20220619174825596](C:\Users\13936\AppData\Roaming\Typora\typora-user-images\image-20220619174825596.png

![image-20220619174855632](D:\github\geektime-homework\images\image-20220619174855632.png)

> Annotation配置bean

![image-20220619174957919](D:\github\geektime-homework\images\image-20220619174957919.png)

### 第二题

> 返回json数据

http://localhost:8080/coffee/list

![image-20220619175201412](D:\github\geektime-homework\images\image-20220619175201412.png)

http://localhost:8080/coffee/name/espresso

![image-20220619175212786](D:\github\geektime-homework\images\image-20220619175212786.png)

> 返回xml数据

http://localhost:8080/coffee/name-xml/espresso

![image-20220619175227217](D:\github\geektime-homework\images\image-20220619175227217.png)

### 第三题

> http调用

http://localhost:8080/coffee/list

![image-20220619175201412](D:\github\geektime-homework\images\image-20220619175201412.png)

> webservice调用

```sql
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(CoffeeServiceI.class);
        factory.setAddress("http://localhost:8080/ws/CoffeeService?wsdl");
        CoffeeServiceI client = (CoffeeServiceI) factory.create();
        System.out.println(client.getCoffeeByName("espresso"));
    }
```

![image-20220619183227756](D:\github\geektime-homework\images\image-20220619183227756.png)

![image-20220619183356520](D:\github\geektime-homework\images\image-20220619183356520.png)

