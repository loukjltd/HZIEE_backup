import java.awt.Font;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;

public class Question01_03 {
    public static void main(String[] args) {
        AffineTransform targetAfTf = new AffineTransform();
        Font targetFont = new Font("HarmonyOS Sans SC", Font.BOLD, 36);
        FontRenderContext targetFtRdCt = new FontRenderContext(targetAfTf, true, true);
        GlyphVector targetGV = targetFont.createGlyphVector(targetFtRdCt, "楼可嘉");
        Shape targetShape = targetGV.getOutline(5, 40);

        int totalWidth = 200, totalHeight = 50;
        boolean[][] targetView = new boolean[totalWidth][totalHeight];

        for (int i = 0; i < totalWidth; i++) {
            for (int j = 0; j < totalHeight; j++) {
                targetView[i][j] = targetShape.contains(i, j);
            }
        }

        for (int j = 0; j < totalHeight; j++) {
            for (int i = 0; i < totalWidth; i++) {
                if (targetView[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}