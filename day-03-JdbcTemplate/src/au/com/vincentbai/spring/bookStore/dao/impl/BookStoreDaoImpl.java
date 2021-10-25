package au.com.vincentbai.spring.bookStore.dao.impl;

import au.com.vincentbai.spring.bookStore.dao.BookStoreDao;
import au.com.vincentbai.spring.bookStore.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookStoreDaoImpl implements BookStoreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPrice(String bid) {

        Integer price = jdbcTemplate.queryForObject("select price from book where bid = ?", new Object[]{bid}, Integer.class);
        return price;
    }

    @Override
    public void updateStock(String bid) {

        // 1. 获取改书籍的库存
        Integer preStock = jdbcTemplate.queryForObject("select stock from stock where sid = ?", new Object[]{bid}, Integer.class);

        // 如果想将事务进行回滚的话，必须要有异常
        if(preStock<=0){
            throw new RuntimeException();
        }else{
            jdbcTemplate.update("update stock set stock = stock - 1 where sid = ?", bid);
        }

    }

    @Override
    public void updateBalance(String uid, Integer price) {

        Integer balance = jdbcTemplate.queryForObject("select balance from account where uid = ?", new Object[]{uid}, Integer.class);

        if(balance < price){
            throw new MyException("餘額不足！");
        }else{
            jdbcTemplate.update("update account set balance = balance - ? where uid = ?", new Object[]{price, uid});
        }

    }
}
