package main;

import scene.Scene;

public class Camera {
    // A static object of the camera so we can access it from everywhere using Camera.instance.
    // All methods in this class are static so they can be used with Camera.method() instead of Camera.instance.method().
    public static Camera instance = new Camera(0, 0);

    // Reference to the game panel needed for screen width
    public Scene gp;

    // Coordinates of the camera. The coordinates describe the center of the camera, not the top left corner
    private int x, y;

    // These are the minX, minY, maxX, and maxY values of the camera, so it cannot clip out of the map.
    private int limitX1, limitY1, limitX2, limitY2;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Create static getters and setters for instance object
    public static int getX() {
        return instance.x;
    }

    public static int getY() {
        return instance.y;
    }


    // These absolute values are used for drawing other objects, as their base point is the camera's top left corner
    // and x and y coordinates are at the center.
    public static int getAbsoluteX() {
        // Subtract half width from the coordinate
        return instance.x - instance.gp.getScreenWidth() / 2;
    }

    public static int getAbsoluteY() {
        return instance.y - instance.gp.getScreenHeight() / 2;
    }

    public static void setX(int x) {
        instance.x = x;
    }

    public static void setY(int y) {
        instance.y = y;
    }

    public static void move(int x, int y) {
        setPos(getX() + x, getY() + y);
    }

    public static void setLimits(int x1, int x2, int y1, int y2) {
        instance.limitX1 = x1;
        instance.limitX2 = x2;
        instance.limitY1 = y1;
        instance.limitY2 = y2;
    }

    public static void setPos(int x, int y) {
        setX(x);
        setY(y);
        if ((instance.limitX1 == instance.limitX2) == (instance.limitY1 == instance.limitY2)) {
            return;
        }
        // If the new position is outside of the bounds, set it to the closest bound
        if (instance.x < instance.limitX1) {
            setX(instance.limitX1);
        }
        if (instance.x > instance.limitX2) {
            setX(instance.limitX2);
        }
        if (instance.y < instance.limitY1) {
            setY(instance.limitY1);
        }
        if (instance.y > instance.limitY2) {
            setY(instance.limitY2);
        }
    }
}
