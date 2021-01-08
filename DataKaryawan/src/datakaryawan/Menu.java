package datakaryawan;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    //arrraylist
    ArrayList<String> datanama = new ArrayList<String>();
    ArrayList<String> datakaryawan = new ArrayList<String>();
    ArrayList<String> dataalamat = new ArrayList<String>();
    ArrayList<Date> datatgl = new ArrayList<Date>();
    ArrayList<String> datagolongan = new ArrayList<String>();
    ArrayList<Integer> datamenikah = new ArrayList<Integer>();
    ArrayList<Integer> dataanak = new ArrayList<Integer>();


    public void menu() {
        System.out.println("");
        System.out.println("----------");
        System.out.println("Menu");
        System.out.println("----------");
        System.out.println("1. Tambah Data");
        System.out.println("2. Hapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Tampil Data");
        System.out.println("5. Keluar");
        Scanner in = new Scanner(System.in);
        System.out.print("Pilih no menu : ");
        String menu = in.nextLine();
        System.out.println("");
        //pilih menu
        switch (menu) {
            case "1":
                System.out.println("--TAMBAH DATA--");
                tambahData();
                menu();
                break;
            case "2":
                System.out.println("--HAPUS DATA--");
                hapusData();
                menu();
            case "3":
                System.out.println("--CARI DATA--");
                cariData();
                break;
            case "4":
                System.out.println("--TAMPIL DATA--");
                tampilData();
                break;
            case "5":
                System.exit(0);
                default: menu();

        }

    }
    public void tambahData(){
        //pembuatan objek
        DataString nama = new Nama();
        DataString kode = new KodeKaryawan();
        DataString alamat = new Alamat();
        DataDate   ttl =new Ttl();
        DataString  gol = new Golongan();
        DataInt menikah = new Menikah();
        DataInt anak = new Anak();

        //tambah data karyawan
        int i = 0;
        while (i == 0){
            String tmp = new String(kode.getData());
            if (datakaryawan.contains(tmp)){
                System.out.println("Telah digunakan");
                i = 0;
            } else{
                datakaryawan.add(tmp);
                i = 1;
            }
        }
        //tambah data ke arraylist
        datanama.add(nama.getData());
        dataalamat.add(alamat.getData());
        datatgl.add(ttl.getDate());
        datagolongan.add(gol.getData());
        int tmp = menikah.getInt();
        datamenikah.add(tmp);
        if (tmp==1){
            dataanak.add(anak.getInt());
        }
        else {
            dataanak.add(0);
        }
    }

    public void hapusData(){
        DataHapus del = new Hapus();
        int i = 0;
        //perulanagn untuk menemukan data yang dicari
        while (i ==0){
            String tmp = new String(del.getData());
            int index_look = datakaryawan.indexOf(tmp);
            if(index_look == -1){
                System.out.println(tmp+" Tidak Ditemukan");
                i = 0;
            }else{
                System.out.println("Data Karyawan "+tmp+" Telah dihapus !");
                //penghapusan data di arrayList
               datakaryawan.remove(index_look);
               dataanak.remove(index_look);
               datamenikah.remove(index_look);
               datatgl.remove(index_look);
               dataalamat.remove(index_look);
               datanama.remove((index_look));
               datagolongan.remove(index_look);
               i= 1;
            }
        }
        //SubMenu
        System.out.println("");
        DataInt submenu = new SubMenuHapus();
        int tmp = new Integer(submenu.getInt());
        System.out.println("");
        if (tmp ==1){
            menu();
        }
        else {
            hapusData();
        }

    }
    public void cariData(){
        //atribut bersifat default
        int tmp_anak = 0;
        int index_look,gaji_kotor = 0;
        double tunjanganpsgn=0,tunjanganpegawai = 0,tunjangananak = 0,potongan=0,gajibersih;
        DataString cari = new GetTampilData();
        int i = 0;
        //perulangan dalam menemukan data
        while (i ==0){
            String tmp;
            tmp = new String(cari.getData());
            index_look = datakaryawan.indexOf(tmp);
            if(index_look == -1){
                System.out.println(tmp+" Tidak Ditemukan");
                i = 0;
            }
            //jika ditemukan data di dalam arraylist
            else{
                System.out.println("");
                System.out.println("======================+");
                System.out.println("Data Profile Karyawan");
                System.out.println("-----------------------");
                System.out.println("Kode Karyawan         : "+tmp);
                System.out.println("Nama Karyawan         : "+datanama.get(index_look));
                System.out.println("Golongan              : "+datagolongan.get(index_look));
                //usia
                Date tmp_tgl = datatgl.get(index_look);
                Usia date = new Usia(tmp_tgl);
                int tmp_umur = date.getUsia();
                System.out.println("Umur                  : "+tmp_umur);
                //menikah
                String menikah_str1 = Integer.toString(datamenikah.get(index_look));
                if (menikah_str1.equals("0")){
                    String menikahReplaceString2=menikah_str1.replaceFirst("0(.*)","Belum Menikah");
                    System.out.println("Status                : "+menikahReplaceString2);
                }else{
                    String menikahReplaceString2=menikah_str1.replaceFirst("1(.*)","Menikah");
                    System.out.println("Status                : "+menikahReplaceString2);
                }
                if (menikah_str1.equals("1")){
                    tmp_anak=dataanak.get(index_look);
                    System.out.println("Anak                  : "+tmp_anak);
                }
                System.out.println("--------------------------------------------------");
                String tmp_gol= datagolongan.get(index_look);

                //Gaji
                Gaji gaji = new Gaji(tmp_gol, tmp_anak, tmp_anak, tunjangananak, tunjanganpegawai, tunjanganpsgn,gaji_kotor, potongan);
                int gajipokok = (int) gaji.gajiPokok();
                System.out.println("Gaji Pokok            : Rp "+gajipokok);
                if (menikah_str1.equals("1")){
                    tunjanganpsgn = gaji.tunjanganpsgn();
                    System.out.println("Tunjangan Istri/Suami : Rp "+(int)tunjanganpsgn);
                }
                if (tmp_umur>30){
                    tunjanganpegawai= gaji.tunjanganpegawai();
                    System.out.println("Tunjangan Pegawai     : Rp "+(int)tunjanganpegawai);
                }
                if (menikah_str1.equals("1")&tmp_anak>0){
                    tunjangananak= gaji.tunjungananak();
                    System.out.println("Tunjangan Anak        : Rp "+(int)tunjangananak);
                }
                Gaji gaji2 = new Gaji(tmp_gol,tmp_anak,gajipokok,tunjangananak,tunjanganpegawai,tunjanganpsgn,gaji_kotor,potongan);
                System.out.println("-------------------------------------------------- +");
                gaji_kotor= (int) gaji2.gajikotor();
                System.out.println("Gaji Kotor            : Rp "+(int) gaji_kotor);
                i= 1;
                Gaji gaji3 = new Gaji(tmp_gol,tmp_anak,gajipokok,tunjangananak,tunjanganpegawai,tunjanganpsgn,gaji_kotor,potongan);
                potongan = gaji3.potongan();
                System.out.println("Potongan              : Rp "+ (int) potongan);
                Gaji gaji4 = new Gaji(tmp_gol,tmp_anak,gajipokok,tunjangananak,tunjanganpegawai,tunjanganpsgn,gaji_kotor,potongan);
                System.out.println("-------------------------------------------------- -");
                gajibersih = gaji4.gajibersih();
                System.out.println("Gaji Bersih           : Rp "+(int) gajibersih);
                System.out.println("");
                i = 1;
            }
        }
        //submenu
        DataInt submenu = new SubMenuTampil();
        int tmp = new Integer(submenu.getInt());
        System.out.println("");
        if (tmp ==1){
            menu();
        }

    }


    public void tampilData(){

        System.out.println("===============================================================================================================================");
        System.out.println("DATA KARYAWAN");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        int i;
        String menikahReplaceString2;
        //format tabel
        String format = "%1$-12s%2$-40s%3$-5s%4$-7s%5$-20s%6$-13s\n";
        System.out.format(format, "KODE KARY","NAMA KARY", "GOL", "USIA", "STATUS NIKAH","JUMLAH ANAK");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        //perulanagn setiap arraylist
        for (i = 0; i < datakaryawan.size(); i++){
            //umur
            Date tmp_tgl = datatgl.get(i);
            Usia date = new Usia(tmp_tgl);
            int tmp_umur = date.getUsia();
            //status menikah
            String menikah_str1 = Integer.toString(datamenikah.get(i));
            if (menikah_str1.equals("0")){
                menikahReplaceString2=menikah_str1.replaceFirst("0(.*)","Belum Menikah");
            }else{
                menikahReplaceString2=menikah_str1.replaceFirst("1(.*)","Menikah");
            }
            System.out.format(format, datakaryawan.get(i), datanama.get(i),datagolongan.get(i),tmp_umur,menikahReplaceString2,dataanak.get(i));
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        //jumlah data
        System.out.println("Jumlah Data  : "+datakaryawan.size());
        System.out.println("");

        //SubMenu
        DataInt submenu = new SubMenuTampil();
        int tmp = new Integer(submenu.getInt());
        System.out.println("");
        if (tmp ==1){
            menu();
        }
    }

}
