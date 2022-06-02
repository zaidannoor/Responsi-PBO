/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.model.Movie;
import app.view.ViewMain;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class MovieController {
    
//    public void submitForm(String judul,double alur,double penokohan,double akting){
//        Movie movie = new Movie();
//        if(alur < 0 || penokohan < 0 || akting < 0){
//            JOptionPane.showMessageDialog(null,"Minimal inputan adalah 0");
//        }
//        else if(alur > 5 || penokohan > 5 || akting > 5){
//            JOptionPane.showMessageDialog(null,"Maximal inputan adalah 5");
//        }
//        else if(judul.equals("")){
//            JOptionPane.showMessageDialog(null,"Judul tidak boleh kosong");
//        }
//        else{
//            movie.insertDataMovie(judul,alur,penokohan,akting);
//        }    
//    }
    
    public  void submitForm(ViewMain viewmain){
        String judul = viewmain.getJudul();
        double alur = viewmain.getAlur();
        double penokohan = viewmain.getPenokohan();
        double akting = viewmain.getAkting();
        //System.out.println("Contoller");
        Movie movie = new Movie();
        if(alur < 0 || penokohan < 0 || akting < 0){
            JOptionPane.showMessageDialog(null,"Minimal inputan adalah 0");
        }
        else if(alur > 5 || penokohan > 5 || akting > 5){
            JOptionPane.showMessageDialog(null,"Maximal inputan adalah 5");
        }
        else if(judul.equals("")){
            JOptionPane.showMessageDialog(null,"Judul tidak boleh kosong");
        }
        else{
            movie.insertDataMovie(judul,alur,penokohan,akting);
        }
    }
    
    public void updateForm(){
        
    }
    
    public void clearForm(){
        
    }
}
