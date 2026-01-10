class bank_account{
    int account_no;
    String name,type;
    float amount;

void account_details(int bank_account,String nameOfCustomer,String typeName,float amout_details){
    account_no=bank_account;
    name=nameOfCustomer;
    type=typeName;
    amount=amout_details;
}
void show(){
    System.out.println(account_no+" "+name+" "+type+" "+amount+" ");
}
void deposit(float d){
    amount+=d;
    System.out.println("Deposit amount: "+d);
}
void withdraw(float d){
    if(amount>d){
            amount-=d;
            System.out.println("withdraw amount: "+d);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
void get_account_balance(){
    System.out.println("Your balance is: "+amount);

}
}
class bank{
    public static void main(String[] args) {
        bank_account n = new bank_account();
        n.account_details(123456, "kritika", "saving", 1000);
        n.show();
        n.deposit(40000);
        n.get_account_balance();
        n.withdraw(10000);
        n.get_account_balance();    
    }
}
