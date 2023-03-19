import javax.swing.*;
import java.math.BigDecimal;

// Aisha Nicole L. Dones
// Section A122

public class PositiveNegative {

    public static void main(String[] args) { script(); } // end of main

    private static void script(){

        try {

            double n = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a number: ",
                    "Positive or Negative", JOptionPane.QUESTION_MESSAGE));
            String strN = BigDecimal.valueOf(n).stripTrailingZeros().toPlainString();

            if (n > 0){
                JOptionPane.showMessageDialog(null, strN + " is a positive number." +
                        "\n(Submitted by: Aisha Nicole L. Dones)", "Positive or Negative", JOptionPane.INFORMATION_MESSAGE);
            } else if (n < 0){
                JOptionPane.showMessageDialog(null, strN + " is a negative number." +
                        "\n(Submitted by: Aisha Nicole L. Dones)", "Positive or Negative", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, strN + " is neither a positive nor a negative number." +
                         "\n(Submitted by: Aisha Nicole L. Dones)", "Positive or Negative", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"INVALID INPUT! Please try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            script(); // run script again
        }
    } // end of script method

} // end of class
