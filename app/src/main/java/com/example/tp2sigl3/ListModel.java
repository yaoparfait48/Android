package com.example.tp2sigl3;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ListModel {

    /**
     *
     */
    private String title;
    private String description;
    private int image;
    private double latitude;
    private double longitude;

    /**
     *
     */
    private int imageAdvers;
    private String groupe;
    private String nomAdvers;
    private String niveau;
    private String datMatch;
    private String heureMatch;

    /**
     *
     */
    private String urg_nom;
    private String urg_tel;
    private int img_urg;

    /**
     *
     * @param title
     * @param description
     * @param image
     */
    public ListModel(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public ListModel(int img_urg, String urg_nom, String urg_tel){
        this.urg_nom = urg_nom;
        this.urg_tel = urg_tel;
        this.img_urg = img_urg;
    }

    public ListModel(String urg_nom, String urg_tel){
        this.urg_nom = urg_nom;
        this.urg_tel = urg_tel;
    }

    /**
     * Model pour les sites touristiques
     * @param title
     * @param description
     * @param image
     * @param latitude
     * @param longitude
     */
    public ListModel(String title, String description, int image, double latitude, double longitude) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Model pour les match
     * @param imageAdvers
     * @param groupe
     * @param nomAdvers
     * @param niveau
     * @param datMatch
     * @param heureMatch
     */
    public ListModel(int imageAdvers, String groupe, String nomAdvers, String niveau, String datMatch, String heureMatch) {
        this.imageAdvers = imageAdvers;
        this.groupe = groupe;
        this.nomAdvers = nomAdvers;
        this.niveau = niveau;
        this.datMatch = datMatch;
        this.heureMatch = heureMatch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageAdvers() {
        return imageAdvers;
    }

    public void setImageAdvers(int imageAdvers) {
        this.imageAdvers = imageAdvers;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getNomAdvers() {
        return nomAdvers;
    }

    public void setNomAdvers(String nomAdvers) {
        this.nomAdvers = nomAdvers;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDatMatch() {
        return datMatch;
    }

    public void setDatMatch(String datMatch) {
        this.datMatch = datMatch;
    }

    public String getHeureMatch() {
        return heureMatch;
    }

    public void setHeureMatch(String heureMatch) {
        this.heureMatch = heureMatch;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUrg_nom() {
        return urg_nom;
    }

    public void setUrg_nom(String urg_nom) {
        this.urg_nom = urg_nom;
    }

    public String getUrg_tel() {
        return urg_tel;
    }

    public void setUrg_tel(String urg_tel) {
        this.urg_tel = urg_tel;
    }

    public int getImg_urg() {
        return img_urg;
    }

    public void setImg_urg(int img_urg) {
        this.img_urg = img_urg;
    }
}
