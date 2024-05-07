package src.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    public BackgroundPanel()  {
        try {
            backgroundImage = ImageIO.read(new File("D:\\work-path\\java\\CurriculumDesign\\resource\\bg.jpg"));
        } catch (IOException ignored) {}
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}