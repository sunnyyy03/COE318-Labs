/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;

/**
 *
 * @author Sanchit Das - 501114774
 */

public class Account {
    public String name;
    public int number;
    public double initialBalance;
    public double balance;
    
    public Account (String name, int number, double initialBalance){
        this.name = name;
        this.number = number;
        this.balance = initialBalance;   
    }
    /**
     * @return the name
     */
    public String getName(){
        return name;
    }
    /**
     * @return the balance
     */
    public double getBalance(){
        return balance;   
    }
    /**
     * @return the account number
     */
    public int getNumber(){
        return number;
    }
    /**
     * Adds the amount into the balance if
     * the balance isn't less than or equal to zero.
     * Otherwise, it is false.
     * @param amount
     * @return
     */
    public boolean deposit(double amount){
        if (amount <= 0)
            return false;
        else{  
            this.balance += amount;
            return true;
        }
    }
     /**
     * Subtracts the amount out of the balance if
     * the balance isn't less than or equal to zero,
     * or if the amount is greater than the balance.
     * Otherwise, it is false.
     * @param amount
     * @return
     */
    public boolean withdraw (double amount){
        if (amount <= 0 || amount > balance)
            return false;
        else{
            this.balance -= amount;
            return true;
        }
    }
    
    @Override
    public String toString(){
        return "(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")";
    }   
}
