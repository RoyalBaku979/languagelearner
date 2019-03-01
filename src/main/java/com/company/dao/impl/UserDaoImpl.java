package com.company.dao.impl;

import com.company.dao.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements com.company.dao.inter.UserDaoInter {

        public User getUser(ResultSet rs) throws Exception{
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String password = rs.getString("password");
            int active = rs.getInt("active");

            return new User(id, name, surname, email, password, active);
        }

        @Override
        public List<User> getAll() {
            List<User> result = new ArrayList<>();
            try(Connection c = connect()) {//try-with-resources
               Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("select * from user");

               while (rs.next()) {//1,2
                   User u = getUser(rs);
                   result.add(u);
               }
           }catch (Exception ex){
               ex.printStackTrace();
           }

            return result;
        }


    @Override
    public List<User> getAll(String name) {
        List<User> result = new ArrayList<>();
        try(Connection c = connect()) {//try-with-resources
            String sql = "select * from user where name=?";

            PreparedStatement stmt = c.prepareStatement(sql);//encode
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {//1,2
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public User getById(int id) {
        User result = null;
        try(Connection c = connect()) {//try-with-resources
            String sql = "select * from user where id=?";

            PreparedStatement stmt = c.prepareStatement(sql);//encode
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {//1,2
                result = getUser(rs);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public void add(User u){
        try(Connection c = connect()){

            String sql = "insert into user(name,surname,email,password, active) values(?,?,?,?,?)";
            PreparedStatement stmt= c.prepareStatement(sql);
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getEmail());
            stmt.setString(4,u.getPassword());
            stmt.setInt(5,u.getActive());

            stmt.execute(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void update(User u){
        try(Connection c = connect()){

            String sql = "update user set name=?, surname=?, email=?, password=?, active=? where id=?";
            PreparedStatement stmt= c.prepareStatement(sql);
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getEmail());
            stmt.setString(4,u.getPassword());
            stmt.setInt(5,u.getActive());
            stmt.setInt(6,u.getId());

            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void remove(User u){
        try(Connection c = connect()){
            String sql = "delete from user where id=?";
            PreparedStatement stmt= c.prepareStatement(sql);
            stmt.setInt(1, u.getId());
            stmt.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
