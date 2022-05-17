import java.awt.Color;

import graphics.Canvas;

public class Program {
    // Canvas GUI instance providing the drawing area on which to plot the functions
    private static Canvas canvas;

    public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();

        // Draw a short red diagonal on the canvas
        canvas.pause();
        canvas.setColor(Color.red);
        GetY sin = (x)->{return (int) (200 * Math.sin(Math.PI * x / 360));};
        GetY quadratic = (x)->{return (int) ((x - 200) * (x + 200) / 250);};
        GetY log = (x)->{return (int) ((20 * Math.log(x)));};
        GetY cubic = (x)->{return (int) (Math.pow(x, 3) / 200000);};


        plotFunction(sin);
        plotFunction(quadratic);
        plotFunction(log);
        plotFunction(cubic);
        // Pause and close the canvas then terminate the program.
        canvas.pause();
        canvas.close();
    }
    
    /** Plots a given function
     * 
     * @param function - function to plot
     */
    public static void plotFunction(GetY function ) {
    	for (int x = -360; x < 360; x++) {
            canvas.plot(x, function.calcY(x));
        }
    }
}
