/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata_movie.data_movieDAO;
import DAOImplement.data_movieimplement;
import movie.*;
import main.main_view; 

/**
 *
 * @author HP
 */
public class data_moviecontroller {
    main_view frame;
    data_movieimplement impldatamovie;
    List<data_movie> dm;
    
    public data_moviecontroller(main_view frame){
        this.frame = frame;
        impldatamovie = new data_movieDAO();
        dm = impldatamovie.getAll();
    }
    public void isitabel(){
        dm = impldatamovie.getAll();
        tabeldata_movie mv = new tabeldata_movie(dm);
        frame.getData_movietable().setModel(mv);
    }
    public void insert(){
        data_movie dm = new data_movie();
        dm.setJudul(frame.getJtxtjudul().getText());
        dm.setAlur(Double.parseDouble(frame.getJtxtalur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getJtxtpenokohan().getText()));
        dm.setAkting(Double.parseDouble(frame.getJtxtakting().getText()));
        impldatamovie.insert(dm);
    }
    
    public void update(){
        data_movie dm = new data_movie();
        dm.setAlur(Double.parseDouble(frame.getJtxtalur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getJtxtpenokohan().getText()));
        dm.setAkting(Double.parseDouble(frame.getJtxtakting().getText()));
        dm.setJudul(frame.getJtxtjudul().getText());
        impldatamovie.update(dm);
    }
    public void delete(){
        data_movie dm = new data_movie();
        dm.setJudul(frame.getJtxtjudul().getText());
        impldatamovie.delete(dm);
    }
        
}
