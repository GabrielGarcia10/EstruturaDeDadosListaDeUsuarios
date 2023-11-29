/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjusuarioslde;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Window;

/**
 *
 * @author Gabriel
 */
public class formUtilities {
    public static void centerScreen(Window in){
        Dimension windowsSize = in.getSize();
        GraphicsEnvironment graphicEnvironmnet = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = graphicEnvironmnet.getCenterPoint();
        
        int x = centerPoint.x - windowsSize.width / 2;
        int y = centerPoint.y - windowsSize.height / 2;
        
        in.setLocation(x, y);
    }
}
