import javax.swing.*;
import java.awt.*;

// Aisha Nicole L. Dones
// Section A122

public class PointGradeValidation {

    private static JPanel panel;
    private static JTextField idField, nameField, departmentField, courseField, subjectField,
            exam1Field, exam2Field, exam3Field, exam4Field;
    
    public static void main(String[] args){ script(); } // end of main

    private static void script(){
        String name, department, course, subject, pointGrade, remarks;
        int id, exam1, exam2, exam3, exam4, average, result;

        createPanel();

        result = JOptionPane.showConfirmDialog(null, panel,
                "Point Grade Validation", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // check for errors
            try {
                id = Integer.parseInt(idField.getText());
                name = nameField.getText();
                department = departmentField.getText();
                course = courseField.getText();
                subject = subjectField.getText();

                exam1 = Integer.parseInt(exam1Field.getText());
                exam2 = Integer.parseInt(exam2Field.getText());
                exam3 = Integer.parseInt(exam3Field.getText());
                exam4 = Integer.parseInt(exam4Field.getText());

                // check if grades are in percentage before computing
                if (exam1 < 0 || exam1 > 100 || exam2 < 0 || exam2 > 100 || exam3 < 0 || exam3 > 100 || exam4 < 0 || exam4 > 100) {
                    JOptionPane.showMessageDialog(null, "INVALID INPUT! Please enter grades in percentage (0-100).", "ERROR", JOptionPane.ERROR_MESSAGE);
                    script(); // run script again
                }

                average = getAverage(exam1, exam2, exam3, exam4);

                if (average >= 0 && average <= 100) {
                    pointGrade = getPointGrade(average);
                    remarks = getRemarks(average);
                } else { // if not between 0 and 100
                    pointGrade = "";
                    remarks = "Out of range or Invalid.";
                }

                // Data to be displayed in the JTable
                String[][] data = {{ String.valueOf(exam1), String.valueOf(exam2), String.valueOf(exam3), String.valueOf(exam4)}};
                String[] studentDetails = {"Student ID: " + id, "Name: " + name, "Department: " + department, "Course: " + course, "Subject: " + subject};

                showDetails(data, studentDetails, average, pointGrade, remarks);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "INVALID INPUT! Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
                script(); // run script again
            }

        }
    } // end of script method

    private static void showDetails(String[][] data, String[] studentDetails, int ave, String pg, String r){

        panel = new JPanel();
        JPanel topPanel = new JPanel(new GridLayout(7, 1, 0, 2));
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 0, 2));
        JPanel bottomPanel = new JPanel(new GridLayout(4, 1, 0, 2));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] columnNames = { "Exam 1", "Exam 2", "Exam 3", "Exam 4" };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(300, 40)); // set preferred size
        scrollPane.setViewportView(table);

        topPanel.add(new JLabel("******** Student Details ********\n"));
        for (String s : studentDetails){
            topPanel.add(new JLabel(s));
        }

        centerPanel.add(new JLabel("******** Grade Details ********\n"));
        centerPanel.add(scrollPane);

        bottomPanel.add(new JLabel("\nAverage: " + ave));
        bottomPanel.add(new JLabel("\nPoint Grade: " + pg));
        bottomPanel.add(new JLabel("\nRemarks: " + r));
        bottomPanel.add(new JLabel("\n\n(Submitted by: Aisha Nicole L. Dones)"));

        panel.add(topPanel);
        panel.add(centerPanel);
        panel.add(Box.createVerticalStrut(5)); // vertical space
        panel.add(bottomPanel);

        JOptionPane.showMessageDialog(null, panel, "Point Grade Validation", JOptionPane.PLAIN_MESSAGE);

    } // end of showDetails method

    private static int getAverage(int e1, int e2, int e3, int e4){ return (e1+e2+e3+e4)/4; } // end of getAverage method

    private static String getPointGrade(double grade){
        if (grade <= 100 && grade >= 75){
            double pg = (100-grade+10)/10;
            return String.format("%.2f", pg);
        } else if (grade < 75 && grade >= 50){
            return String.format("%.2f", 5.00);
        } else if (grade < 50 && grade >= 0){
            return String.format("%.2f", 9.00);
        } else {
            return String.format("%.2f", 0.00);
        }
    } // end of getPointGrade method

    private static String getRemarks(double grade){
        if (grade == 100){
            return "Passed – Excellent";
        } else if (grade < 100 && grade >= 90){
            return "Passed – Very Good";
        } else if (grade < 90 && grade >= 85) {
            return "Passed – Average";
        } else if (grade < 85 && grade >= 80) {
            return "Passed – Good";
        } else if (grade < 80 && grade >= 75) {
            return "Passed – Satisfactory";
        } else if (grade < 75 && grade >= 50) {
            return "Failed";
        } else if (grade < 50 && grade >= 0) {
            return "Dropped";
        } else {
            return "No such grade";
        }
    } // end of getRemarks method

    private static void createPanel(){
        
        JPanel idPanel, namePanel, departmentPanel, coursePanel, subjectPanel, exam1Panel, exam2Panel, exam3Panel, exam4Panel;

        panel = new JPanel();

        idField = new JTextField();
        nameField = new JTextField();
        departmentField = new JTextField();
        courseField = new JTextField();
        subjectField = new JTextField();
        exam1Field = new JTextField();
        exam2Field = new JTextField();
        exam3Field = new JTextField();
        exam4Field = new JTextField();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        idPanel = new JPanel(new GridLayout(1, 2));
        namePanel = new JPanel(new GridLayout(1, 2));
        departmentPanel = new JPanel(new GridLayout(1, 2));
        coursePanel = new JPanel(new GridLayout(1, 2));
        subjectPanel = new JPanel(new GridLayout(1, 2));
        exam1Panel = new JPanel(new GridLayout(1, 2));
        exam2Panel = new JPanel(new GridLayout(1, 2));
        exam3Panel = new JPanel(new GridLayout(1, 2));
        exam4Panel = new JPanel(new GridLayout(1, 2));

        createPanel(idPanel, idField, "Student ID: ");
        createPanel(namePanel, nameField, "Name: ");
        createPanel(departmentPanel, departmentField, "Department: ");
        createPanel(coursePanel, courseField, "Course: ");
        createPanel(subjectPanel, subjectField, "Subject: ");
        createPanel(exam1Panel, exam1Field, "First Exam: ");
        createPanel(exam2Panel, exam2Field, "Second Exam: ");
        createPanel(exam3Panel, exam3Field, "Third Exam: ");
        createPanel(exam4Panel, exam4Field, "Fourth Exam: ");
        
    } // end of createPanel method

    
    private static void createPanel(JPanel p, JTextField jt, String label){
        p.add(new JLabel(label));
        p.add(jt);
        panel.add(p);
        panel.add(Box.createVerticalStrut(5)); // a spacer
    } // end of createPanel method with 3 parameters

} // end of class
