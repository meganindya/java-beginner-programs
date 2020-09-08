import objectdraw.*;
import java.awt.*;

/*
 * 
 * A simple active object that controls a ball that bounces around the
 * canvas and interacts with a boundary and a pong paddle
 *
 * Jim Teresco, Siena College, CSIS 120, Spring 2011
 *
 * $Id: SimplePongBall.java 1549 2011-02-22 04:01:53Z terescoj $
 */

public class PongBall extends ActiveObject {

    // size and speed of falling balls
    private static final int BALLSIZE = 30;
    private static final double MIN_SPEED = 3;
    private static final double MAX_SPEED = 10;
    private static final int DELAY_TIME = 33;

    // the ball controlled by this instance
    private FilledOval ball;

    // the paddle with which we will interact
    private FilledRect paddle;

    // how far to fall before stopping and disappearing?
    private double yMax;
    // how far up to go before bouncing off the ceiling?
    private double yMin;
    // and what about the walls?
    private double xMin, xMax;

    // Draw a ball and start it falling.
    public PongBall(FilledRect paddle, FramedRect boundary,
    DrawingCanvas aCanvas) {

        // compute/remember our boundaries (of the upper left corner of a ball)
        yMax = boundary.getY()+boundary.getHeight();
        yMin = boundary.getY();
        xMin = boundary.getX();
        xMax = boundary.getX() + boundary.getWidth() - BALLSIZE;

        // random generator for the x-coordinate
        RandomDoubleGenerator posGen = new RandomDoubleGenerator(xMin, xMax);

        // draw the ball at its initial position, which is at the 
        // top of the playing area, at a randomly-selected position
        ball = new FilledOval(posGen.nextValue(), yMin+1,
            BALLSIZE, BALLSIZE, aCanvas);

        // remember the paddle
        this.paddle = paddle;

        // activate!
        start();
    }

    // move the ball repeatedly until it falls off screen, bouncing
    // off the paddle and walls along the way
    public void run() {
        double xSpeed, ySpeed;

        // start by moving downward and some amount to the left or right
        RandomDoubleGenerator speedGen = new RandomDoubleGenerator(MIN_SPEED, MAX_SPEED);

        xSpeed = speedGen.nextValue();
        double initYSpeed = speedGen.nextValue();
        ySpeed = initYSpeed;

        // keep moving as long as we haven't fallen off the bottom of
        // the screen
        while (ball.getY() <= yMax) {
            // if we are above the top line, start moving down
            if (ball.getY() < yMin) {
                ySpeed = initYSpeed;
            }

            // if we are in contact with the paddle, start moving up
            if (ball.overlaps(paddle)) {
                ySpeed = -initYSpeed;
            }

            // bounce off side walls
            if (ball.getX() < xMin || ball.getX() > xMax) {
                xSpeed = -xSpeed;
            }

            // move a little in the appropriate direction
            ball.move(xSpeed, ySpeed);
            pause(DELAY_TIME);
        }

        ball.removeFromCanvas();
    }
}
