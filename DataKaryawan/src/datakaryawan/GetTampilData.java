package datakaryawan;

public class GetTampilData extends DataString{
    @Override
    String getData() {
        DataString kode = new KodeKaryawan();
        return kode.getData();
    }
}
