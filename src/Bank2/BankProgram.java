package Bank2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class BankApp implements IBankApp{

    static Scanner sc = new Scanner(System.in);
    String emptyAccount = "없습니다";
    String selectedAccount = emptyAccount;

    HashMap<String, double[]> bankName = new HashMap<>();


    @Override
    public void start() {

        String num;
        System.out.printf("\n[안내] 카카오뱅크에 오신것을 환영합니다.\n");
        while (true) {
            System.out.print("\n메뉴를 선택해주세요. \n" +
                    "-------------------------\n" +
                    "현재 선택된 계좌는 "+
                    selectedAccount+
                    "\n1) [일반계좌생성]\n" +
                    "2) [정기예금계좌생성]\n" +
                    "3) [입금]\n" +
                    "4) [출금]\n" +
                    "5) [잔액조회]\n" +
                    "6) [계좌선택]\n" +
                    "7) [종료]\n" +
                    "-------------------------\n" +
                    ">>> ");
            num = sc.nextLine();
            switch (num) {
                case "1":
                    BankAccount();
                    break;
                case "2":
                    BankAccount2();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    withdraw();
                    break;
                case "5":
                    getBalance();
                    break;
                case "6":
                    selectAccount();
                    break;
                case "7":
                    System.out.println("앱을 종료합니다.");
                    break;
                default:
                    System.out.println("올바른 숫자를 입력해주세요");
                    break;
            }
            if (num.equals("7")) {
                sc.close();
                break;
            }
        }

    }

    @Override
    public void BankAccount() {
        System.out.println("계좌이름을 생성해주세요.");
        String accountName = sc.nextLine();
        bankName.put(accountName, new double[]{0.0, 0.0});
        System.out.println("[안내] "+accountName+" 일반계좌가 생성되었습니다. 잔고 (0원)");
//        System.out.println("[안내] " + accountNumber + " 계좌 생성을 위해 " + balance + " 원 입금되었습니다.");
        if(selectedAccount.equals(emptyAccount)) {
            selectedAccount = accountName;
        }
    }

    @Override
    public void BankAccount2() {
        System.out.println("계좌이름을 생성해주세요.");
        String accountName = sc.nextLine();
        bankName.put(accountName,new double[]{0.0, 0.02});
        System.out.println("[안내] "+accountName+" 정기예금계좌가 생성되었습니다. 잔고 (0원)");
//        System.out.println("[안내] " + accountNumber + " 계좌 생성을 위해 " + balance + " 원 입금되었습니다.");
        if(selectedAccount.equals(emptyAccount)) {
            selectedAccount = accountName;
        }
    }


    @Override
    public void deposit() {
        System.out.print("[기능] 계좌에 입금할 금액을 입력해 주세요 : ");
        int addBalance = sc.nextInt();
        System.out.println("[기능] 계좌 입금 : "+addBalance+" 원");
        double a = bankName.get(selectedAccount)[0] + addBalance;
        a = a*( 1+bankName.get(selectedAccount)[1] );
        bankName.put( selectedAccount, new double[]{a, bankName.get(selectedAccount)[1]});
        sc.nextLine();
    }

    @Override
    public void withdraw() {
        System.out.print("[기능] 계좌에서 출금할 금액을 입력해 주세요 : ");
        int minusBalance = sc.nextInt();
        System.out.println("[기능] 계좌 출금 : "+minusBalance+" 원");
        double a = bankName.get(selectedAccount)[0] - minusBalance;
        a = a*( 1+bankName.get(selectedAccount)[1] );
        bankName.put( selectedAccount, new double[]{a, bankName.get(selectedAccount)[1]});
        sc.nextLine();
    }

    @Override
    public void getBalance() {
        System.out.printf("[기능] 계좌 잔고 호출 : %d원",(int)bankName.get(selectedAccount)[0]);
    }

    public void selectAccount() {
        for( String key : bankName.keySet() ) {
            System.out.print("계좌 목록 : ");
            System.out.println(key);
        }
        System.out.println("선택할 계좌를 입력해주세요.");
        selectedAccount = sc.nextLine();
    }





}

public class BankProgram {
    public static void main(String[] args) {

        BankApp bankApp = new BankApp();
        bankApp.start();


    }
}







