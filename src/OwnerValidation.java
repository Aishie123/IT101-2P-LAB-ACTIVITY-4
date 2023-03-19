import javax.swing.*;

// Aisha Nicole L. Dones
// Section A122

public class OwnerValidation {
    public static void main(String[] args) {
        String name = capitalize(JOptionPane.showInputDialog("Enter your first name: ").toLowerCase());

        if (name.equals("Mart") || name.equals("Anne")){
            JOptionPane.showMessageDialog(null, name + " is the owner." +
                    "\n(Submitted by: Aisha Nicole L. Dones)");
        } else {
            JOptionPane.showMessageDialog(null, name + " is the owner of nothing." +
                    "\n(Submitted by: Aisha Nicole L. Dones)");
        }
    }

    public static String capitalize(String str)
    {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}