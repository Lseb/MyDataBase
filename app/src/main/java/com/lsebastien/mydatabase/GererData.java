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

public class GererData {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NIVEAU,MySQLiteHelper.COLUMN_AXE,MySQLiteHelper.COLUMN_DEADZONE,MySQLiteHelper.COLUMN_GAIN };

    public GererData(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Data createData(Data data) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NIVEAU, data.getNiveau());
        values.put(MySQLiteHelper.COLUMN_AXE, data.getAxe());
        values.put(MySQLiteHelper.COLUMN_DEADZONE,data.getDeadzone());
        values.put(MySQLiteHelper.COLUMN_GAIN,data.getGain());
        long insertId = database.insert(MySQLiteHelper.TABLE_DATAS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_DATAS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Data newData = cursorToData(cursor);
        cursor.close();
        return newData;
    }

    public void deleteData(Data data) {
        int id = data.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_DATAS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }
    /*
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<Comment>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return comments;
    }
    */
    private Data cursorToData(Cursor cursor) {
        Data data = new Data();
        data.setId(cursor.getInt(0));
        data.setNiveau(cursor.getString(1));
        data.setAxe(cursor.getString(2));
        data.setDeadzone(cursor.getString(3));
        data.setGain(cursor.getString(4));
        return data;
    }
}