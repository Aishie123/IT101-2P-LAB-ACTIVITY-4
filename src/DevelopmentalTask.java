import javax.swing.*;

// Aisha Nicole L. Dones
// Section A122

public class DevelopmentalTask {

    public static void main(String[] args) { script(); } // end of main

    private static void script(){

        try {
            String DevelopmentTask;

            int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter age (in years): ",
                    "Developmental Task", JOptionPane.QUESTION_MESSAGE));

            if (age >= 0 && age <= 5) {
                DevelopmentTask = "Infancy and Early Childhood";
            } else if (age >= 6 && age <= 12) {
                DevelopmentTask = "Middle Childhood";
            } else if (age >= 13 && age <= 17) {
                DevelopmentTask = "Adolescence";
            } else if (age >= 18 && age <= 35) {
                DevelopmentTask = "Early Adulthood";
            } else if (age >= 36 && age <= 60) {
                DevelopmentTask = "Middle Age";
            } else if (age > 60) {
                DevelopmentTask = "Later Maturity";
            } else {
                throw new ArithmeticException("This is not an age.");
            }

            JOptionPane.showMessageDialog(null, "You're in the '" + DevelopmentTask + "' stage of development task."  +
                    "\n(Submitted by: Aisha Nicole L. Dones)", "Developmental Task", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"INVALID INPUT! Please try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            script(); // run script again
        }
    } // end of script method

} // end of class
