

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics; //The java.awt package in Java provides classes for creating graphical user interfaces (GUIs) and for rendering graphics. The Graphics class is part of this package and provides methods for drawing graphics 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
//on components, such as JPanel, JFrame, JLabel, and other Swing components.
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class breakOutBall {

    public static void main(String[] args) {
        JFrame f = new javax.swing.JFrame(); // creating instance of the JFrame
        f.setTitle("BreakOut Ball"); // setTitle function used to display the title
        f.setSize(700, 600);// sets the window's width and height
        f.setLocationRelativeTo(null); // This sets the location of the JFrame to the center of the screen. The null
                                       // argument means that the JFrame should be centered relative to the screen.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This sets the operation that should occur when the user
                                                          // closes the JFrame. In this case, the program will exit when
                                                          // the JFrame is closed.
        f.setVisible(true); // This makes the JFrame visible on the screen.
        f.setResizable(false); // This sets whether the user can resize the JFrame. In this case, the false
                               // argument means that the JFrame cannot be resized by the user.

        GamePlay gamePlay = new GamePlay();
        f.add(gamePlay);

    }
}

class GamePlay extends JPanel implements ActionListener, KeyListener{
    // in this we have extended means inherited the JPanel Class
    // In Java Swing, JPanel is a class that represents a container that can hold
    // other Swing components, such as buttons, labels, and text fields. It is a
    // lightweight container that is commonly used to organize \
    // and group components within a larger user interface.

    //private static final Graphics2D Graphics2D = null;

    //private static final Graphics2D Graphics2D = null;

    private boolean play = false; // this will not allow user to directlt start the game
    
    private int totalBricks = 21; // this will set the total no of Bricks at start

    private javax.swing.Timer timer; //The Timer object is used to control the timing of the game,
    private int delay = 0; // the delay variable is used to set the time interval between each game frame.
    private int ballpoaX = 120; // the delay variable is used to set the time interval between each game frame.
    private int ballpoaY = 350;
    private int ballXdir = -1;// ballXdir and ballYdir represent the direction that the ball is moving in.
    private int ballYdir = -2;
    private int playerX = 350; //  This variable is used to keep track of the position of the player's paddle in the game.
    private MapGenerator map;
    private int score = 0;

    public GamePlay() {
        //constructor
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer = new javax.swing.Timer(delay, this);
        timer.start();

        map = new MapGenerator(3, 7);

    }

    public void paint(Graphics g) {
        //The Graphics class represents a graphics context that can be used to draw lines, shapes, text, and images. The Graphics context is associated with a specific component, and any graphics drawn using the context will be displayed on that component.
        
        //black canvas
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);


        //border
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(0, 3, 3, 592);
        g.fillRect(689, 5, 3, 592);

        //Paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.RED);
        g.fillOval(ballpoaX, ballpoaY, 20, 20);


        //bricks
        map.draw((Graphics2D) g);

        //score
        g.setColor(Color.GREEN);
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString("Score : " + score, 550, 30);

        //gameover
        if(ballpoaY >= 570) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.GREEN);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over !!, Score :  "+ score, 200, 300);


            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Press Enter to Restart !!", 230, 350);
            
            
        }
        //winner
        if(totalBricks <= 0) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.GREEN);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won !!, Score :  "+ score, 200, 300);


            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Press Enter to Restart !!", 230, 350);
        
        }

    }

    private void moveLeft() {
        play = true;
        playerX -= 20;
    }
    private void moveRight() {
        play = true;
        playerX += 20;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX <=0) {
                playerX = 0;
            } else {
                moveLeft();
            }
            
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX>=600) {
                playerX=600;
            } else {
                moveRight();
            }
            
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!play) {
                score = 0;
                totalBricks = 21;
                ballpoaX = 120;
                ballpoaY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 320;

                map = new MapGenerator(3, 7);
            }
        }
        repaint();
    }
 

    @Override
    public void actionPerformed(ActionEvent e) {
        if(play) {
            if(ballpoaX<=0) {
                ballXdir = -ballXdir;
            }
            if(ballpoaX>=670) {
                ballXdir = -ballXdir;
            }
            if(ballpoaY<=0) {
                ballYdir = -ballYdir;
            }

            Rectangle ballRect = new Rectangle(ballpoaX, ballpoaY, 20, 20);
            Rectangle paddleRect = new Rectangle(playerX, 550, 100, 8);

            if(ballRect.intersects(paddleRect)){
                ballYdir =- ballYdir;
            }

           A: for(int i = 0; i<map.map.length; i++) {
                for(int j = 0; j<map.map[0].length; j++) {
                    if(map.map[i][j] > 0) {
                        int width = map.brickWidth;
                        int height = map.brickHeight;
                        int brickXPos = 80+j*width;
                        int brickYPos = 50+i*height;

                        Rectangle brickRect = new Rectangle(brickXPos, brickYPos, width, height);

                        if(ballRect.intersects(brickRect)) {
                            map.setBrick(0, i, j);
                            totalBricks--;
                            score += 5;

                            if(ballpoaX+19 <= brickXPos || ballpoaX+1 >= brickXPos+width) {
                                ballXdir =- ballXdir;
                            } else {
                                ballYdir =- ballYdir;
                            }
                            break A;
                        }
                    }
                }
            }
            ballpoaX += ballXdir;
            ballpoaY += ballYdir;
        }
        repaint();
    }

 
    // not needed below functions
   
    @Override
    public void keyTyped(KeyEvent e) {
        
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }



}

class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int coloumn) {
        map = new int[row][coloumn];

        for(int i = 0; i<row; i++) {
            for(int j = 0; j<coloumn; j++) {
                map[i][j] = 1;
            }
        }

        brickWidth = 540/coloumn;
        brickHeight = 150/row;
    }

    public void setBrick(int value, int r, int c) {
        map[r][c] = value;
    }

    public void draw(Graphics2D g) {
        for(int i = 0; i<map.length; i++) {
            for(int j = 0; j<map[0].length; j++) {
                if(map[i][j] > 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(j*brickWidth +80, i*brickHeight+80, brickWidth, brickHeight);

                    //black border
                    g.setColor(Color.BLACK);
                    g.setStroke(new BasicStroke(3));
                    g.drawRect(j*brickWidth +80, i*brickHeight+80, brickWidth, brickHeight);
                }
            }
        }
    }
}