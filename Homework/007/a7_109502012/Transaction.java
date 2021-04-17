// package a7_109502012;

public class Transaction {
    private String name;
    private int income;
    private int pay;

    public Transaction(String name){
        this.name = name;
        this.income = 0;
        this.pay = 0;
    }

    public String getName(){ return name;}
    public int getIncome(){ return income;}
    public int getPay(){ return pay;}

    public void setIncome(int income){
        this.income = income;
    }
    public void setPay(int pay){
        this.pay = pay;
    }
}
