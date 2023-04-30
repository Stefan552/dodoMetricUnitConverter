import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;

public class BackroundPanel extends JPanel {

    private BufferedImage image;

    public BackroundPanel() {
        try {



            image = ImageIO.read(new File("src/main/resources/leaf.jpg"));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

}

