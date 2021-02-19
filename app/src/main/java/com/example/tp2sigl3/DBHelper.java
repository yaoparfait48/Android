package com.example.tp2sigl3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_SITE = "Site";
    public static final String TABLE_MATCH = "Matchs";
    public static final String TABLE_URGENCE = "Urgences";


    public static final String ID = "Id";
    /**
     * Table Site
     */
    public static final String NOM_SITE = "Nom";
    public static final String CATEGORIE_SITE = "Categorie";
    public static final String LATITUDE_SITE = "Latitude";
    public static final String LONGITUDE_SITE = "Longitude";
    public static final String URL_VIDEO_SITE = "UrlVideo";
    public static final String URL_PHOTO_SITE = "UrlPhoto";
    public static final String DESCRIPTION = "Description";

    /**
     * Table Match
     */
    public static final String ADVERSAIRES = "Adversaires";
    public static final String NIVEAU = "Niveau";
    public static final String DATE = "Date";
    public static final String HEURE = "Heure";
    public static final String URL_VIDEO_MATCH = "UrlVideo";
    public static final String URL_PHOTO_MATCH = "UrlPhoto";
    public static final String GROUPE = "Groupe";
    public static final String ID_ETRANGERE ="Id_etrangere";

    public static final String URG_NOM = "Nom";
    public static final String URG_TEL = "Telephone";
    public static final String URG_IMG = "Photo";


    SQLiteDatabase db;

    public DBHelper(@Nullable Context context) {
        super(context, "IvoireData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creationTableSite = "CREATE TABLE "+TABLE_SITE+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NOM_SITE+" TEXT, "
                +CATEGORIE_SITE+" TEXT, "
                +LATITUDE_SITE+" REAL, "
                +LONGITUDE_SITE+" REAL, "
                +URL_VIDEO_SITE+" TEXT, "
                +URL_PHOTO_SITE+" TEXT, "
                +DESCRIPTION+" TEXT)";

        String creationTableMatch = "CREATE TABLE "+TABLE_MATCH+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +ID_ETRANGERE+" INTEGER, "
                +ADVERSAIRES+" TEXT, "
                +NIVEAU+" TEXT, "
                +DATE+" TEXT, "
                +HEURE+" TEXT, "
                +URL_VIDEO_MATCH+" TEXT, "
                +URL_PHOTO_MATCH+" TEXT,"
                +GROUPE+" TEXT)";

        String creationTableUrgence = "CREATE TABLE "+TABLE_URGENCE+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +URG_IMG+" INTEGER,"
                +URG_NOM+" TEXT, "
                +URG_TEL+" TEXT) ";

        db.execSQL(creationTableSite);
        db.execSQL(creationTableMatch);
        db.execSQL(creationTableUrgence);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITE);
        onCreate(db);
    }

    public boolean ajouterSite(DataModel dataModel){
        SQLiteDatabase db = this.getWritableDatabase();
        /*String req = "INSERT INTO Site (Nom, Categorie, Latitude, Longitude, UrlVideo, UrlPhoto) VALUES (\"stade_FHB\",\"Rencontres\","+5.3654+","+3.5648+",\"http://video stade fhb\", \"stade_fhb\")";
        db.execSQL(req);*/
        ContentValues valeur = new ContentValues();

        valeur.put(NOM_SITE,dataModel.getNomSite());
        valeur.put(CATEGORIE_SITE,dataModel.getCategSite());
        valeur.put(LATITUDE_SITE, dataModel.getLatitudSite());
        valeur.put(LONGITUDE_SITE, dataModel.getLongitudSite());
        valeur.put(URL_VIDEO_SITE, dataModel.getUrlVideosSite());
        valeur.put(URL_PHOTO_SITE, dataModel.getUrlImgSite());
        valeur.put(DESCRIPTION, dataModel.getDescription());

        long insert = db.insert(TABLE_SITE, null, valeur);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean ajouterMatch(DataModel dataModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();

        val.put(ID_ETRANGERE,dataModel.getId_etrangere());
        val.put(ADVERSAIRES, dataModel.getAdversairesMatch());
        val.put(NIVEAU, dataModel.getNiveauMatch());
        val.put(DATE,dataModel.getDateMatch());
        val.put(HEURE, dataModel.getHeureMatch());
        val.put(URL_VIDEO_MATCH, dataModel.getUrlVideoMatch());
        val.put(URL_PHOTO_MATCH, dataModel.getUrlPhotoMatch());
        val.put(GROUPE,dataModel.getGroupe());

        long ins = db.insert(TABLE_MATCH, null, val);
        if(ins == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean ajouterUrgence(DataModel dataModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(URG_IMG, dataModel.getUrg_img());
        val.put(URG_NOM, dataModel.getUrg_nom());
        val.put(URG_TEL,dataModel.getUrg_tel());

        long ins = db.insert(TABLE_URGENCE, null, val);
        if(ins == -1){
            return false;
        }else{
            return true;
        }
    }


    //RECUPERATION
    public ArrayList<DataModel> recupererTout(){
        ArrayList<DataModel> listRetounee = new ArrayList<>();

        String req = "SELECT * FROM "+TABLE_SITE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(req, null);

        if(cursor.moveToFirst()){
            do {
                int id_site =cursor.getInt(0);
                String nom_site = cursor.getString(1);
                String categ_site = cursor.getString(2);
                double lati_site = cursor.getDouble(3);
                double longi_site = cursor.getDouble(4);
                String url_video = cursor.getString(5);
                int url_photo = cursor.getInt(6);
                String description = cursor.getString(7);

                DataModel newDataModel = new DataModel(id_site,nom_site,categ_site,lati_site,longi_site,url_video,url_photo, description);
                listRetounee.add(newDataModel);

            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();

        return listRetounee;
    }

    public ArrayList<DataModel> recupereSite(String categorie){
        ArrayList<DataModel> listRenc = new ArrayList<>();

        String req = "SELECT * FROM "+TABLE_SITE+" WHERE "+CATEGORIE_SITE+"=\""+categorie+"\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(req, null);

        if(cursor.moveToFirst()){
            do {
                int id_site =cursor.getInt(0);
                String nom_site = cursor.getString(1);
                String categ_site = cursor.getString(2);
                double lati_site = cursor.getDouble(3);
                double longi_site = cursor.getDouble(4);
                String url_video = cursor.getString(5);
                int url_photo = cursor.getInt(6);
                String description = cursor.getString(7);

                DataModel newDataModel = new DataModel(id_site,nom_site,categ_site,lati_site,longi_site,url_video,url_photo, description);
                listRenc.add(newDataModel);

            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();

        return listRenc;

    }

    public ArrayList<DataModel> recupereSiteParId(int identifiant){
        ArrayList<DataModel> listSiteSelect = new ArrayList<>();

        String req = "SELECT * FROM "+TABLE_SITE+" WHERE "+ID+"=\""+identifiant+"\"";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(req, null);

        if(cursor.moveToFirst()){
            do {
                int id_site =cursor.getInt(0);
                String nom_site = cursor.getString(1);
                String categ_site = cursor.getString(2);
                double lati_site = cursor.getDouble(3);
                double longi_site = cursor.getDouble(4);
                String url_video = cursor.getString(5);
                int url_photo = cursor.getInt(6);
                String description = cursor.getString(7);

                DataModel newDataModel = new DataModel(id_site,nom_site,categ_site,lati_site,longi_site,url_video,url_photo, description);
                listSiteSelect.add(newDataModel);

            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();

        return listSiteSelect;

    }

    public ArrayList<DataModel> recupereMacth(int id){
        ArrayList<DataModel> listMatch = new ArrayList<>();

        String req = "SELECT * FROM "+TABLE_MATCH+" WHERE "+ID_ETRANGERE+"="+id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(req, null);

        if(cursor.moveToFirst()){
            do {
                int id_match =cursor.getInt(0);
                int id_etranger = cursor.getInt(1);
                String adversaires = cursor.getString(2);
                String niveau_match = cursor.getString(3);
                String dateMatch = cursor.getString(4);
                String heureMatch = cursor.getString(5);
                String url_videoMatch = cursor.getString(6);
                int url_photoMatch = cursor.getInt(7);
                String groupe = cursor.getString(8);

                DataModel newDataModel = new DataModel(id_match, id_etranger, adversaires, niveau_match, dateMatch, heureMatch, url_videoMatch, url_photoMatch, groupe);
                listMatch.add(newDataModel);

            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();

        return listMatch;

    }

    public ArrayList<DataModel> recupereUrgence(){
        ArrayList<DataModel> listUrgence = new ArrayList<>();

        String reqU = "SELECT * FROM "+TABLE_URGENCE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(reqU, null);

        if(cursor.moveToFirst()){
            do {
                int id_urg =cursor.getInt(0);
                int urg_img =cursor.getInt(1);
                String urg_nom = cursor.getString(2);
                String urg_tel = cursor.getString(3);

                DataModel newDataModel = new DataModel(id_urg, urg_img, urg_nom, urg_tel);
                listUrgence.add(newDataModel);
            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();

        return listUrgence;

    }
}
