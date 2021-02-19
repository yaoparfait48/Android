package com.example.tp2sigl3;

public class DataModel {
    private  int id;
    private int id_etrangere;

    /**
     * Table site
     */
    private String nomSite;
    private String categSite;
    private double latitudSite;
    private double longitudSite;
    private String urlVideosSite;
    private int urlImgSite;
    private String description;

    //Table Match
    private String adversairesMatch;
    private String niveauMatch;
    private String dateMatch;
    private String heureMatch;
    private String urlVideoMatch;
    private int urlPhotoMatch;
    private String groupe;

    /**
     * Table Urgence
     */

    private int urg_img;
    private String urg_nom;
    private String urg_tel;

    /**
     *
     * @param id
     * @param nomSite
     * @param categSite
     * @param latitudSite
     * @param longitudSite
     * @param urlVideosSite
     * @param urlImgSite
     * @param description
     */

    //Constructeur pour la table site
    public DataModel(int id, String nomSite, String categSite, double latitudSite, double longitudSite, String urlVideosSite, int urlImgSite, String description) {
        this.id = id;
        this.nomSite = nomSite;
        this.categSite = categSite;
        this.latitudSite = latitudSite;
        this.longitudSite = longitudSite;
        this.urlVideosSite = urlVideosSite;
        this.urlImgSite = urlImgSite;
        this.description = description;
    }

    //CONTRUCTEUR TABLE MATCH
    public DataModel(int id, int id_etrangere, String adversairesMatch, String niveauMatch, String dateMatch, String heureMatch, String urlVideoMatch, int urlPhotoMatch, String groupe) {
        this.id = id;
        this.id_etrangere = id_etrangere;
        this.adversairesMatch = adversairesMatch;
        this.niveauMatch = niveauMatch;
        this.dateMatch = dateMatch;
        this.heureMatch = heureMatch;
        this.urlVideoMatch = urlVideoMatch;
        this.urlPhotoMatch = urlPhotoMatch;
        this.groupe = groupe;
    }

    //CONTRUCTEUR TABLE URG;
    public DataModel(int id, int urg_img, String urg_nom, String urg_tel) {
        this.id = id;
        this.urg_img = urg_img;
        this.urg_nom = urg_nom;
        this.urg_tel = urg_tel;
    }

    public DataModel(String urg_nom, String urg_tel){
        this.urg_nom = urg_nom;
        this.urg_tel = urg_tel;
    }

    //CONSTRUCTEUR TABLE TOURISME

    //Accesseur et Modificateur
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public String getCategSite() {
        return categSite;
    }

    public void setCategSite(String categSite) {
        this.categSite = categSite;
    }

    public double getLatitudSite() {
        return latitudSite;
    }

    public void setLatitudSite(double latitudSite) {
        this.latitudSite = latitudSite;
    }

    public double getLongitudSite() {
        return longitudSite;
    }

    public void setLongitudSite(double longitudSite) {
        this.longitudSite = longitudSite;
    }

    public String getUrlVideosSite() {
        return urlVideosSite;
    }

    public void setUrlVideosSite(String urlVideosSite) {
        this.urlVideosSite = urlVideosSite;
    }

    public int getUrlImgSite() {
        return urlImgSite;
    }

    public void setUrlImgSite(int urlImgSite) {
        this.urlImgSite = urlImgSite;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getAdversairesMatch() {
        return adversairesMatch;
    }

    public void setAdversairesMatch(String adversairesMatch) {
        this.adversairesMatch = adversairesMatch;
    }

    public String getNiveauMatch() {
        return niveauMatch;
    }

    public void setNiveauMatch(String niveauMatch) {
        this.niveauMatch = niveauMatch;
    }

    public String getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getHeureMatch() {
        return heureMatch;
    }

    public void setHeureMatch(String heureMatch) {
        this.heureMatch = heureMatch;
    }

    public String getUrlVideoMatch() {
        return urlVideoMatch;
    }

    public void setUrlVideoMatch(String urlVideoMatch) {
        this.urlVideoMatch = urlVideoMatch;
    }

    public int getUrlPhotoMatch() {
        return urlPhotoMatch;
    }

    public void setUrlPhotoMatch(int urlPhotoMatch) {
        this.urlPhotoMatch = urlPhotoMatch;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public int getId_etrangere() {
        return id_etrangere;
    }

    public void setId_etrangere(int id_etrangere) {
        this.id_etrangere = id_etrangere;
    }

    public int getUrg_img() {
        return urg_img;
    }

    public void setUrg_img(int urg_img) {
        this.urg_img = urg_img;
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
}
