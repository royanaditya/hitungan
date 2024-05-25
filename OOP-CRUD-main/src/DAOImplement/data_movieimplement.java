/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import movie.*;

/**
 *
 * @author HP
 */
public interface data_movieimplement {
    public void insert(data_movie m);;
    public void update(data_movie m);
    public void delete(data_movie m);
    public List<data_movie> getAll();
    
    
}
