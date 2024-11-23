import javax.swing.*;
import java.lang.Math;

public class Ex2_2_6 {
    public static void main(String[] args) {
        String eq;
        double tmp;
        do{
            eq = JOptionPane.showInputDialog(null,
                    "Enter the type of equation \n1: linear equation \n2: 2-variable linear equation \n3: second-degree equation with one variable",
                    "Input the first number: ", JOptionPane.INFORMATION_MESSAGE);
            tmp = Double.parseDouble(eq);
        } while (tmp > 3 || tmp < 1);


        /*Linear equation*/
        if(tmp == 1){
            String a,b;
            String noti = "Your equation is: ";

            a = JOptionPane.showInputDialog(null,
                    "Enter first number:","Input",JOptionPane.INFORMATION_MESSAGE);

            noti += a + "x + ";

            b = JOptionPane.showInputDialog(null,
                    "Enter second number:","Input",JOptionPane.INFORMATION_MESSAGE);

            noti += b +" = 0";

            double num1 = Double.parseDouble(a);
            double num2 = Double.parseDouble(b);

            if(num1 == 0){
                if(num2 == 0){
                    JOptionPane.showMessageDialog(null,
                            noti+"\nThe equation has infinitely many solutions!","Calculate: "
                            ,JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            noti+"\nThe equation has no solution","Calculate: "
                            ,JOptionPane.INFORMATION_MESSAGE);
                }
            }

            else {
                JOptionPane.showMessageDialog(null,
                        noti+"\nThe equation has 1 solution: "+ (-num2/num1),"Calculate: "
                        ,JOptionPane.INFORMATION_MESSAGE);
            }

        }


        /*2-variable linear equation*/
        else if (tmp == 2) {
            String a11,a12,b1,a21,a22,b2;
            String noti = "Your system is:\n";
            a11 = JOptionPane.showInputDialog(null,
                    "Enter a11:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti += a11+"x + ";
            a12 = JOptionPane.showInputDialog(null,
                    "Enter a12:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti += a12+"y = ";
            b1 = JOptionPane.showInputDialog(null,
                    "Enter b1:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti += b1+"\n";
            a21 = JOptionPane.showInputDialog(null,
                    "Enter a21:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti += a21+"x + ";
            a22 = JOptionPane.showInputDialog(null,
                    "Enter a22:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti += a22+"y = ";
            b2 = JOptionPane.showInputDialog(null,
                    "Enter b2:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti+= b2;
            Double num11,num12,num1,num21,num22,num2;
            num11 = Double.parseDouble(a11);
            num12 = Double.parseDouble(a12);
            num1 = Double.parseDouble(b1);
            num21 = Double.parseDouble(a21);
            num22 = Double.parseDouble(a22);
            num2 = Double.parseDouble(b2);

            Double D = Math.abs(num11*num22-num12*num21);
            if (D == 0){
                JOptionPane.showMessageDialog(null,
                        noti+"\nThe system has no solution!","Calculate: "
                        ,JOptionPane.INFORMATION_MESSAGE);
            }

            else{
                Double Dx = Math.abs(num1*num22-num12*num2);
                Double Dy = Math.abs(num11*num1-num21*num2);
                JOptionPane.showMessageDialog(null,
                        noti+"\nThe system has 1 solution: \n x = "+(Dx/D)+"\ny = "+(Dy/D),"Calculate: "
                        ,JOptionPane.INFORMATION_MESSAGE);
            }
        }

        /*second-degree equation with one variable*/
        else {
            String a,b,c;
            String noti = "Your equation is: ";
            do {
                a = JOptionPane.showInputDialog(null,
                        "Enter first number:", "Input", JOptionPane.INFORMATION_MESSAGE);
            } while (a.equals("0"));
            noti += a+"x^2 + ";

            b = JOptionPane.showInputDialog(null,
                    "Enter second number:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti += b+"x + ";
            c = JOptionPane.showInputDialog(null,
                    "Enter third number:","Input",JOptionPane.INFORMATION_MESSAGE);
            noti += c+" = 0";

            double num1,num2,num3;
            num1 = Double.parseDouble(a);
            num2 = Double.parseDouble(b);
            num3 = Double.parseDouble(c);

            double delta = num2*num2 - 4*num1*num3;
            if(delta < 0){
                JOptionPane.showMessageDialog(null,
                        noti+"\nThe system has no solution!","Calculate: "
                        ,JOptionPane.INFORMATION_MESSAGE);
            }
            else if(delta == 0){
                JOptionPane.showMessageDialog(null,
                        noti+"\nThe system has 1 solution: \n x = " +(-num2 / (2*num1)),"Calculate: "
                        ,JOptionPane.INFORMATION_MESSAGE);
            }

            else{
                JOptionPane.showMessageDialog(null,
                        noti+"\nThe system has 2 solutions: \nx = " +((-num2 + Math.sqrt(delta)) / (2*num1)) + " or\nx = "+((-num2 - Math.sqrt(delta)) / (2*num1)),
                        "Calculate: ",JOptionPane.INFORMATION_MESSAGE);
            }
        }


        System.exit(0);
    }
}
