/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.Connector;
import interfaces.MovieInterface;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Movie implements MovieInterface{
    Connector connector = new Connector();
    
    @Override
    public String[][] getDataMovie() {
        String data[][] = new String [10][5];
        int jmlData = 0;
        try{
            String query = "SELECT * FROM movie";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("judul");
                data[jmlData][1] = resultSet.getString("alur"); 
                data[jmlData][2] = resultSet.getString("penokohan"); 
                data[jmlData][3] = resultSet.getString("akting");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++; 
            }
            connector.statement.close();
           
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            
        }finally{
            return data;
        }
    }

    @Override
    public boolean insertDataMovie(String judul,double alur,double penokohan,double akting) {
        double nilai = (alur+penokohan+akting)/3;
        try {
            String query = "INSERT INTO movie (judul,alur,penokohan,akting,nilai) "
                    + "VALUES ('"+judul+"','"+alur+"','"+penokohan+"','"+akting+"','"+nilai+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query); // eksekusi query

            JOptionPane.showMessageDialog(null,"Insert data Berhasil !!");
            return true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public int updateDataMovie(String judul,double alur,double penokohan,double akting) {
        double nilai = (alur+penokohan+akting)/3;
        try {
            String query = "UPDATE movie set"
                    + " alur='"+alur+"', penokohan='"+penokohan+"', akting='"+akting+"', "
                    + "nilai='"+nilai+"' WHERE judul='"+judul+"'";
            
            connector.statement = connector.koneksi.createStatement();
            int affectedRow = connector.statement.executeUpdate(query); // eksekusi query
             
            return affectedRow;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
        
    }
    
    public int deleteDataMovie(String judul) {
        try {
            String query = "DELETE FROM movie WHERE judul='"+judul+"'";
            
            connector.statement = connector.koneksi.createStatement();
            int affectedRow = connector.statement.executeUpdate(query); // eksekusi query
             
            return affectedRow;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
        
    }
    
}
