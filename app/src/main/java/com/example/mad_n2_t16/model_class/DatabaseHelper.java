package com.example.mad_n2_t16.model_class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

public final class DatabaseHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "dbEnglishExam";
        private static final String ID = "id";
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
            Log.d("DB Manager", "DB Manager");

            this.context = context;
        }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQueryTK = "CREATE TABLE " + "tbltaikhoan" + " (" +
                ID + " integer primary key, " +
                "taiKhoan" + " TEXT, " +
                "matKhau" + " TEXT, " +
                "maHS INTEGER," +
                "hoTen" + " TEXT," +
                "FOREIGN KEY (maHS) REFERENCES tblhocsinh (id))";
        String sqlQueryHS = "CREATE TABLE " + "tblhocsinh" + " (" +
                ID + " integer primary key, " +
                "ngaySinh" + " TEXT, " +
                "email" + " TEXT, " +
                "diachi" + " TEXT)";
        db.execSQL(sqlQueryTK);
        db.execSQL(sqlQueryHS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbltaikhoan");
        db.execSQL("DROP TABLE IF EXISTS tblhocsinh");
        onCreate(db);
    }
    // Tai khoan
    public taikhoan getTaiKhoanByTK(String nameTK) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tbltaikhoan WHERE taiKhoan=?";
        String[] selectionArgs = {String.valueOf(nameTK)};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        taikhoan temp = new taikhoan();
        if (cursor.moveToNext()) {
            temp.setId(cursor.getInt(0));
            temp.setTaiKhoan(cursor.getString(1));
            temp.setMatKhau(cursor.getString(2));
            temp.setHoTen(cursor.getString(5));
        }
        cursor.close();
        db.close();
        return temp;
    }
    public void createTaiKhoan(taikhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("taiKhoan", taiKhoan.getTaiKhoan());
        values.put("matKhau", taiKhoan.getMatKhau());
        values.put("hoTen", taiKhoan.getHoTen());
        //Neu de null thi khi value bang null thi loi
        db.insert("tbltaikhoan",null,values);
//        }
        db.close();
    }
    public void addTK() {

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM tblhocsinh";
        Cursor cursor = db.rawQuery(query, null);
        int t = cursor.getCount();


        //Neu de null thi khi value bang null thi loi
        db.close();
    }
    public taikhoan getTaiKhoanByUserNameAndPassWord(String userName, String passWord) {
        taikhoan taiKhoan = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tbltaikhoan " +
                "WHERE tbltaikhoan.taiKhoan =? AND tbltaikhoan.matKhau =?";
        String[] selectionArgs = {userName, passWord};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            taiKhoan = new taikhoan();
            taiKhoan.setId(cursor.getInt(0));
            taiKhoan.setTaiKhoan(cursor.getString(1));
            taiKhoan.setMatKhau(cursor.getString(2));
        }
        return taiKhoan;
    }
    public hocsinh getHocSinh(taikhoan taiKhoan) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT tblhocsinh.id, tblhocsinh.ngaySinh, tblhocsinh.email, tblhocsinh.diachi, tbltaikhoan.hoTen" +
                " FROM tblhocsinh inner join " +
                "tbltaikhoan on tbltaikhoan.maHS = tblhocsinh.id " +
                "WHERE tbltaikhoan.id=?";
        String[] selectionArgs = {String.valueOf(taiKhoan.getId())};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        hocsinh temp = new hocsinh();
        if (cursor.moveToFirst()) {
            do {
                temp.setIdHS(cursor.getInt(0));
                temp.setNgaySinh(cursor.getString(1));
                temp.setEmail(cursor.getString(2));
                temp.setAddress(cursor.getString(3));
//                temp.setHoTen(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return temp;
    }

    public boolean checkTaiKhoanByUsername(String username) {
        boolean result = true;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM tbltaikhoan " +
                "WHERE tbltaikhoan.taiKhoan =?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if (cursor.moveToFirst()) {
            result = false;
        }
        return result;
    }

    public void addHS(hocsinh hs) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO tblhocsinh ( ngaySinh, email, diachi) VALUES " +
                "(?, ?, ?)";
        String[] selectionArgs = {null, null, null};
        db.execSQL(query, selectionArgs);
    }

    public void addTaiKhoan(taikhoan taiKhoan, int idHS) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO tbltaikhoan (taiKhoan, matKhau, hoTen, maHS) VALUES " +
                "(?, ?, ?, ?)";
        String[] selectionArgs = {taiKhoan.getTaiKhoan(), taiKhoan.getMatKhau(), taiKhoan.getHoTen(),
                idHS + ""};
        db.execSQL(query, selectionArgs);
    }
}
