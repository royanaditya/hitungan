/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata_movie;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import movie.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplement.data_movieimplement;


/**
 *
 * @author HP
 */
public class data_movieDAO implements data_movieimplement{
    Connection connection;
    
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE movie SET alur= ?, penokohan=?, akting=?, nilai=? where judul=?";
    final String delete = "DELETE FROM movie WHERE judul=?";
    
    public data_movieDAO(){
        connection = connector.connection();      
    }

    @Override
    public void insert(data_movie m) {
        
        PreparedStatement statement = null;
        
        try{
           double nilai = calculateNilai(m.getAlur(), m.getPenokohan(), m.getAkting());
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, nilai);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                m.setJudul(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public void update(data_movie m) {
        
        PreparedStatement statement = null;
        try{
            double nilai = calculateNilai(m.getAlur(), m.getPenokohan(), m.getAkting());
            statement = connection.prepareStatement(update);
            statement.setDouble(1, m.getAlur());
            statement.setDouble(2, m.getPenokohan());
            statement.setDouble(3, m.getAkting());
            statement.setDouble(4, nilai);
            statement.setString(5, m.getJudul());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(data_movie m) {
        PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(delete);
                statement.setString(1, m.getJudul());
                statement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
    }
    
    private double calculateNilai(Double alur, Double penokohan, Double akting) {
        return (alur + penokohan + akting) / 3.0;
    }

    @Override
    public List<data_movie> getAll() {
        List<data_movie> dm = new ArrayList<>();
        
        try{
            dm = new ArrayList<data_movie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                data_movie mv = new data_movie();
                mv.setJudul(rs.getString("Judul"));
                mv.setAlur(rs.getDouble("Alur"));
                mv.setPenokohan(rs.getDouble("Penokohan"));
                mv.setAkting(rs.getDouble("Akting"));
                mv.setMilai(rs.getDouble("Nilai"));
                dm.add(mv);
            }
            
            
            
        }catch(SQLException ex){
            Logger.getLogger(data_movieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
        
        
    }
}
