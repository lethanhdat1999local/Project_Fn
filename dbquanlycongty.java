package tdc.edu.doanlaptrinhdidong2.ModulesDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.congtyxe;

public class dbquanlycongty {
    dbHelper dbHelper;

    public dbquanlycongty() {
    }
    public dbquanlycongty(Context context){
        this.dbHelper = new dbHelper(context);
    }
    public void Them(congtyxe btv){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbTableNameXe.col_tenloai,btv.getTenloai());
        values.put(dbTableNameXe.col_xuatxu,btv.getXuatxu());
        db.insert(dbTableNameXe.table_congtyxe,null,values);
        db.close();
        Log.d("them thanh cong", "Them: du lieu thanh cong ");
    }
    public ArrayList<congtyxe> layDuLieu() {
        ArrayList<congtyxe> data = new ArrayList<>();
        String sql = " select * from " + dbTableNameXe.table_congtyxe;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                congtyxe xe = new congtyxe();
                xe.setMaloai(cursor.getInt(0));
                xe.setTenloai(cursor.getString(1));
                xe.setXuatxu(cursor.getString(2));
                data.add(xe);
            } while (cursor.moveToNext());
        }
        return data;
    }
    public  void  xoa(int idcongty){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from " + dbTableNameXe.table_congtyxe + " where ma_loai = " + idcongty;
        db.execSQL(sql);
    }
    public void  update(congtyxe congtyxe , int maxe){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbTableNameXe.col_tenloai,congtyxe.getTenloai());
        values.put(dbTableNameXe.col_xuatxu,congtyxe.getXuatxu());
        db.update(dbTableNameXe.table_congtyxe,values,dbTableNameXe.col_maloai + " = ?" ,new String[]{String.valueOf(maxe)});
        Log.d("qua trinh", "update: thanh cong");
    }
    public ArrayList<congtyxe> timkiem(String key) {
        ArrayList<congtyxe> data = new ArrayList<>();
        String sql = " select * from " + dbTableNameXe.table_congtyxe + " where Ten_loai like '%" + key + "%'" ;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                congtyxe xe = new congtyxe();
                xe.setMaloai(cursor.getInt(0));
                xe.setTenloai(cursor.getString(1));
                xe.setXuatxu(cursor.getString(2));
                data.add(xe);
            } while (cursor.moveToNext());
        }
        Log.d("TAG", "timkiem: da tim kiem");
        return data;
    }
}
