package Engine;

import javax.swing.event.MouseInputListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Camera implements KeyListener {
    public double xPos, yPos, xDir, yDir, xPlane, yPlane;
    public boolean left, right, forward, back, rleft, rright;
    public final double MOVE_SPEED = .02;
    public final double ROTATION_SPEED = .045;

    public Camera(double x, double y, double xd, double yd, double xp, double yp) {
        xPos = x;
        yPos = y;
        xDir = xd;
        yDir = yd;
        xPlane = xp;
        yPlane = yp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent key) {
        if ((key.getKeyCode() == KeyEvent.VK_A))
            left = true;
        if ((key.getKeyCode() == KeyEvent.VK_D))
            right = true;
        if ((key.getKeyCode() == KeyEvent.VK_W))
            forward = true;
        if ((key.getKeyCode() == KeyEvent.VK_S))
            back = true;
        if ((key.getKeyCode() == KeyEvent.VK_Q))
            rleft = true;
        if ((key.getKeyCode() == KeyEvent.VK_E))
            rright = true;
    }

    public void keyReleased(KeyEvent key) {
        if ((key.getKeyCode() == KeyEvent.VK_A))
            left = false;
        if ((key.getKeyCode() == KeyEvent.VK_D))
            right = false;
        if ((key.getKeyCode() == KeyEvent.VK_W))
            forward = false;
        if ((key.getKeyCode() == KeyEvent.VK_S))
            back = false;
        if ((key.getKeyCode() == KeyEvent.VK_Q))
            rleft = false;
        if ((key.getKeyCode() == KeyEvent.VK_E))
            rright = false;
    }

    public void update(int[][] map) {
        if (forward) {
            if (map[(int) (xPos + xDir * MOVE_SPEED)][(int) yPos] == 0) {
                xPos += xDir * MOVE_SPEED;
            }
            if (map[(int) xPos][(int) (yPos + yDir * MOVE_SPEED)] == 0) {
                yPos += yDir * MOVE_SPEED;
            }
        }
        if (back) {
            if (map[(int) (xPos - xDir * MOVE_SPEED)][(int) yPos] == 0) {
                xPos -= xDir * MOVE_SPEED;
            }
            if (map[(int) xPos][(int) (yPos - yDir * MOVE_SPEED)] == 0) {
                yPos -= yDir * MOVE_SPEED;
            }
        }
        if (right) {
            if (map[(int) (xPos)][(int) (yPos - xDir * MOVE_SPEED)] == 0) {
                yPos -= xDir * MOVE_SPEED;
            }
            if (map[(int) (xPos + yDir * MOVE_SPEED)][(int) (yPos)] == 0) {
                xPos += yDir * MOVE_SPEED;
            }
        }
        if (left) {
            if (map[(int) (xPos)][(int) (yPos + xDir * MOVE_SPEED)] == 0) {
                yPos += xDir * MOVE_SPEED;
            }
            if (map[(int) (xPos - yDir * MOVE_SPEED)][(int) (yPos)] == 0) {
                xPos -= yDir * MOVE_SPEED;
            }
        }
        if (rleft) {
            double oldxDir = xDir;
            xDir = xDir * Math.cos(ROTATION_SPEED) - yDir * Math.sin(ROTATION_SPEED);
            yDir = oldxDir * Math.sin(ROTATION_SPEED) + yDir * Math.cos(ROTATION_SPEED);
            double oldxPlane = xPlane;
            xPlane = xPlane * Math.cos(ROTATION_SPEED) - yPlane * Math.sin(ROTATION_SPEED);
            yPlane = oldxPlane * Math.sin(ROTATION_SPEED) + yPlane * Math.cos(ROTATION_SPEED);
        }
        if (rright) {
            double oldxDir = xDir;
            xDir = xDir * Math.cos(-ROTATION_SPEED) - yDir * Math.sin(-ROTATION_SPEED);
            yDir = oldxDir * Math.sin(-ROTATION_SPEED) + yDir * Math.cos(-ROTATION_SPEED);
            double oldxPlane = xPlane;
            xPlane = xPlane * Math.cos(-ROTATION_SPEED) - yPlane * Math.sin(-ROTATION_SPEED);
            yPlane = oldxPlane * Math.sin(-ROTATION_SPEED) + yPlane * Math.cos(-ROTATION_SPEED);
        }
    }
}