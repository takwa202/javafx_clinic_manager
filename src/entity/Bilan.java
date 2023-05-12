/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author marie
 */
public class Bilan {
    private int id_bilan;
    private String type;
    private  Timestamp date_bilan;
    private String conclusion;

    public Bilan() {
    }

    public Bilan(int id_bilan, String type, Timestamp date_bilan, String conclusion) {
        this.id_bilan = id_bilan;
        this.type = type;
        this.date_bilan = date_bilan;
        this.conclusion = conclusion;
    }

    public Bilan(String type, Timestamp date_bilan, String conclusion) {
        this.type = type;
        this.date_bilan = date_bilan;
        this.conclusion = conclusion;
    }

    public Bilan(int id_bilan, Timestamp date_bilan, String conclusion) {
        this.id_bilan = id_bilan;
        this.date_bilan = date_bilan;
        this.conclusion = conclusion;
    }
    
    

    public int getId_bilan() {
        return id_bilan;
    }

    public void setId_bilan(int id_bilan) {
        this.id_bilan = id_bilan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDate_bilan() {
        return date_bilan;
    }

    public void setDate_bilan(Timestamp date_bilan) {
        this.date_bilan = date_bilan;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "Bilan{" + "type=" + type + ", date_bilan=" + date_bilan + ", conclusion=" + conclusion + '}';
    }

    

    
    
}

