package lab2;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread1 t1 = new Thread1(bank);
        Thread2 t2 = new Thread2(bank);
        t1.run();
        t2.run();
    }
}