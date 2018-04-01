package com.sql;
import java.util.List;
import javax.sql.DataSource;

public interface UserDao {
    public void setDataSource(DataSource dataSource);
    public void create(String name,Integer age);

    public User getUser(int id);

    public List<User> listUsers();

    public void delete(Integer id);

    public void update(Integer id, Integer age);

}
