package datakaryawan;

public class Hapus extends DataHapus {
    @Override
    String getData() {
        DataString kode = new KodeKaryawan();
        return kode.getData();
    }
}
