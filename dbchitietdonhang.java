package tdc.edu.doanlaptrinhdidong2.ModulesDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.chitietdonhang;
import tdc.edu.doanlaptrinhdidong2.ModulesClass.congtyxe;

public class dbchitietdonhang {
    dbHelper dbHelper;

    public dbchitietdonhang() {
    }

    public dbchitietdonhang(Context context) {
        this.dbHelper = new dbHelper(context);
    }
    public void Them(chitietdonhang btv){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbTableNameXe.col_maxe,btv.getMaxe());
        values.put(dbTableNameXe.col_soluongdathang,btv.getSoluongdonhang());
        values.put(dbTableNameXe.col_dongia,btv.getDongia());
        values.put(dbTableNameXe.col_ngaylap,btv.getNgaylap());
        db.insert(dbTableNameXe.table_chitietdonhang,null,values);
        db.close();
        Log.d("them thanh cong", "Them: du lieu thanh cong ");
    }
    public ArrayList<chitietdonhang> layDuLieu() {
        ArrayList<chitietdonhang> data = new ArrayList<>();
        String sql = " select * from " + dbTableNameXe.table_chitietdonhang;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                chitietdonhang xe = new chitietdonhang();
                xe.setMadonhang(cursor.getInt(0));
                xe.setMaxe(cursor.getInt(1));
                xe.setSoluongdonhang(cursor.getInt(2));
                xe.setDongia(cursor.getInt(3));
                xe.setNgaylap(cursor.getString(4));
                data.add(xe);
            } while (cursor.moveToNext());
        }
        return data;
    }
    public  void  xoa(int mahoadon){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = " delete from " + dbTableNameXe.table_chitietdonhang + " where ma_DDH = " + mahoadon;
        db.execSQL(sql);
    }
    public void  update(chitietdonhang chitietdonhang , int maHD){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbTableNameXe.col_maxe,chitietdonhang.getMaxe());
        values.put(dbTableNameXe.col_soluongdathang,chitietdonhang.getSoluongdonhang());
        values.put(dbTableNameXe.col_dongia,chitietdonhang.getDongia());
        values.put(dbTableNameXe.col_ngaylap,chitietdonhang.getNgaylap());
        db.update(dbTableNameXe.table_chitietdonhang,values,dbTableNameXe.col_maDDH + " = ?" ,new String[]{String.valueOf(maHD)});
        Log.d("qua trinh", "update: thanh cong");
    }
    public ArrayList<chitietdonhang> timkiemdonhang(int key) {
        ArrayList<chitietdonhang> data = new ArrayList<>();
        String sql = " select * from " + dbTableNameXe.table_chitietdonhang + " where id_xe like '%" + key + "%'" ;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                chitietdonhang xe = new chitietdonhang();
                xe.setMadonhang(cursor.getInt(0));
                xe.setMaxe(cursor.getInt(1));
                xe.setSoluongdonhang(cursor.getInt(2));
                xe.setDongia(cursor.getInt(3));
                xe.setNgaylap(cursor.getString(4));
                data.add(xe);
            } while (cursor.moveToNext());
        }
        return data;
    }
}
