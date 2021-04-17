// package a7_109502012;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TransactionRecord {

    private ArrayList<Transaction> list;

    public TransactionRecord(){
        list = new ArrayList<>();
    }
    
    public void addWithIncome(String name, int income){
        var tmpTransaction = (new Transaction(name));
        tmpTransaction.setIncome(income);
        list.add(tmpTransaction);
    }
    
    public void addWithPay(String name, int pay){
        var tmpTransaction = (new Transaction(name));
        tmpTransaction.setPay(pay);
        list.add(tmpTransaction);
    }

    @Override
    public String toString(){
        StringBuilder lines = new StringBuilder();
        int maxNameLen = 0, maxIncome = 0;
        for (var data : list){
            maxNameLen = (data.getName().length() < maxNameLen) ? maxNameLen : data.getName().length();
            maxIncome = (data.getIncome() < maxIncome) ? maxIncome : data.getIncome();
        }
        int maxIncomeLen = Integer.toString(maxIncome).length();
        int sum = 0;
        for (var data : list){
            int tmpIncome = data.getIncome();
            int tmpPay = data.getPay();
            String tmpName = data.getName();
            lines.append(tmpName);
            for (int i = -2; i < maxNameLen - tmpName.length(); ++i){
                lines.append(" ");
            }
            lines.append(tmpIncome);
            for (int i = -2; i < maxIncomeLen - Integer.toString(tmpIncome).length(); ++i){
                lines.append(" ");
            }
            lines.append(tmpPay).append("\n");
            sum += tmpIncome - tmpPay;
        }
        return lines.append("Total: ").append(sum).toString();
    }

    public static void main(String[] args){
        var console = new Scanner(in);
        int cmd;
        var myTransaction = new TransactionRecord();
        while ((cmd = console.nextInt()) != 4){
            switch (cmd){
                case 1 -> myTransaction.addWithIncome(console.next(), console.nextInt());
                case 2 -> myTransaction.addWithPay(console.next(), console.nextInt());
                case 3 -> out.println(myTransaction);
                default -> out.println("Invalid Operation");
            }
        }
        console.close();
    }
}
