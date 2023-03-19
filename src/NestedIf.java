import javax.swing.*;

// Aisha Nicole L. Dones
// Section A122

public class NestedIf {

    public static void main(String[] args){

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] weather = {"Sunny", "Rainy", "Gloomy"};
        String plan, reminder;

        String dayToday = (String) JOptionPane.showInputDialog(null, "What day is it today?",
                "Today's Plan and Reminder", JOptionPane.QUESTION_MESSAGE, null, days, days[6]);
        String weatherToday = (String) JOptionPane.showInputDialog(null, "How's the weather today?",
                "Today's Plan and Reminder", JOptionPane.QUESTION_MESSAGE, null, weather, weather[0]);

        if (!dayToday.equals(days[5]) || !dayToday.equals(days[6])){
            if (dayToday.equals(days[2])){
                plan = "You have 'School + Date' today!";
            } else if (dayToday.equals(days[4])){
                plan = "You have 'School + Party' today!";
            } else {
                plan = "You have 'School' today!";
            }
        } else {
            if (dayToday.equals(days[5])){
                plan = "You have 'Bonding with Friends' today!";
            } else {
                plan = "You have 'Church + Family Bonding' today!";
            }
        }

        if (weatherToday.equals(weather[0])){
            reminder = "Bring a Hat or Umbrella.";
        } else if (weatherToday.equals(weather[1])){
            reminder = "Bring an Umbrella or Raincoat.";
        } else {
            reminder = "Ride a taxi." ;
        }

         JOptionPane.showMessageDialog(null, plan + "\n" + reminder +
                         "\n\n(Submitted by: Aisha Nicole L. Dones)",
                 "Today's Plan and Reminder", JOptionPane.INFORMATION_MESSAGE);

    } // end of main

} // end of class
