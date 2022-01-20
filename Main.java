public class Main {
    public static void main(String[] args) {
        User user1= new User(2211,1111,200);
        User user2 = new User(2233,2222,100);
        User user3 = new User(3344,1234,50);
        User[] list = {user1,user2,user3};//list rekening

        //Validasi Rekening & PIN
        user1.ValidasiPIN();
        if(user1.pin_salah){
            return;
        }else{
            System.out.println("PIN BENAR!");
        }

        user1.Nabung(1);
        System.out.println("Nabung:"+user1.saldo);
        user1.Nabung(1);
        System.out.println("Nabung:"+user1.saldo);
        user1.Nabung(1);
        System.out.println("Nabung:"+user1.saldo);
        user1.Nabung(1);
        System.out.println("Nabung:"+user1.saldo);


        //Test Tarik Dana
        System.out.println("\nTarik");
        user1.Tarik(2);
        user1.Tarik(200);

        user1.Transfer(list);
        user1.Transfer(list);
        user1.Transfer(list);
        user1.Transfer(list);


        System.out.println("Saldo Akhir User 1: "+user1.saldo);
        System.out.println("Saldo Akhir User 2: "+user2.saldo);
        System.out.println("Saldo Akhir User 3: "+user3.saldo);
    }
}
