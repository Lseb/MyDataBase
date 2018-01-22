package com.lsebastien.mydatabase;

//Cette classe se charge de la création de la base de données. La méthode onUpgrade() va simplement
// supprimer toutes les données existantes et recréer la table. Elle définit également plusieurs
// constantes pour le nom et les colonnes de la table.

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_DATAS = "datas";
    public static final String COLUMN_ID ="_id";
    public static final String COLUMN_AVATAR = "idAvatar";
    public static final String COLUMN_DEADZONEYAW = "deadzoneYaw";
    public static final String COLUMN_DEADZONEPITCH = "deadzonePitch";
    public static final String COLUMN_DEADZONEROLL = "deadzoneRoll";
    public static final String COLUMN_DEADZONEUPDOWN= "deadzoneUpDown";
    public static final String COLUMN_GAINYAW = "gainYaw";
    public static final String COLUMN_GAINPITCH = "gainPitch";
    public static final String COLUMN_GAINROLL = "gainRoll";
    public static final String COLUMN_GAINUPDOWN = "gainUpDown";

    public static final String DATABASE_NAME = "data.db";
    public static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_DATAS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_AVATAR
            + " text not null,"+COLUMN_DEADZONEYAW+"text not null,"+COLUMN_DEADZONEPITCH+"text not null,"
            +COLUMN_DEADZONEROLL+"text not null,"+COLUMN_DEADZONEUPDOWN+"text not null,"
            +COLUMN_GAINYAW+"text not null"+COLUMN_GAINPITCH+"text not null"
            +COLUMN_GAINROLL+"text not null"+COLUMN_GAINUPDOWN+"text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATAS);
        onCreate(db);
    }
}