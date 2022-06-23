package entity;

import main.GamePanel;

public class Camera
{
    public static Camera instance = new Camera(0, 0);
    public GamePanel gp;
    private int x, y;

    private int limitX1, limitY1, limitX2, limitY2;
    public Camera(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // Create static getters and setters for instance object
    public static int getX()
    {
        return instance.x;
    }

    public static int getY()
    {
        return instance.y;
    }

    public static int getAbsoluteX()
    {
        return instance.x - instance.gp.screenWidth / 2;
    }

    public static int getAbsoluteY()
    {
        return instance.y - instance.gp.screenHeight / 2;
    }

    public static void setX(int x)
    {
        instance.x = x;
    }

    public static void setY(int y)
    {
        instance.y = y;
    }

    public static void move(int x, int y)
    {
        setPos(getX() + x, getY() + y);
    }

    public static void setLimits(int x1, int x2, int y1, int y2)
    {
        instance.limitX1 = x1;
        instance.limitX2 = x2;
        instance.limitY1 = y1;
        instance.limitY2 = y2;
    }

    public static void setPos(int x, int y) {
        setX(x);
        setY(y);
        if (instance.x < instance.limitX1)
        {
            setX(instance.limitX1);
        }
        if (instance.x > instance.limitX2)
        {
            setX(instance.limitX2);
        }
        if (instance.y < instance.limitY1)
        {
            setY(instance.limitY1);
        }
        if (instance.y > instance.limitY2) {
            setY(instance.limitY2);
        }
    }
}
