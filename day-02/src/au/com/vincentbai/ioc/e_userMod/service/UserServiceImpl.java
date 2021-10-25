package au.com.vincentbai.ioc.e_userMod.service;

import au.com.vincentbai.ioc.e_userMod.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// value="aaaa" 生成 bean 的 id为 aaaa
@Service(value="aaaa")
public class UserServiceImpl implements UserService{

    // autowired 先通过 byType 再通过 byName 来进行装配
    // required = false 如果没有找到，spring 不会报错
    @Autowired(required = false)
    @Qualifier(value = "userDaoMybitesImpl")
    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("User Service Impl");
    }

    @Override
    public void addUser() {

        userDao.addUser();

    }
}
