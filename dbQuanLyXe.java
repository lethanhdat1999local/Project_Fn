package tdc.edu.doanlaptrinhdidong2.ModulesDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.xemay;

import static android.content.ContentValues.TAG;

public class dbQuanLyXe {
    dbHelper dbHelper;
    public  dbQuanLyXe(){};
    public dbQuanLyXe(Context context){
        this.dbHelper = new dbHelper(context);
    }
    public void Them(xemay btv){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(dbTableNameXe.col_ten,btv.getTenxe());
        values.put(dbTableNameXe.col_soluongxe,btv.getDungtich());
        values.put(dbTableNameXe.dungtich,btv.getSoluong());
        values.put(dbTableNameXe.col_maloai,btv.getMaloai());
        db.insert(dbTableNameXe.table_tenxe,null,values);
        db.close();
        Log.d(TAG, "Them: du lieu thanh cong ");
    }
    public void  update(xemay btv ,int maxe ){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(dbTableNameXe.col_ten,btv.getTenxe());
            values.put(dbTableNameXe.dungtich,btv.getDungtich());
            values.put(dbTableNameXe.col_soluongxe,btv.getSoluong());
            values.put(dbTableNameXe.col_maloai,btv.getMaloai());
            db.update(dbTableNameXe.table_tenxe,values,dbTableNameXe.col_maxe + " = ?" ,new String[]{String.valueOf(maxe)});
    }
    public  void  xoa(int idxemay){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from " + dbTableNameXe.table_tenxe + " where id_xe = " + idxemay;
        db.execSQL(sql);
    }
    public ArrayList<xemay> layDuLieu(){
        ArrayList<xemay> data = new ArrayList<>();
        String sql=" select * from "+ dbTableNameXe.table_tenxe;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do{
                xemay xe = new xemay();
                xe.setMaxe(cursor.getInt(0));
                xe.setTenxe(cursor.getString(1));
                xe.setDungtich(cursor.getString(2));
                xe.setSoluong(cursor.getInt(3));
                xe.setMaloai(cursor.getInt(4));
                data.add(xe);
            }while (cursor.moveToNext());
        }
        return data;
    }
}
