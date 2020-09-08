package Games_and_Puzzles.Pong;

import objectdraw.*;
import java.awt.*;
/*
 * Example Pong: a still-simple but playable "Pong" game that features
 * a paddle and a falling ball that can now bounce off the sides and
 * interact with the paddle.
 *
 * Jim Teresco, Siena College, CSIS 120, Spring 2011
 * Based on similar example from CSCI 134, Williams College
 *
 * $Id: LessPatheticPong.java 1549 2011-02-22 04:01:53Z terescoj $
 */

public class Pong extends WindowController {

    // position and dimensions of the court
    private static final int COURT_LEFT = 50;
    private static final int COURT_TOP = 50;
    private static final int COURT_HEIGHT = 300;
    private static final int COURT_WIDTH = 300;
    private static final int COURT_RIGHT = COURT_LEFT + COURT_WIDTH;

    // dimensions of the paddle
    private static final int PADDLE_WIDTH = 50;
    private static final int PADDLE_HEIGHT = 20;

    private static final int PADDLE_Y = COURT_TOP + COURT_HEIGHT - PADDLE_HEIGHT - 1;

    private FilledRect paddle;
    private FramedRect boundary; // the boundary of the playing area.

    public void begin() {
        // make the playing area
        boundary = new FramedRect(COURT_LEFT, COURT_TOP,
            COURT_WIDTH, COURT_HEIGHT,
            canvas);

        // make the paddle
        paddle = new FilledRect(COURT_LEFT + (COURT_WIDTH-PADDLE_WIDTH)/2,
            COURT_TOP + COURT_HEIGHT - PADDLE_HEIGHT -1,
            PADDLE_WIDTH, PADDLE_HEIGHT,
            canvas);
    }

    // create a new falling ball
    public void onMouseClick(Location point) {

        // create the ball at the top of the playing area
        // at the mouse point's x coordinate
        if (boundary.contains(point)) {
            new PongBall(paddle, boundary, canvas);
        }
    }

    // move the paddle to follow the mouse's x coordinate
    public void onMouseMove(Location point) {

        if (point.getX() < COURT_LEFT) {
            // place paddle at left edge of the court
            paddle.moveTo(COURT_LEFT, PADDLE_Y);
        } else if (point.getX() + PADDLE_WIDTH > COURT_RIGHT) {
            // place paddle at right edge of the court
            paddle.moveTo(COURT_RIGHT - PADDLE_WIDTH, PADDLE_Y);
        } else {
            // keep the edge of the paddle lined up with the mouse
            paddle.moveTo(point.getX(), PADDLE_Y);
        }

    }
}
