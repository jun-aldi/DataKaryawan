package datakaryawan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ttl extends DataDate {
    private Date date;
    @Override
    Date getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //format tanggal yang dipakai (tahun-bulan-hari) contoh : 2000-01-01
        Scanner sc = new Scanner(System.in);
        //cek inputan sesuai patern
        int i=0;
        while (i==0){
            System.out.println("Masukan Tanggal Lahir (yyyy-mm-dd): ");
            String str = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$");         //regex input untuk tanggal
            Matcher m = p.matcher(str);
            if (m.matches()) {     //jika sesuai patern
                try {
                    date = sdf.parse(str);
                    i=1;
                } catch (ParseException e) {
                    System.out.println("Format Tanggal salah");// jika format tanggal
                    i = 0;
                }
                i = 1;
            } else {
                System.out.printf("Format tidak cocok"); //format input tidak sesuai
                System.out.println("");
            }
        }

        return date;
    }
}
