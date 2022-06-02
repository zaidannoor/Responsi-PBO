/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.model.Movie;
import app.view.ViewMain;

/**
 *
 * @author Lenovo
 */
public class MovieController {
    
    public void submitForm(String judul,double alur,double penokohan,double akting){
        Movie movie = new Movie();
        movie.insertDataMovie(judul,alur,penokohan,akting);
        
        
    }
}
