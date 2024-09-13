import java.util.Scanner;

class TicketMachine{
    private int price;
    private int balance;
    private int total;

    public TicketMachine(int Hargatiket){
        this.price = Hargatiket;
        this.balance = 0;
        this.total = 0;
    }

    public int getBalance() {
        return balance;
      }
    
      public int getPrice() {
        return price;
      }
      
      public int getTotal() {
        return total;
      }

      public void MemasukkanUang(int nominal_uang_masuk){
            balance += nominal_uang_masuk;
            System.out.println("Uang berhasil masuk :" + nominal_uang_masuk);
            System.out.println("Jumlah balance sekarang :"+ balance);
      }

      public void PrintTicket(){
        if(balance < price){
            System.out.println("Saldo tidak cukup. Silahkan ketik 1 untuk memasukkan uang");
            System.out.println("Anda harus mengisi saldo : " + (price - balance));
        }
        else {
            balance -= price;
            System.out.println("Tiket Berhasil dicetak!");
            System.out.println("Sisa uang disaldo :" + balance);
        }
      }


    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Masukkan Harga Tiket : ");
        int input = userInput.nextInt();

        if(input < 0){
            System.out.println("Harga tiket tidak valid. Harga tiket harus bernilai positif!");
        }
        int pilih = 5;

        TicketMachine user = new TicketMachine(input);

        while(pilih != 4){  
            System.out.println("\n- Ticket Machine Menu -");
            System.out.println("1. Masukkan Uang");
            System.out.println("2. Membeli Tiket");
            System.out.println("3. Cek Saldo");
            System.out.println("4. Exit");
            System.out.println("--------------");
            System.out.print("Masukkian pilihan anda : ");
            pilih = userInput.nextInt();

            switch (pilih){
                case 1:
                    System.out.print("Masukkian nominal uang yang ingin dimasukkan : ");
                    int nominal_uang_masuk = userInput.nextInt();
                    user.MemasukkanUang(nominal_uang_masuk);
                    break;

                case 2:
                    user.PrintTicket();
                    break;

                case 3:
                    System.out.println("Balance sekarang :" + user.getBalance());
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan Ticket Machine. Selamat menikmati perjalanan Anda!");
                    System.out.println("Sisa saldo Anda : " + user.getBalance());
                    userInput.close();
                    break;
            }
        }
    }
}


