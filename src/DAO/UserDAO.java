package DAO;

import Interfaces.UserDAOI;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOI {

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "Select * from Users";
        try {
            OracleConnection con = new OracleConnection();
            Connection connected = con.getConnection();

            PreparedStatement ps = connected.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();
//            CREATE TABLE users (
//                    user_id      INT PRIMARY KEY,
//                    trainerlvl   INT NOT NULL,
//                    team         VARCHAR2(255) NOT NULL,
//                    location     VARCHAR2(255) NOT NULL,
//                    user_name    VARCHAR2(255) NOT NULL UNIQUE,
//                    friendcode   INT NOT NULL UNIQUE
//            );

            while (rs.next()) {

                User temp = new User();
                temp.setUser_Name(rs.getString("user_name"));
                temp.setTrainerLVL(rs.getInt("trainerlvl"));
                temp.setTeam(rs.getString("team"));
                temp.setLocation(rs.getString("location"));
                temp.setFriendCOde(rs.getInt("friendcode"));
                temp.setId(rs.getInt("user_id"));

                users.add(temp);


            }

            System.out.println(users.size());
            System.out.println("successful get all users");


        } catch (Exception e) {
            System.out.println(e.toString());

        }


        return users;
    }

    @Override
    public List<User> getUsersBylocation(String loc) {

        return null;
    }

    public boolean insertNewUser(User user) {

        OracleConnection con = new OracleConnection();
        //Insert into Users (User_ID,TRAINERLVL,team,location,User_name,Friendcode) values (34,'instinct','college point','DaBason',103104105);
        String Insert = "Insert into Users (User_ID,TRAINERLVL,team,location,User_name,Friendcode) values (seq_person.nextval,?,?,?,?,?)";

        try {

            Connection connected = con.getConnection();

            PreparedStatement ps = connected.prepareStatement(Insert);

            ps.setInt(1, user.getTrainerLVL());
            ps.setString(2, user.getTeam());
            ps.setString(3, user.getLocation());
            ps.setString(4, user.getUser_Name());
            ps.setInt(5, user.getFriendCOde());
            ResultSet rs = ps.executeQuery();


            System.out.println("successful insert");
            connected.close();
            return true;


        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }


    }


}




