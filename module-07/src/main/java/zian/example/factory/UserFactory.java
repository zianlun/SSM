package zian.example.factory;

import org.springframework.beans.factory.FactoryBean;
import zian.example.pojo.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/26/19:01
 * @Description:
 * FactoryBean是一个接口，需要创建一个类实现该接口
 * 其中有三个方法：
 *         ----getObject, 返回一个对象交给IOC容器管理
 *         ----getObjectType, 返回所提供对象的类型
 *         ----isSingleton, 是否为单例
 * 当FactoryBean 实现类配置为bean时，会将当前类中getObject() 所
 * 返回的对象中的对象交给IOC容器管理
 */
public class UserFactory implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {

        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
