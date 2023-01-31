package com.order.dao.impl;

import com.order.dao.SectorDao;
import com.order.model.Customer;
import com.order.model.Sector;
import com.order.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectorImpl implements SectorDao {
    @Override
    public String saveSector(Sector sector) {
        try {
            Connection connection = DBUtil.connection();
            String saveSector = "Insert into sector (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(saveSector);
            preparedStatement.setString(1, sector.getName());
            preparedStatement.executeUpdate();
            DBUtil.close(connection, preparedStatement, null);
            return "Sector Saved";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }

    @Override
    public List<Sector> allSectorById(List<Integer> integerList) {
        List<Sector> sectors = new ArrayList<>();
        for (int i : integerList) {
            try {
                Connection connection = DBUtil.connection();
                PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer where id = ?");
                preparedStatement.setInt(1, i);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Sector sector= new Sector();
                    sector.setId(rs.getInt("id"));
                    sector.setName(rs.getString("name"));
                    sectors.add(sector);
                }
                DBUtil.close(connection, preparedStatement, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sectors;
    }
}
