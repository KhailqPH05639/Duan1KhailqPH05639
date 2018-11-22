package com.vn.khai.duan1khailqph05639.common;

import java.net.PortUnreachableException;

public class Contants {

    public final static boolean isDEBUG=true;

    public final static String DANHSACH_ID = "id";
    public final static String DANHSACH_TEN = "ten";
    public final static String DANHSACH_CHUCVU = "chucvu";
    public final static String DANHSACH_TUOI = "tuoi";
    public final static String DANHSACH_NGAYSINH = "ngaysinh";
    public final static String DANHSACH_GIATRI = "giatri";
    public final static String DANHSACH_GIOITINH = "gioitinh";
    public final static String DANHSACH_TINHTRANG = "tinhtrang";
    public final static String DANHSACH_QUOCTICH = "quoctich";
    public final static String DANHSACH_TABLE = "danhsach";


    public final static String CREATE_DANHSACH_TABLE = "CREATE TABLE " + DANHSACH_TABLE + " (" +
            "" + DANHSACH_ID + " TEXT PRIMARY KEY ," +
            "" + DANHSACH_TEN + " TEXT ," +
            "" + DANHSACH_CHUCVU + " TEXT ," +
            "" + DANHSACH_TUOI + " INTEGER ," +
            "" + DANHSACH_NGAYSINH + " DATE," +
            "" + DANHSACH_GIATRI + " DOUBLE ," +
            "" + DANHSACH_GIOITINH + " TEXT, " +
            "" + DANHSACH_TINHTRANG + " TEXT, " +
            "" + DANHSACH_QUOCTICH + " TETX " +
            ")";


    public final static String LINEAB_ID = "id";
    public final static String LINEAB_VITRI = "vitri";
    public final static String LINEAB_TEN = "ten";
    public final static String LINEAB_SOAO = "soao";
    public final static String LINEAB_CHISO = "chiso";
    public final static String LINEAB_TABLE = "lineab";

    public final static String CREATE_LINEAB_TABLE = " CREATE TABLE " + LINEAB_TABLE + " (" +
            "" + LINEAB_ID + " TEXT PRIMARY KEY ," +
            "" + LINEAB_TEN + " TEXT ," +
            "" + LINEAB_CHISO + " INTEGER ," +
            "" + LINEAB_SOAO + " INTEGER ," +
            "" + LINEAB_VITRI + " TEXT " +
            ")";


    public final static String LINEB_ID = "id";
    public final static String LINEB_VITRI = "vitri";
    public final static String LINEB_TEN = "ten";
    public final static String LINEB_SOAO = "soao";
    public final static String LINEB_CHISO = "chiso";
    public final static String LINEB_TABLE = "lineb";

    public final static String CREATE_LINEB_TABLE = " CREATE TABLE " + LINEB_TABLE + " (" +
            "" + LINEB_ID + " TEXT PRIMARY KEY ," +
            "" + LINEB_TEN + " TEXT ," +
            "" + LINEB_CHISO + " INTEGER ," +
            "" + LINEB_SOAO + " INTEGER ," +
            "" + LINEB_VITRI + " TEXT " +
            ")";
}
