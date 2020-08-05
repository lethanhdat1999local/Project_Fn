package tdc.edu.doanlaptrinhdidong2.ModulesDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    private  Context context;
    public dbHelper(Context context) {
        super(context, dbTableNameXe.db_name, null, dbTableNameXe.version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+ dbTableNameXe.table_tenxe+" ( "
                +dbTableNameXe.col_maxe + " integer primary key , "
                +dbTableNameXe.col_ten + " TEXT,"
                +dbTableNameXe.col_soluongxe + " integer, "
                +dbTableNameXe.dungtich + " TEXT, "
                + dbTableNameXe.col_maloai + " integer" +" )";
        String congty = "CREATE TABLE " + dbTableNameXe.table_congtyxe + " ( "
                + dbTableNameXe.col_maloai + " integer primary key , "
                +dbTableNameXe.col_tenloai + " TEXT ,"
                +dbTableNameXe.col_xuatxu + " TEXT )";
        String chitietdonhang = "CREATE TABLE " + dbTableNameXe.table_chitietdonhang + " ( "
                +dbTableNameXe.col_maDDH + " integer primary key , "
                +dbTableNameXe.col_maxe + " integer , "
                +dbTableNameXe.col_soluongdathang + " integer , "
                +dbTableNameXe.col_dongia + " integer , "
                + dbTableNameXe.col_ngaylap + " TEXT )";
        db.execSQL(sql);
        db.execSQL(congty);
        db.execSQL(chitietdonhang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
