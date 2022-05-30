package Bank;

import java.util.Scanner;

public class BankProgram {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("AA1", 500000);

        getBalance(bankAccount);
        deposit(bankAccount);
        withdraw(bankAccount);

        SavingAccount savingAccount = new SavingAccount("AA2", 5000000, 0.02);
        getBalance(savingAccount);
        getMaturedAmount(savingAccount);
        getBalance(savingAccount);
        getMaturedAmount(savingAccount);
        withDrawSavingAccount(savingAccount);

    }

    // 입금기능
    public static void deposit(BankAccount bankAccount){
        System.out.print("[기능] 계좌에 입금할 금액을 입력해 주세요 : ");
        int addBalance = sc.nextInt();
        System.out.println("[기능] 계좌 입금 : "+addBalance+" 원");
        bankAccount.balance += addBalance;
    }

    // 출금기능
    public static void withdraw(BankAccount bankAccount){
        System.out.print("[기능] 계좌에 출금할 금액을 입력해 주세요 : ");
        int delBalance = sc.nextInt();
        System.out.println("[기능] 계좌 출금 : "+delBalance+" 원");
        bankAccount.balance -= delBalance;
    }

    // 계좌확인
    public static void getBalance(BankAccount bankAccount){
        System.out.println("[기능] 계좌 잔고 호출 : "+bankAccount.balance+"원");
    }

    // 정기예금
    static boolean isOne = true;
    public static void getMaturedAmount(SavingAccount savingAccount) {
        if (isOne) {
            System.out.print("[기능] 계좌에 입금할 금액을 입력해 주세요 : ");
            int addBalance = sc.nextInt();
            System.out.println("[기능] 계좌 입금 : " + addBalance + " 원");
            savingAccount.balance += addBalance;
            savingAccount.balance = (int) (savingAccount.balance * (1 + savingAccount.interest));
            isOne = false;
        } else {
            System.out.println("[경고] 정기 예금은 추가 불입을 할 수 없습니다.");
        }
    }

    public static void withDrawSavingAccount(SavingAccount savingAccount){
        System.out.println("[경고] 정기 예금은 만기 전에 인출이 불가합니다.");
    }


}

class BankAccount{
    String accountNumber;
    int balance;

    BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        System.out.println("[안내] "+accountNumber+" 계좌가 생성되었습니다. 잔고 (0원)");
        System.out.println("[안내] " + accountNumber + " 계좌 생성을 위해 " + balance + " 원 입금되었습니다.");
    }
}

class SavingAccount extends BankAccount{
    double interest;

    SavingAccount(String accountNumber, int balance, double interest) {
        super(accountNumber, balance);
        this.interest = interest;
    }
}