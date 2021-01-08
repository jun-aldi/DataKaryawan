package datakaryawan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Golongan extends DataString{
    //atribut
    private String ingol;
    @Override
    String getData() {
        int i = 0;
        while (i == 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("Masukan Golongan (A/B/C/D) : ");
            ingol = in.nextLine();
            Pattern p = Pattern.compile("^[ABCD]{1}$"); //regex input golongan karyawan
            Matcher m = p.matcher(ingol);
            if (m.matches()) {
                i =1;
            } else {
                //format tidak sesuai patern
                System.out.printf("format tidak cocok.", ingol);
                System.out.println("");
                i = 0;
            }
        }
        return this.ingol;
    }
}
