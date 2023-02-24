# SSM
ssm框架的学习日志——但行好事，莫问前程
### mybatis

##### 核心配置(含注释)
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--
MyBatis核心配置文件中，标签的顺序：
properties?,settings?,typeAliases?,typeHandlers?,
objectFactory?,objectWrapperFactory?,reflectorFactory?,
plugins?,environments?,databaseIdProvider?,mappers?
-->
    <!--引入properties文件-->
    <properties resource="jdbc.properties" />
    <!--设置类型别名-->
    <typeAliases>
        <!--
typeAlias：设置某个类型的别名
属性：
type：设置需要设置别名的类型
alias：设置某个类型的别名，若不设置该属性，那么该类型拥有默认的别名，即类名
且不区分大小写
-->
        <!--<typeAlias type="com.atguigu.mybatis.pojo.User"></typeAlias>-->
        <!--以包为单位，将包下所有的类型设置默认的类型别名，即类名且不区分大小写-->
        <package name="com.atguigu.mybatis.pojo"/>
    </typeAliases>
    <!--
environments：配置多个连接数据库的环境
属性：
default：设置默认使用的环境的id
-->
    <environments default="development">
        <!--
environment：配置某个具体的环境
属性：
id：表示连接数据库的环境的唯一标识，不能重复
-->
        <environment id="development">
            <!--
transactionManager：设置事务管理方式
属性：
type="JDBC|MANAGED"
JDBC：表示当前环境中，执行SQL时，使用的是JDBC中原生的事务管理方式，事
务的提交或回滚需要手动处理
MANAGED：被管理，例如Spring
-->
            <transactionManager type="JDBC"/>
            <!--
dataSource：配置数据源
属性：
type：设置数据源的类型
type="POOLED|UNPOOLED|JNDI"
POOLED：表示使用数据库连接池缓存数据库连接
UNPOOLED：表示不使用数据库连接池
JNDI：表示使用上下文中的数据源
-->
            <dataSource type="POOLED">
                <!--设置连接数据库的驱动-->
                <property name="driver" value="${jdbc.driver}"/>
                <!--设置连接数据库的连接地址-->
                <property name="url" value="${jdbc.url}"/>
                <!--设置连接数据库的用户名-->
                <property name="username" value="${jdbc.username}"/>
                <!--设置连接数据库的密码-->
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url"
value="jdbc:mysql://localhost:3306/ssmserverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <!--引入映射文件-->
    <mappers>
        <!--<mapper resource="mappers/UserMapper.xml"/>-->
        <!--
        以包为单位引入映射文件
        要求：
        1、mapper接口所在的包要和映射文件所在的包一致
        2、mapper接口要和映射文件的名字一致
        -->
        <package name="com.atguigu.mybatis.mapper"/>
    </mappers>

```

#### log4j日志mybatis的配置

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS}
%m (%F:%L) \n" />
        </layout>
    </appender>
    <logger name="java.sql">
        <level value="debug" />
    </logger>
    <logger name="org.apache.ibatis">
        <level value="info" />
    </logger>
    <root>
        <level value="debug" />
        <appender-ref ref="STDOUT" />
    </root>
</log4j:configuration>
```


##### SqlsessionUtil工具类
```java
package zian.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import zian.example.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;

/**
* Created with IntelliJ IDEA.
*
* @Author: ljzhang
* @Date: 2023/02/22/20:45
* @Description:
*/
public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sqlSession;
    }
}

```
##### 自定义映射(含注释)
```xml
<!--
resuletMap:设置自定义的映射关系
id:唯一标识
type：处理映射关系实体类的类型
id:处理主键和实体类的映射关系
result:处理普通字段和实体类的属性的映射关系
column:设置映射关系中的字段名，必须是sql查询出的某个字段
property:设置映射关系中的属性名，必须是处理的实体类类型的属性名
-->
<resultMap id="resultMapEmp" type="Emp">
  <id column="emp_id" property="empId"></id>
  <result column="emp_name" property="empName"></result>
  <result column="age" property="age"></result>
  <result column="gender" property="gender"></result>
</resultMap>
```
