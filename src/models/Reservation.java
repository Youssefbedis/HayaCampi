/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class Reservation {
    private int id;
    private LocalDate DateDebut;   
    private LocalDate DateFin;
    private String NbrPersonne;
    private  String  NomCentre;

    public Reservation() {
    }

    public Reservation(int id, LocalDate DateDebut, LocalDate DateFin, String NbrPersonne, String NomCentre) {
        this.id = id;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.NbrPersonne = NbrPersonne;
        this.NomCentre = NomCentre;
    }

    public Reservation(LocalDate DateDebut, LocalDate DateFin, String NbrPersonne, String NomCentre) {
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.NbrPersonne = NbrPersonne;
        this.NomCentre = NomCentre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(LocalDate DateDebut) {
        this.DateDebut = DateDebut;
    }

    public LocalDate getDateFin() {
        return DateFin;
    }

    public void setDateFin(LocalDate DateFin) {
        this.DateFin = DateFin;
    }

    public String getNbrPersonne() {
        return NbrPersonne;
    }

    public void setNbrPersonne(String NbrPersonne) {
        this.NbrPersonne = NbrPersonne;
    }

    public String getNomCentre() {
        return NomCentre;
    }

    public void setNomCentre(String NomCentre) {
        this.NomCentre = NomCentre;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", NbrPersonne=" + NbrPersonne + ", NomCentre=" + NomCentre + '}';
    }
   
    
    
}
