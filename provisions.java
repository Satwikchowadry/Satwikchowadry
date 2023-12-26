
import java.util.Scanner;
class sample11
{
float tbill;
void billcal(float price,int qty)
{
float bill=price*qty;
tbill=tbill+bill;
System.out.println("total billis "+tbill);

}
}

public class provision
 {
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int pid,qty,choice,price,choice1;
String pname,input;
sample11 s=new sample11();
do
{
System.out.println("Welcome to reliance supermarket");
System.out.println("Select the one");
System.out.println("1.provision");
System.out.println("2.Garments");
System.out.println("3.cool drinks");
choice=sc.nextInt();
switch(choice)
{
case 1:
do
{
System.out.println("U selected one is provision");
System.out.println("1.dal-each 150 r.s");
System.out.println("2.rise-each 1200 r.s");
System.out.println("3.oil-each 200 r.s");
System.out.println("4.soaps-each 500 per box");
choice1=sc.nextInt();
switch(choice1)
{
case 1:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=150;
s.billcal(price,qty);
break;
case 2:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=1200;
s.billcal(price,qty);
break;
case 3:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=200;
s.billcal(price,qty);
break;
case 4:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=500;
s.billcal(price,qty);
break;
default:
System.out.println("Invalid choice ");
}
System.out.println("Do u want one more item press(y or n)");
input=sc.next();
}
while(input.equalsIgnoreCase("yes"));

break;
case 2://
do
{
System.out.println("U selected one is Garments");
System.out.println("1.T-shirs 150 r.s");
System.out.println("2.casual ware 1200 r.s");
System.out.println("3.party wear 2200 r.s");
System.out.println("4.sarees 500 r.s");
choice1=sc.nextInt();
switch(choice1)
{
case 1:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=150;
s.billcal(price,qty);
break;
case 2:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=1200;
s.billcal(price,qty);
break;
case 3:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=2200;
s.billcal(price,qty);
break;
case 4:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=500;
s.billcal(price,qty);
break;
default:
System.out.println("Invalid choice ");
}
System.out.println("Do u want one more item press(y or n)");
input=sc.next();
}
while(input.equalsIgnoreCase("yes"));

break;
case 3:
do
{
System.out.println("U selected one is cool drinks");
System.out.println("1.thums up 150 r.s each");
System.out.println("2.limca 120 r.s each");
System.out.println("3.sprite 220 r.s each");
System.out.println("4.cocacola 200 r.s each");
choice1=sc.nextInt();
switch(choice1)
{
case 1:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=150;
s.billcal(price,qty);
break;
case 2:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=120;
s.billcal(price,qty);
break;
case 3:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=220;
s.billcal(price,qty);
break;
case 4:
System.out.println("Enter how many u want");
qty=sc.nextInt();
price=200;
s.billcal(price,qty);
break;
default:
System.out.println("Invalid choice ");
}
System.out.println("Do u want one more item press(y or n)");
input=sc.next();
}
while(input.equalsIgnoreCase("yes"));

break;
}
System.out.println("want to shopaagain ");
input=sc.next();
}while(input.equalsIgnoreCase("yes"));
}
}   
