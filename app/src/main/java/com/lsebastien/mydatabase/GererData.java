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
        database = dbHelper.getWritableDatabase();
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
        System.out.println("Comment deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_DATAS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public Data getAllDataByUser(int idAvatar){
        Data data=new Data();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_DATAS,
                allColumns, MySQLiteHelper.COLUMN_AVATAR+ " = " + idAvatar,
                null, null, null, null);
        data.setId(cursor.getInt(0));
        data.setIdAvatar(cursor.getString(1));
        data.setDeadzoneYaw(cursor.getString(2));
        data.setDeadzonePitch(cursor.getString(3));
        data.setDeadzoneRoll(cursor.getString(4));
        data.setDeadzoneUpDown(cursor.getString(5));
        data.setGainYaw(cursor.getString(6));
        data.setGainPitch(cursor.getString(7));
        data.setGainRoll(cursor.getString(8));
        data.setGainUpDown(cursor.getString(9));
        cursor.close();
        // assurez-vous de la fermeture du curseur

        return data;
    }

}