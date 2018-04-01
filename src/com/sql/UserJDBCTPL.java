package com.sql;
import java.util.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserJDBCTPL implements UserDao{
    private DataSource dataSource;
    private JdbcTemplate jtpl;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jtpl = new JdbcTemplate(dataSource);
    }
    public void create(String name, Integer age){
        String sql="insert into user(name,age) values(?,?)";
        this.jtpl.update(sql,name,age);
        System.out.println("添加记录：name="+name+"   age="+age);
    }

    public User getUser(int id){


        String query = "select id, name, age from user where id = ?";
        User emp = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                emp = new User();
                emp.setId(id);
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                System.out.println("Employee Found::"+emp);
            }else{
                System.out.println("No Employee found with id="+id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emp;

//        try {
//            String sql = "select * from user where id = ?";
//
//
//            User user = this.jtpl.queryForObject(sql, new Object[]{id}, new UserMapper());
//            return user;
//        } catch (Exception e) {
//            // e.printStackTrace(); // 可以选择打印信息
//            return null;
//        }
//        return object;
//
//
//        String sql = "select * from user where id = ?";
//
//
//        User user = this.jtpl.queryForObject(sql, new Object[]{id}, new UserMapper());
//        return user;
    }


//    public User getUser(int id)  {
//        Connection connection = dataSource.getConnection();
//        String sql = "SELECT * FROM User WHERE ID = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, id);
//        ResultSet rs = preparedStatement.executeQuery();
//        User user = null;
//
//        connection.close();
//        preparedStatement.close();
//        rs.close();
//        return user;
//    }



    public List<User> listUsers(){
        String sql ="select *from user";
        List<User> all = this.jtpl.query(sql,new UserMapper());
        return all;
    }

    public void delete(Integer id){
        String sql = "delete from user where id=?";
        this.jtpl.update(sql,id);
        System.out.println("删除记录：id="+id);
        return;
    }

    public void update(Integer id,Integer age){
        String SQL = "update user set age=? where id=?";

        this.jtpl.update(SQL,age,id);

        System.out.println("更新表记录：id="+id);
        return ;
    }

}
