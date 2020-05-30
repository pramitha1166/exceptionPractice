class InsufficientBalanceException extends Exception {

  private double balance;

  public InsufficientBalanceException(double amount) {

    this.balance = amount;

  }

  public double getBalance() {
    return balance;
  }

}

class Account {

  private int accNum;
  private double amount=0;

  public Account(int accNum) {
    this.accNum = accNum;
  }

  public void deposit(double deposit) {
    amount = amount + deposit;
  }

  public void withdraw(double withdraw) throws InsufficientBalanceException {

    if(withdraw<amount) {
      amount = amount - withdraw;
    }else {
      throw new InsufficientBalanceException(amount);
    }

  }

}

class Main {


  

  public static void main(String[] args) {
    Account account = new Account(100);
    System.out.println("Depositing rd.10000");
    account.deposit(10000);

  try{
    System.out.println("Withdrawing rs.2000");
    account.withdraw(2000);
    System.out.println("Withdrawing rs.9000");
    account.withdraw(9000);
  }catch(InsufficientBalanceException e) {

    System.out.println("Can't withdraw money. Remaining account balance is : "+e.getBalance());

  }


  }
}