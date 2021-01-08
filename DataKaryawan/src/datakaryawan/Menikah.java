package datakaryawan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menikah extends DataInt{
    private int in_menikah2;
    private String in_menikah;
    @Override
    int getInt() {
        int i = 0;
        while (i==0){
            System.out.println("Masukan Status Menikah (0 = blm menikah / 1 = sdh menikah: ");
            Scanner in = new Scanner(System.in);
            in_menikah = in.nextLine();
            Pattern p = Pattern.compile("[0-1]?"); //regex input untuk 0 / 1
            Matcher m = p.matcher(in_menikah);
            if (m.matches()) {
                in_menikah2 = Integer.parseInt(in_menikah);
                i = 1;
            } else {
                System.out.printf("format tidak cocok.");
                System.out.println("");
                i = 0;
            }
        }
        return this.in_menikah2;
    }
}
