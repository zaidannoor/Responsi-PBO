/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Lenovo
 */
public interface MovieInterface {
    public String[][] getDataMovie();
    public boolean insertDataMovie(String judul,double alur,double penokohan,double akting);
    public int updateDataMovie(String judul,double alur,double penokohan,double akting);
}
