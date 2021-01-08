package datakaryawan;

import java.util.Scanner;

public class Alamat extends DataString {
    private String inalamat;
    @Override
    String getData(){
        System.out.println("Alamat : ");
        Scanner in = new Scanner(System.in);
        return inalamat = in.nextLine();
    }
}
