package datakaryawan;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class KodeKaryawan extends DataString {
    //atribut
    private String kode;
    String getData() {
        int i = 0;
        while (i == 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("Masukan Kode Karyawan : ");
            kode = in.nextLine();
            Pattern p = Pattern.compile("^[A-Z0-9]{5}$"); //regex input kode karyawan
            Matcher m = p.matcher(kode);
            if (m.matches()) {
                i =1;
            } else {
                //format tidak sesuai patern
                System.out.printf("format tidak cocok.", kode);
                System.out.println("");
                i = 0;
            }
        }
        return this.kode;
    }
}
