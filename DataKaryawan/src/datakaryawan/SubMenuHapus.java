package datakaryawan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubMenuHapus extends DataInt{
   //atribut bersifat private
    private String in_submenu;
    private int in_submenu_str;
    @Override
    int getInt() {
        int i =0;
        while (i==0){
            System.out.println("Pilih SubMenu : ");
            System.out.println("1. Kembali ke Menu");
            System.out.println("2. Ulangi Hapus Data");
            System.out.print("Menu Pilihan : ");
            Scanner in = new Scanner(System.in);
            in_submenu = in.nextLine();
            Pattern p = Pattern.compile("[1-2]?"); //regex input untuk 1/2
            Matcher m = p.matcher(in_submenu);
            //format sesuai
            if (m.matches()) {
                in_submenu_str = Integer.parseInt(in_submenu);
                i = 1;
            }
            //format tidak sesuai
            else {
                System.out.printf("format tidak cocok.");
                System.out.println("");
                i = 0;
            }
        }
        return this.in_submenu_str;
    }
}
