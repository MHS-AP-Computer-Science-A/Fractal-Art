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

public class Fern extends JPanel {
    // Settings
    private boolean drawOnScreen = true;
    private boolean writeToImageFile = false;
    private static final String imageFileName = "fractal.bmp";
    private final int WIDTH = 1600;
    private final int HEIGHT = 900;

    // Other variables
    private JFrame frame;
    private BufferedImage image;

    public Fern(int depth) throws IOException {
        // CREATE A BLANK IMAGE
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // SET BACKGROUND COLOR
        g2.setColor(Color.black);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // SET INITIAL DRAWING COLOR
        g2.setColor(Color.GREEN);

        // DRAW THE FRACTAL
        drawFern(g2, depth);

        // WRITES THE FRACTAL TO AN IMAGE FILE
        if (writeToImageFile) {
            ImageIO.write(image, "BMP", new File(imageFileName));
            g2.dispose();
        }

        // SHOWS FRACTAL ON SCREEN
        if (drawOnScreen) {
            frame = new JFrame("Fern Fractal");
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

    private void drawFern(Graphics2D g2, int depth) {

        // (x, y) represents the point to be plotted
        double x = Math.random();
        double y = Math.random();

        // Instead of recursion, we will loop a process many times
        for (int i = 0; i < depth; i++) {
            // This random will choose a function using a random number from 1-100.
            // We will feed x and y into this function.
            int choose = (int) (Math.random() * 100) + 1;

            double newX = 0, newY = 0;

            // The random will determine which function we use. Note that the probablilies
            // are weighted.
            // In other words, not all functions are equally likely.
        
            // TODO


            // Plot (newX, newY). Note that it must be scaled to fit the screen.
            int plotX = (int) (newY * 150);
            int plotY = (int) (newX * 150 + 400);
         
            g2.fillRect(plotX, plotY, 1, 1);

            // Sets x and y to their new values. Each output from the function
            // becomes the input to the next one.
            x = newX;
            y = newY;

            /*    This shows the process:
            
             *               |----------|
             *    (x, y) --->| function |--->(newX, newY)
             *      ^        |----------|         |
             *      |                             |
             *      ------------------------------| 
             */

   

        }

    }

}
