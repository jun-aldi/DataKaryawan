package datakaryawan;


import java.util.Date;


public class Usia {

    private Date tgl;
    //constructor
    public Usia(Date tmp_tgl) {
        this.tgl=tmp_tgl;
    }
    //hitung usia
    int getUsia() {
        Date lahir = tgl;
        Date kini = new Date();
        int umur = kini.getYear()-lahir.getYear();
        return umur;

    }

}
