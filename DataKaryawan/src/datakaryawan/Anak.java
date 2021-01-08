package datakaryawan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anak extends DataInt{
    private String in_anak;
    private int jumlah_anak;
    @Override
    int getInt() {
        int i = 0;
        while (i==0){
            System.out.println("Masukan Jumlah Anak: ");
            Scanner in = new Scanner(System.in);
            in_anak = in.nextLine();
            Pattern p = Pattern.compile("^[0-9]{1,2}$"); //regex input untuk jumlah anak
            Matcher m = p.matcher(in_anak);
            //jika sesuai regex
            if (m.matches()) {
                jumlah_anak = Integer.parseInt(in_anak);
                i = 1;
            }
            //jika tidak sesuai
            else {
                System.out.printf("format tidak cocok.");
                i = 0;
            }
        }
        return this.jumlah_anak;
    }
}
