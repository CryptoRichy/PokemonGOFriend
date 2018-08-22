package DAO;

import Interfaces.LocationDAOI;
import Models.Location;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements LocationDAOI {
    @Override
    public List<Location> locationList() {

        List<Location>locations = new ArrayList<>();
        String sql = "Select * from Location";
        try {
            OracleConnection con = new OracleConnection();
            Connection connected = con.getConnection();

            PreparedStatement ps = connected.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();
//            create table location(
//                    LocationID int primary key,
//                    location varchar2(30) not null,
//                    coordinateY int not null,
//                    coordinateX int not null



            while (rs.next()) {
                    Location temp=new Location();
                    temp.setLocationID(rs.getInt("LocationID"));
                    temp.setLocation(rs.getString("location"));
                    temp.setCoordinateX(rs.getInt("coordinateX"));
                    temp.setCoordinateY(rs.getInt("coordinateY"));
                    locations.add(temp);
            }
            connected.close();
            System.out.println(locations.size());
            System.out.println("successful get all locations");


        } catch (Exception e) {
            System.out.println(e.toString());

        }

        return locations;

    }
}

