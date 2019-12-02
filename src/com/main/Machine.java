package com.main;

import java.util.*;

class Sample
{
int total=0;
public int input(int coins)
{
switch(coins)
{
case 1:
total = total +1;
break;
case 5:
total = total + 5;
break;
case 10:
total = total + 10;
break;
case 25:
total = total + 25;
break;
case 50:
total = total + 50;
break;
case 100:
total = total + 100;
break;
case 200:
total = total + 200;
break;
default :
System.out.println("Wrong Input");
break;
}
return 0;
}

public int select(int choice)
{

switch(choice)
{

case 1:
System.out.println("You have selected COKE(25)");
total = total - 25;
System.out.println("Your Remaining change: "+total);
break;
case 2:
System.out.println("You have selected PEPSI(35)");
total = total - 35;
System.out.println("Your Remaining change: "+total);
break;
case 3:
System.out.println("You have selected SODA(45)");
total = total - 45;
System.out.println("Your Remaining change: "+total);
break;
case 4:
System.out.println("You have cancelled your Item.");
total = total - 0;
System.out.println("Your Remaining change: "+total);
break;
case 5:
Machine.main(null);
break;

default:
System.out.println("Wrong Choice");

}
return 0;
}
}

public class Machine
{
public static void main(String args[])
{
Sample sp = new Sample();
Scanner sc = new Scanner(System.in);
System.out.println("\t\t\tWelcome to Vending Machine.");
System.out.println("Put coins in the denomination of: 1,5,10,25");
int coins = sc.nextInt();
sp.input(coins);
System.out.println("Select one of the Items: \n");

System.out.println("1.COKE(25)");
System.out.println("2.PEPSI(35)");
System.out.println("3.SODA(45)");
System.out.println("4.CANCEL");
System.out.println("5.RESET");
int choice = sc.nextInt();
sp.select(choice);

}
}