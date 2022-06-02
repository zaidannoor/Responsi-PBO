/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.Connector;
import app.controller.MovieController;
import app.model.Movie;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class ViewMain implements ActionListener{
    Connector connector = new Connector();
    
    //DEKLARASI KOMPONEN  
    JFrame window = new JFrame("Dashboard");
    
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"Judul","Alur","Penokohan","Akting","Nilai"};
    
    JLabel ljudul = new JLabel("Judul");
        JTextField tfjudul = new JTextField();
    JLabel lalur = new JLabel("Alur");
        JTextField tfalur = new JTextField();
    JLabel lpenokohan = new JLabel("Penokohan");
        JTextField tfpenokohan = new JTextField();
    JLabel lakting = new JLabel("Akting");
        JTextField tfakting = new JTextField();
    
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    
    MovieController controller;
   
    public ViewMain(){
        Movie movie = new Movie();
        String data[][] = movie.getDataMovie();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(800,600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        // ADD Component
            window.add(ljudul);
            window.add(lalur);
            window.add(lpenokohan);
            window.add(lakting);
            
            window.add(tfjudul);
            window.add(tfalur);
            window.add(tfpenokohan);
            window.add(tfakting);
            
            window.add(btnTambah);
            window.add(btnUpdate);
            window.add(btnDelete);
            window.add(btnClear);
            
            
        // Atur Letak
            ljudul.setBounds(620, 30, 90, 20);
            lalur.setBounds(620, 90, 90, 20);
            lpenokohan.setBounds(620, 150, 90, 20);
            lakting.setBounds(620, 220, 90, 20);
            
            tfjudul.setBounds(615, 55, 130, 20);
            tfalur.setBounds(615, 115, 130, 20);
            tfpenokohan.setBounds(615, 175, 130, 20);
            tfakting.setBounds(615, 245, 130, 20);
            
            btnTambah.setBounds(610, 315, 120, 30);
            btnUpdate.setBounds(610,365,120,30);
            btnDelete.setBounds(610,415,120,30);
            btnClear.setBounds(610, 465, 120, 30);
        
        // add actionlistener untuk button
            btnTambah.addActionListener(this);
            btnUpdate.addActionListener(this);
            btnDelete.addActionListener(this);
            btnClear.addActionListener(this);
        
        // add table
        tabel = new JTable(data,namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        scrollPane.setBounds(20, 20, 500, 500);

        controller = new MovieController();
        
        // Mengambil data click tabel
        tabel.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            String judul = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
            String alur = tabel.getValueAt(tabel.getSelectedRow(), 1).toString();
            String penokohan = tabel.getValueAt(tabel.getSelectedRow(), 2).toString();
            String akting = tabel.getValueAt(tabel.getSelectedRow(), 3).toString();
            setJudul(judul);
            setAlur(alur);
            setPenokohan(penokohan);
            setAkting(akting);

        }
    });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnTambah){
            controller.submitForm(this);
            window.setVisible(false);
            new ViewMain();
        }
        
        if(e.getSource() == btnClear){
            controller.clearForm(this);
        }
        
        if(e.getSource() == btnUpdate){
            controller.updateForm(this);
            window.setVisible(false);
            new ViewMain();
            
        }
        
        if(e.getSource() == btnDelete){
            controller.deleteForm(this);
            window.setVisible(false);
            new ViewMain();
        }
        
    }
    
    
    
    public String getJudul(){
        return tfjudul.getText();
    }
    public double getAlur(){
        double alur = Double.parseDouble(tfalur.getText());
        return alur;
    }
    public double getPenokohan(){
        double penokohan = Double.parseDouble(tfpenokohan.getText());
        return penokohan;
    }
    public double getAkting(){
        double akting = Double.parseDouble(tfakting.getText());
        return akting;
    }
    
    public void setJudul(String isi){   
        tfjudul.setText(isi);
    }
    public void setAlur(String isi){
        tfalur.setText(isi);
    }
    public void setPenokohan(String isi){
        tfpenokohan.setText(isi);
    }
    public void setAkting(String isi){
        tfakting.setText(isi);
    }
    

    
}
