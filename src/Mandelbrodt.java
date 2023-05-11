import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mandelbrodt extends JPanel {
    // Settings
    private boolean drawOnScreen = true;
    private boolean writeToImageFile = false;
    private static final String imageFileName = "fractal.bmp";
    private final int WIDTH = 1600;
    private final int HEIGHT = 900;

    // Other variables
    private JFrame frame;
    private BufferedImage image;

    private int MaxIterations = 0;

    // Set coordinates
    private double MinRe = -3.0;
    private double MaxRe = 1.0;
    private double MinIm = -1.2;
    private double MaxIm = MinIm + (MaxRe - MinRe) * HEIGHT / WIDTH;
    private double Re_factor = (MaxRe - MinRe) / (WIDTH - 1);
    private double Im_factor = (MaxIm - MinIm) / (HEIGHT - 1);

    public Mandelbrodt(int depth) throws IOException {
        // Variable inititalization
        // Set maximum iterations
        MaxIterations = depth;

        // CREATE A BLANK IMAGE
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // SET BACKGROUND COLOR
        g2.setColor(Color.black);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // SET INITIAL DRAWING COLOR
        g2.setColor(Color.WHITE);

        // Call the draw method
        drawMandelbrodt(g2);

        // WRITES THE FRACTAL TO AN IMAGE FILE
        if (writeToImageFile) {
            ImageIO.write(image, "BMP", new File(imageFileName));
            g2.dispose();
        }

        // SHOWS FRACTAL ON SCREEN
        if (drawOnScreen) {
            frame = new JFrame("Mandelbrodt Set");
            // Set to close program when frame is closed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Set panel size
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            // Place panel on the frame centered
            frame.add(this);
            frame.pack();
            frame.setLocationRelativeTo(null);
            // Show the frame
            frame.setVisible(true);
        }

    }

    // POST: Draws the fractal on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Convert to a Graphics2D object bc it gives us way more tools
        Graphics2D g2 = (Graphics2D) g;
        // Turn on anti-aliasing (smoothing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Display the image
        g2.drawImage(image, 0, 0, WIDTH, HEIGHT, frame);

    }

    void drawMandelbrodt(Graphics2D g2) {

        // Compute and draw the set

        // TODO

    }

}
