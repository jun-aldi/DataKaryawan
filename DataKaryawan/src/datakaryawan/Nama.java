package datakaryawan;

import java.util.Scanner;


public class Nama extends DataString {
    private String innama;
    @Override
    String getData(){
        System.out.println("Masukan Nama Lengkap : ");
        Scanner in = new Scanner(System.in);
        return innama = in.nextLine();
    }

}
