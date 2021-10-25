package au.com.vincentbai.spring.jdbctemplate.test;

import au.com.vincentbai.spring.jdbctemplate.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

public class TestJdbcTemplate {

    ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc-template.xml");

    JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void testUpdate(){

        // update方法 实现 增 删 改 三个功能
//        jdbcTemplate.update("insert into emp values(null, 'Vincent', 31, 'male')");

//        String sql = "insert into emp values(null, ?, ?, ?)";
//        jdbcTemplate.update(sql, "Jessie", 34,"female");

        // 批量删除
//        String batchDelSql = "delete from emp where eid in (?)";
//        jdbcTemplate.update(batchDelSql, "1,2,3"); 不能实现批量删除，只能删除第一个，因为在底层的 preparedStatement 将转换为 delete from emp where eid in (‘1,2,3’)

        // 如果需要使用 in 进行批量删除和修改，直接拼接字符串
        String ids = "3, 4, 5";
        String batchDelSql = "delete from emp where eid in (" + ids + ")";
        jdbcTemplate.update(batchDelSql);

        // 模糊查询也不能使用 preparedStatement和 setString 方法
        // 最后生成的 sql 是， select * from emp where ename like '%'a'%', sql语句直接报错
//        String keyword = "a";
//        String likeSql = "select * from emp where ename like '%?%'";
        String workingLiekSql = "select * from emp where ename like concat('%', ?, '%')"; // 加上 concat 后 模糊查询可以使用 preparedStatement

    }

    // 实现 update 的批量操作
    @Test
    public void testBatchUpdate(){

        String sql = "insert into emp values (null, ?, ?,?)";

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"a1", 1, "male"});
        list.add(new Object[]{"a2", 2, "male"});
        list.add(new Object[]{"a3", 3, "male"});

        jdbcTemplate.batchUpdate(sql, list);

    }

    @Test
    public void testQueryForObject(){

//        jdbcTemplate.queryForObject(sql, requiredType); 来获取单个的值，比如在使用聚合函数时
//        jdbcTemplate.queryForObject(sql, rowMapper); 用来获取单条数据

//        String sql = "select eid,ename,age,gender from emp where eid = ?";
        String sql = "select * from emp where eid = ?";
        RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class); // 将列名和属性名进行映射
        Emp emp = jdbcTemplate.queryForObject(sql, new Object[]{1}, rowMapper);
        System.out.println(emp);

//        String sql = "select count(*) from emp";
//        Integer count = jdbcTemplate.queryForObject(sql, Integer.class); // 只能使用 Integer.class 不能使用 int.class
//        System.out.println(count);
    }

    @Test
    public void testQuery(){

        String sql = "select * from emp";
        RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);
        List<Emp> list = jdbcTemplate.query(sql, rowMapper);
        for(Emp emp : list){
            System.out.println(emp);
        }
    }

}