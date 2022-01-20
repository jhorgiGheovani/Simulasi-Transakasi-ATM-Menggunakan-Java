import java.util.Objects;
import java.util.Scanner;
public class User{
    Integer saldo,PIN,rekening,itungTF=1;
    Boolean pin_salah = true;

    //Constraktor Untuk Mencata Data User
    public User(Integer rekening, Integer PIN, Integer saldo) {
        this.saldo = saldo;
        this.PIN = PIN;
        this.rekening = rekening;
    }

    //Tarik Uang
    public void Tarik(Integer n){
        if(saldo>=n){
            saldo -= n;
            System.out.println("Tarik Tunai Berhasil, Saldo Anda "+saldo);
        }else{
            System.out.println("Maaf Saldo Tidak Cukup!");
        }
    }

    //Deposit/Nabung
    public void Nabung(Integer nominal) {
        saldo=saldo+nominal;
        System.out.println("Setor Tunai Berhasil, Saldo Anda "+saldo);
    }

    //Validasi PIN
    public void ValidasiPIN() {
        for(int passAttempts = 0; passAttempts < 3 && pin_salah; passAttempts++){
            System.out.print("Masukan PIN:");
            Scanner sc= new Scanner(System.in);
            int input= sc.nextInt();
            if(input!=PIN){
                if(passAttempts<2){
                System.out.println("PIN SALAH COBA LAGI!\n");
                }else{
                    System.out.println("ATM Diblokir");
                }
            }else {
                pin_salah=false;
            }
        }
    }

    //TRANSFER
    public void Transfer(User[] list) {
        boolean cek = true;
        System.out.print("Masukan Rekening:");
        Scanner sc= new Scanner(System.in);
        int rektujuan = sc.nextInt();
        System.out.print("Masukan Nominal:");
        Scanner sc2= new Scanner(System.in);
        Integer nominal = sc2.nextInt();

        for (User user : list) {
            if (user.rekening.equals(rektujuan)) {
                if (Objects.equals(user.rekening, this.rekening)) {
                    System.out.println("Tidak Dapat Transfer ke Rekening Sendiri");
                }else if (this.saldo < nominal||this.saldo<0) {
                    System.out.println("Maaf, Saldo Tidak Cukup! Saldo "+saldo);
                }else if (rektujuan / 100 != 22) {
                    itungTF = itungTF + 1;
                    if (itungTF % 5 == 0) {
                        this.saldo = this.saldo - nominal - 2;
                        System.out.println("Transfer Berhasil!,Yee Kamu Dapet Diskon!,Fee:2 Saldo:"+saldo);
                    } else {
                        this.saldo = this.saldo - nominal - 4;
                        System.out.println("Transfer Berhasil!, Fee:4 Saldo:"+saldo);
                    }
                    user.saldo = user.saldo + nominal;
                }else {
                    this.saldo -= nominal;
                    System.out.println("Transfer Berhasil! Saldo Anda "+saldo);
                    itungTF = itungTF + 1;
                    System.out.println(itungTF);
                    user.saldo = user.saldo + nominal;
                }
                cek = false;
            }
        }
        if(cek){
            System.out.println("Rekening Salah!");
        }
    }

}
