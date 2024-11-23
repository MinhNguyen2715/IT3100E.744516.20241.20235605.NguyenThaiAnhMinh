import javax.swing.JOptionPane;
public class Ex2_2_5 {
    public static void main(String[] args) {
        String num1, num2;
        String noti = "Your numbers are: ";

        num1 = JOptionPane.showInputDialog(null,
                "Enter first number:","Input the first number: ",JOptionPane.INFORMATION_MESSAGE);

        noti += num1 + " and ";

        num2 = JOptionPane.showInputDialog(null,
                "Enter first number:","Input the first number: ",JOptionPane.INFORMATION_MESSAGE);

        noti += num2;

        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);

        double s = n1+n2;
        double d = n1-n2;
        double p = n1*n2;
        double q = 0;
        if (n2!=0) {
            q = n1 / n2;
            JOptionPane.showMessageDialog(null,
                    noti+"\nSum: "+s+"\nDifference: "+d+"\nProduct: "+p+"\nQuotient: "+q,"Calculate: "
                    ,JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    noti+"\nSum: "+s+"\nDifference: "+d+"\nProduct: "+p+"\nQuotient: Cannot divide by 0","Calculate: "
                    ,JOptionPane.INFORMATION_MESSAGE);
        }

        System.exit(0);


    }
}
