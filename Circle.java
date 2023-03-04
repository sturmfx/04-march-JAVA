package com.company;
import java.awt.*;
import java.util.Random;

public class Circle
{
    Random r;
    double x;
    double y;
    double radius;
    Color color;

    double speed = 2;
    double dx = 0.0;
    double dy = 0.0;

    int target_x = 250;
    int target_y = 250;
    public Circle(double x1, double y1, double r, Color c)
    {
        this.x = x1;
        this.y = y1;
        this.radius = r;
        this.color = c;
        this.r = new Random();
        update(250, 250);
    }

    public void update(int tx, int ty)
    {
        double delta_x = tx - x;
        double delta_y = ty - y;
        double dist = Math.sqrt(delta_x * delta_x + delta_y * delta_y);
        double k = dist / speed;
        dx = delta_x / k;
        dy = delta_y / k;
        target_x = tx;
        target_y = ty;
    }

    public void xyupdate()
    {
        x = x + dx;
        y = y + dy;
        if(check_coordinate())
        {
            target_update(1500, 1000);
        }
    }

    public void target_update(int x_limit, int y_limit)
    {
        int new_x = r.nextInt(x_limit);
        int new_y = r.nextInt(y_limit);
        update(new_x, new_y);
    }

    public boolean check_coordinate()
    {
        double x_diff = Math.abs(this.x - this.target_x);
        double y_diff = Math.abs(this.y - this.target_y);

        if(x_diff <= Math.abs(dx) && y_diff <= Math.abs(dy))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void print1()
    {
        System.out.println("Color: " + color + ", x = " + x + ", y = " + y);
    }


}
