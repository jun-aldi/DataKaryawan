package datakaryawan;

public class Gaji {
    //atribut bersifat private
    private String gol;
    private int gajipokok,anak,gp1,gjktr1;
    private double tunjangan1,tunjangan2,tunjangan3,ta1,tpg1,tpgsn1,ptgn;
    //constructor
    public Gaji(String tmp_gol, int tmp_anak, int gajipokok, double tunjangananak, double tunjanganpegawai, double tunjanganpsgn, int gajikotor, double potongan) {
        this.gol=tmp_gol;
        this.anak=tmp_anak;

        this.gp1=gajipokok;
        this.ta1=tunjangananak;
        this.tpg1=tunjanganpegawai;
        this.tpgsn1=tunjanganpsgn;
        this.gjktr1=gajikotor;
        this.ptgn=potongan;
    }

    double gajiPokok(){
        if (gol.equals("A")){
            gajipokok = 5000000;
        }
        if (gol.equals("B")){
            gajipokok = 6000000;
        }
        if (gol.equals("C")){
            gajipokok = 7000000;
        }
        if (gol.equals("D")){
            gajipokok = 8000000;
        }
        return gajipokok;
    }

    double tunjanganpsgn(){
        if (gol.equals("A")){
            gajipokok = 5000000;
            tunjangan1 = gajipokok*0.1;
        }
        if (gol.equals("B")){
            gajipokok = 6000000;
            tunjangan1 = gajipokok*0.1;
        }
        if (gol.equals("C")){
            gajipokok = 7000000;
            tunjangan1 = gajipokok*0.1;
        }
        if (gol.equals("D")){
            gajipokok = 8000000;
            tunjangan1 = gajipokok*0.1;
        }
        return tunjangan1;
    }

    double tunjanganpegawai(){
        if (gol.equals("A")){
            gajipokok = 5000000;
            tunjangan2 = gajipokok*0.15;
        }
        if (gol.equals("B")){
            gajipokok = 6000000;
            tunjangan2 = gajipokok*0.15;
        }
        if (gol.equals("C")){
            gajipokok = 7000000;
            tunjangan2 = gajipokok*0.15;
        }
        if (gol.equals("D")){
            gajipokok = 8000000;
            tunjangan2 = gajipokok*0.15;
        }
        return tunjangan2;
    }

    double tunjungananak(){
        double per = anak*0.05;
        if (gol.equals("A")){
            gajipokok = 5000000;
            tunjangan3 = gajipokok*per;
        }
        if (gol.equals("B")){
            gajipokok = 6000000;
            tunjangan3 = gajipokok*per;
        }
        if (gol.equals("C")){
            gajipokok = 7000000;
            tunjangan3 = gajipokok*per;
        }
        if (gol.equals("D")){
            gajipokok = 8000000;
            tunjangan3 = gajipokok*per;
        }
        return tunjangan3;
    }

    double gajikotor(){
        int gajikotor= (int) (gp1 + tpg1 +tpgsn1 +ta1);
        return gajikotor;
    }

    double potongan(){
        int potongangaji = (int) (gjktr1*0.025);
        return potongangaji;
    }

    double gajibersih(){
        double gajibersih = gjktr1-ptgn;
        return gajibersih;
    }



}
