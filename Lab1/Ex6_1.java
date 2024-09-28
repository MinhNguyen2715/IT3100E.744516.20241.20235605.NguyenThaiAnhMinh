package Lab1;

import javax.swing.JOptionPane;
public class Ex6_1 {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket?");

//        Customize button

//        String[] options = {"I do",
//                "I don't"};
//        int n = JOptionPane.showOptionDialog(null,
//                "Do you want to change to the first class ticket?",
//                "Confirmation",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                null,     //do not use a custom Icon
//                options,  //the titles of buttons
//                options[0]); //default button title

        JOptionPane.showMessageDialog(null,"You've chosen: "+ (option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);

    }
}
