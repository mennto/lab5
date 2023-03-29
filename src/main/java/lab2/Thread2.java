package lab2;

public class Thread2 implements Runnable{
    Bank bank;
    public Thread2(Bank bank) {
        this.bank = bank;
    }

    @Override
    synchronized public void run() {
        for (int i=1;  i<= 20000; i ++) {
            bank.setAccount(bank.getAccount()-1);
            System.out.println("dec "+bank.getAccount());
        }
    }
}
