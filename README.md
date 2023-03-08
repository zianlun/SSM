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


##### 逆向工程核心配置文件 generatorConfig.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!--
  targetRuntime: 执行生成的逆向工程的版本
  MyBatis3Simple: 生成基本的CRUD（清新简洁版）
  MyBatis3: 生成带条件的CRUD（奢华尊享版）
  -->
    <context id="DB2Tables" targetRuntime="MyBatis3">
        <!-- 数据库的连接信息 -->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/SSM? serverTimezone=UTC"
                        userId="root"
                        password="123456">
        </jdbcConnection>
        <!-- javaBean的生成策略-->
        <javaModelGenerator targetPackage="zian.example.pojo" targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
            <property name="nullCatalogMeansCurrent" value="true"/>
        </javaModelGenerator>
        <!-- SQL映射文件的生成策略 -->
        <sqlMapGenerator targetPackage="zian.example.mapper" targetProject=".\src\main\resources">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>
        <!-- Mapper接口的生成策略 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="zian.example.mapper" targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>
        <!-- 逆向分析的表 -->
        <!-- tableName设置为*号，可以对应所有表，此时不写domainObjectName -->
        <!-- domainObjectName属性指定生成出来的实体类的类名 -->
        <table tableName="employee" domainObjectName="Employee"/>
        <table tableName="department" domainObjectName="Deptartment"/>
    </context>
</generatorConfiguration>


```

### Spring Framework

##### log4j2配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
  <loggers>
    <!--
    level指定日志级别，从低到高的优先级：
    TRACE < DEBUG < INFO < WARN < ERROR < FATAL
    trace：追踪，是最低的日志级别，相当于追踪程序的执行
    debug：调试，一般在开发中，都将其设置为最低的日志级别
    info：信息，输出重要的信息，使用较多
    warn：警告，输出警告的信息
    error：错误，输出错误信息
    fatal：严重错误
    -->
    <root level="DEBUG">
      <appender-ref ref="spring6log"/>
      <appender-ref ref="RollingFile"/>
      <appender-ref ref="log"/>
    </root>
  </loggers>

  <appenders>
    <!--输出日志信息到控制台-->
    <console name="spring6log" target="SYSTEM_OUT">
      <!--控制日志输出的格式-->
      <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss SSS} [%t] %-3level %logger{1024} - %msg%n"/>
    </console>

    <!--文件会打印出所有信息，这个log每次运行程序会自动清空，由append属性决定，适合临时测试用-->
    <File name="log" fileName="E:/workSpace/SSM/module-01/log/test.log" append="false">
      <PatternLayout pattern="%d{HH:mm:ss.SSS} %-5level %class{36} %L %M - %msg%xEx%n"/>
    </File>

    <!-- 这个会打印出所有的信息，
    每次大小超过size，
    则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，
    作为存档-->
    <RollingFile name="RollingFile" fileName="E:/workSpace/SSM/module-01/log/app.log"
      filePattern="log/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
      <PatternLayout pattern="%d{yyyy-MM-dd 'at' HH:mm:ss z} %-5level %class{36} %L %M - %msg%xEx%n"/>
      <SizeBasedTriggeringPolicy size="50MB"/>
      <!-- DefaultRolloverStrategy属性如不设置，
      则默认为最多同一文件夹下7个文件，这里设置了20 -->
      <DefaultRolloverStrategy max="20"/>
    </RollingFile>
  </appenders>
</configuration>
```
#### 配置spring头文件——命名空间
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">
```
#### 包括aop的配置头文件
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd ">
```
```xml
第一种方式是将常用的命名空间都记录下来，需要时复制黏贴导入，但现在此种方式不建议。
1.util标签用来配置集合、常量等的
xmlns:util="http://www.springframework.org/schema/util"
http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd


2.jee标签用来处理javaee标准相关的问题，例如查询一个jndi对象以及定义一个ejb的引用等  
xmlns:jee="http://www.springframework.org/schema/jee"   
http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd


3.lang用来将那些已经被定义在一些动态语言（例如Jruby和Groovy）中的对象作为beans中的对象存放到spring容器中
xmlns:lang="http://www.springframework.org/schema/lang"
http://www.springframework.org/schema/lang http://www.springframework.org/schema/lang/spring-lang.xsd


4.jms :
xmlns:jms="http://www.springframework.org/schema/jms"
http://www.springframework.org/schema/jms http://www.springframework.org/schema/jms/spring-jms.xsd

5.aop :
xmlns:aop="http://www.springframework.org/schema/aop"   
http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd

6.context 
xmlns:context="http://www.springframework.org/schema/context"
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd

7.jdbc
xmlns:jdbc="http://www.springframework.org/schema/jdbc"
http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc.xsd

8.cache 
xmlns:jdbc="http://www.springframework.org/schema/cache"
http://www.springframework.org/schema/cache http://www.springframework.org/schema/jdbc/spring-cache.xsd

9.tx (transaction事务管理) 使用时建议配合aop:
xmlns:aop="http://www.springframework.org/schema/aop"
xmlns:tx="http://www.springframework.org/schema/tx"
http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd

10.p命名空间，进行简化bean的创建，属性的注入书写方式
xmlns:p="http://www.springframework.org/schema/p"

11.mybatis-spring
xmlns:mybatis-spring="http://mybatis.org/schema/mybatis-spring"
http://mybatis.org/schema/mybatis-spring http://mybatis.org/schema/mybatis-spring-1.2.xsd


12.mvc
xmlns:mvc=”http://www.springframework.org/schema/mvc”
xsi:schemaLocation=”http://www.springframework.org/schema/mvc
http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd”

```