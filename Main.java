package javaDVDLogo;

import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int x, y, width, height;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the width of the screen you would like to simulate:");
        width = in.nextInt();

        System.out.println("Enter the height of the screen you would like to simulate:");
        height = in.nextInt();

        System.out.println("Enter the x-coordinate of the starting point for the bouncing logo (1-" + width + "):" );
        x = in.nextInt()-1;

        System.out.println("Enter the y-coordinate of the starting point for the bouncing logo (1-" + height + "):");
        y = in.nextInt()-1;

        System.out.println("\n\n"+logoWillHitCorner(x,y,width,height));


        in.close();
    }

    public static boolean logoWillHitCorner(int x, int y, int width, int height) {

        HashSet<Integer> UpLeft = new HashSet<Integer>();
        HashSet<Integer> UpRight = new HashSet<Integer>();
        HashSet<Integer> DownLeft = new HashSet<Integer>();
        HashSet<Integer> DownRight = new HashSet<Integer>();

        height -= 143;
        width -= 143;
        int xdelta = 1;
        int ydelta = 1;

        while (true){
            x += xdelta;
            y += ydelta;

            if (xdelta == 1 && ydelta == 1){
                if (DownRight.contains(x+y*width)){
                    return false;
                }
                DownRight.add(x+y*width);
            }else if(xdelta == 1 && ydelta == -1){
                if(UpRight.contains(x+y*width)){
                    return false;
                }
                UpRight.add(x+y*width);
            }else if(xdelta == -1 && ydelta == 1){
                if (DownLeft.contains(x+y*width)){
                    return false;
                }
                DownLeft.add(x+y*width);
            }else{
                if (UpLeft.contains(x+y*width)){
                    return false;
                }
                UpLeft.add(x+y*width);
            }

            if ((x == 0  && y == 0)||(x == 0 && y == height-1)||(x== width-1 && y==0)||(x==width-1 && y == height-1)){
                return true;
            }

            if (x==0){
                xdelta = 1;
                // System.out.println("Left Wall "+y);
            }else if (x==width-1){
                xdelta = -1;
                // System.out.println("Right Wall "+y);
            }else if (y==0){
                ydelta = 1;
                // System.out.println("Ceiling "+x);
            }else if (y==height-1){
                ydelta = -1;
                // System.out.println("Floor "+x);
            }
        }
    }
}