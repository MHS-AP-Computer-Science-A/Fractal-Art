import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tree extends JPanel {
    // Settings
    private boolean drawOnScreen = true;
    private boolean writeToImageFile = false;
    private static final String imageFileName = "fractal.bmp";
    private final int WIDTH = 1600;
    private final int HEIGHT = 900;

    // Other variables
    private JFrame frame;
    private BufferedImage image;

    public Tree(int depth) throws IOException {
        // CREATE A BLANK IMAGE
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // SET BACKGROUND COLOR
        g2.setColor(Color.black);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // SET INITIAL DRAWING COLOR
        g2.setColor(Color.BLACK);

        // DRAW THE FRACTAL
        drawTree(g2, WIDTH / 2, HEIGHT, -90, depth);

        // WRITES THE FRACTAL TO AN IMAGE FILE
        if (writeToImageFile) {
            ImageIO.write(image, "BMP", new File(imageFileName));
            g2.dispose();
        }

        // SHOWS FRACTAL ON SCREEN
        if (drawOnScreen) {
            frame = new JFrame("Tree Fractal");
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

 
    private void drawTree(Graphics2D g2, int x1, int y1, double angle, int depth) {

        if (depth == 0) {
            return;
        } else {
            //Compute the end point of the branch based on the angle parameter
            int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
            int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);


            //Set the branch color
            g2.setColor(new Color(255, 255, 255));

            //Draw the branch from (x1, y1) to (x2, y2) using the drawLine commane

             //TODO           
            

            /* This line connects (x1, y1) with (x2, y2)
             *   (x2, y2) 
             *      |
             *      |
             *      |
             *   (x1, y1)
             */

            //Recursively call drawTree twice (because there are two branches)
            //Add to or subtract from the angle paramter to define the angle of branching

            //TODO
        
        
            /* Each branch below is created by one of the recursive calls:
             *  
             *    \    /
             *     \  /
             *      \/
             *   (x2, y2) 
             *      |
             *      |
             *      |
             *   (x1, y1)
             */

        }

    }

}
