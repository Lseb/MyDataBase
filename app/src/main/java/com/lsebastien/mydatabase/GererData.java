package com.lsebastien.mydatabase;

//Cette classe est notre DAO. Elle maintient la connexion avec la base de données et prend en
// charge l'ajout des nouveaux commentaires et le retour de tous les commentaires.

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class GererData {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_AVATAR,MySQLiteHelper.COLUMN_DEADZONEYAW,MySQLiteHelper.COLUMN_DEADZONEPITCH,
            MySQLiteHelper.COLUMN_DEADZONEROLL,MySQLiteHelper.COLUMN_DEADZONEUPDOWN,MySQLiteHelper.COLUMN_GAINYAW,
            MySQLiteHelper.COLUMN_GAINPITCH,MySQLiteHelper.COLUMN_GAINROLL,MySQLiteHelper.COLUMN_GAINUPDOWN};



    public GererData(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }


    public void open() throws SQLiteException {
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            database = dbHelper.getReadableDatabase();
        }
    }

    public void close() {
        dbHelper.close();
    }

    public long insertData(Data data) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_AVATAR, data.getIdAvatar());
        values.put(MySQLiteHelper.COLUMN_DEADZONEYAW, data.getDeadzoneYaw());
        values.put(MySQLiteHelper.COLUMN_DEADZONEPITCH,data.getDeadzonePitch());
        values.put(MySQLiteHelper.COLUMN_DEADZONEROLL,data.getDeadzoneRoll());
        values.put(MySQLiteHelper.COLUMN_DEADZONEUPDOWN,data.getDeadzoneUpDown());
        values.put(MySQLiteHelper.COLUMN_GAINYAW,data.getGainYaw());
        values.put(MySQLiteHelper.COLUMN_GAINPITCH,data.getGainPitch());
        values.put(MySQLiteHelper.COLUMN_GAINROLL,data.getGainRoll());
        values.put(MySQLiteHelper.COLUMN_GAINUPDOWN,data.getGainUpDown());
        return database.insert(MySQLiteHelper.TABLE_DATAS, null,values);
    }

    public long updateData(int id, Data data) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_AVATAR, data.getIdAvatar());
        values.put(MySQLiteHelper.COLUMN_DEADZONEYAW, data.getDeadzoneYaw());
        values.put(MySQLiteHelper.COLUMN_DEADZONEPITCH,data.getDeadzonePitch());
        values.put(MySQLiteHelper.COLUMN_DEADZONEROLL,data.getDeadzoneRoll());
        values.put(MySQLiteHelper.COLUMN_DEADZONEUPDOWN,data.getDeadzoneUpDown());
        values.put(MySQLiteHelper.COLUMN_GAINYAW,data.getGainYaw());
        values.put(MySQLiteHelper.COLUMN_GAINPITCH,data.getGainPitch());
        values.put(MySQLiteHelper.COLUMN_GAINROLL,data.getGainRoll());
        values.put(MySQLiteHelper.COLUMN_GAINUPDOWN,data.getGainUpDown());
        return database.update(MySQLiteHelper.TABLE_DATAS,values,MySQLiteHelper.COLUMN_ID+"="+id,null);
    }

    public void deleteData(Data data) {
        int id = data.getId();
        database.delete(MySQLiteHelper.TABLE_DATAS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public Data getDataByUser(int idAvatar){
        Data data=new Data();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_DATAS,allColumns, MySQLiteHelper.COLUMN_AVATAR+ " = " + idAvatar,
                null, null, null, null);
        System.out.println(" avant");
        if(cursor!=null) {
            if(cursor.moveToFirst()){
                System.out.println("ok");
                int indexId=cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID);
                int indexAvatar=cursor.getColumnIndex(MySQLiteHelper.COLUMN_AVATAR);
                int indexDeadzoneYaw=cursor.getColumnIndex(MySQLiteHelper.COLUMN_DEADZONEYAW);
                int indexDeadzonePitch=cursor.getColumnIndex((MySQLiteHelper.COLUMN_DEADZONEPITCH));
                int indexDeadzoneRoll=cursor.getColumnIndex(MySQLiteHelper.COLUMN_DEADZONEROLL);
                int indexDeadzoneUpDown=cursor.getColumnIndex((MySQLiteHelper.COLUMN_DEADZONEUPDOWN));
                int indexGainYaw=cursor.getColumnIndex(MySQLiteHelper.COLUMN_GAINYAW);
                int indexGainPitch=cursor.getColumnIndex(MySQLiteHelper.COLUMN_GAINPITCH);
                int indexGainRoll=cursor.getColumnIndex((MySQLiteHelper.COLUMN_GAINROLL));
                int indexGainUpDown=cursor.getColumnIndex((MySQLiteHelper.COLUMN_GAINUPDOWN));

                int count=0;
                do {
                    data.setId(cursor.getInt(indexId));
                    data.setIdAvatar(cursor.getInt(indexAvatar));
                    data.setDeadzoneYaw(cursor.getString(indexDeadzoneYaw));
                    data.setDeadzonePitch(cursor.getString(indexDeadzonePitch));
                    data.setDeadzoneRoll(cursor.getString(indexDeadzoneRoll));
                    data.setDeadzoneUpDown(cursor.getString(indexDeadzoneUpDown));
                    data.setGainYaw(cursor.getString(indexGainYaw));
                    data.setGainPitch(cursor.getString(indexGainPitch));
                    data.setGainRoll(cursor.getString(indexGainRoll));
                    data.setGainUpDown(cursor.getString(indexGainUpDown));
                    count++;
                } while(cursor.moveToNext());
            }
            else {
                System.out.println("pas de donnée");
            }
        }
        System.out.println(" apres");
        cursor.close();
        return data;
    }

}