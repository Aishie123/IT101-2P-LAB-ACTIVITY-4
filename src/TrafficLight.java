import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

// Aisha Nicole L. Dones
// Section A122

public class TrafficLight {

    private static final Logger logger = Logger.getLogger(TrafficLight.class.getName());

    public static void main(String[] args) throws IOException {
        int n = (int)(Math.random() * 3) + 1;
        logger.info("Random number: " + n); // for debugging

        switch (n) {
            case 1 -> setLight("go.png", "The vehicle is set to go");
            case 2 -> setLight("ready.png", "The vehicle is set to ready");
            case 3 -> setLight("stop.png", "The vehicle is set to stop");
        }
    } // end of main

    private static void setLight(String light, String msg) throws IOException {

        BufferedImage image = ImageIO.read(Objects.requireNonNull(TrafficLight.class.getResourceAsStream("Images/"+light)));
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("<html><span style='font-size:20px'>"+msg+"</span></html>"));
        panel.add(Box.createVerticalStrut(10)); // a spacer
        panel.add(new JLabel(new ImageIcon(image)));
        panel.add(Box.createVerticalStrut(10)); // a spacer
        panel.add(new JLabel("<html><span style='font-size:14px'>(Submitted by Aisha Nicole L. Dones)</span></html>"));

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        logger.info("Frame set visible"); // for debugging
    } // end of setLight method

} // end of class
