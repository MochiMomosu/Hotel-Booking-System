/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBcontext.DBcontext;
import Model.ServiceCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pham quoc an
 */
public class ServiceCategoryDAO {

    private Connection conn = new DBcontext().getConnection();
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

//    public ArrayList<HotelGallery> getAllGallery(){
//        ArrayList<HotelGallery> list = new ArrayList<>();
//        query = "SELECT * FROM HotelGallery";
//        try{
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                list.add(new HotelGallery(rs.getInt("id"),
//                            rs.getString("title"),
//                            rs.getString("image"),
//                            rs.getInt("hotelID")
//                ));
//            }
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        return list; 
//    }
//    public ArrayList<HotelGallery> getGalleryByID(int hotelID){
//        ArrayList<HotelGallery> list = new ArrayList<>();
//        query = "SELECT id, title, image, hotelId FROM HotelGallery WHERE hotelId = ?";
//        try{
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, hotelID);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                list.add(new HotelGallery(rs.getInt("id"),
//                            rs.getString("title"),
//                            rs.getString("image"),
//                            rs.getInt("hotelID")
//                ));
//            }
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        return list;
//    }
    public void addServiceCategory(ServiceCategory sc) {
        query = "INSERT INTO [ServiceCategories]([ServiceCategory])\n"
                + "                         VALUES(?)";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sc.getCategory());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateServiceCategory(int id, ServiceCategory sc) {
        query = "UPDATE ServiceCategories SET ServiceCategory = ?\n"
                + "                WHERE id = ?";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, sc.getCategory());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public void removeServiceCategory(int id) {
        query = "DELETE FROM ServiceCategories WHERE id = ?";
        try {
            conn = new DBcontext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
