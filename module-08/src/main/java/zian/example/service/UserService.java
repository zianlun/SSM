package zian.example.service;

import org.springframework.stereotype.Service;
import zian.example.dao.UserDao;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ljzhang
 * @Date: 2023/02/27/10:05
 * @Description:
 */
@Service
public interface UserService {
    void saveUser();
}
