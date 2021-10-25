package au.com.vincentbai.ioc.e_userMod.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    public UserDaoImpl() {
        System.out.println("User Dao Impl");
    }

    @Override
    public void addUser() {
        System.out.println("UserDaoImpl：Add user successfully!");
    }

}
