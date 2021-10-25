package au.com.vincentbai.ioc.e_userMod.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMybitesImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("UserDaoMybitesImpl: Add user successfully！");
    }
}
