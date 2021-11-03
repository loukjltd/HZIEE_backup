import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Question02_02 {
    public static void main(String[] args) {
        System.out.print("请输入r的值：");
        Scanner getValueR = new Scanner(System.in);

        double targetValueR = getValueR.nextDouble();
        AlterRgbValue.alterMyImage(targetValueR);
    }
}

class AlterRgbValue {
    public static void alterMyImage (double targetValueR){
        BufferedImage getImage;
        File getNewFile;

        try {
            getNewFile = new File("/Users/loukj/Documents/GitHub/Hziee_class_code_backup/Advanced_Math/Mission_02/src/image/inImage.png");
            getImage = ImageIO.read(getNewFile);

            for (int height = 0; height < getImage.getHeight(); height ++) {
                for (int width = 0; width < getImage.getWidth(); width ++) {
                    int rgbValue = getImage.getRGB(width, height);
                    int alpha = (rgbValue >> 24) & 0xff; //透明通道
                    int red = (rgbValue >> 16) & 0xff;
                    int green = (rgbValue >> 8) & 0xff;
                    int blue = rgbValue & 0xff;
                    int alterRed = execFunction(red, targetValueR);
                    int alterGreen = execFunction(green, targetValueR);
                    int alterBlue = execFunction(blue, targetValueR);
                    rgbValue = (alpha << 24) | (alterRed << 16) | (alterGreen << 8) | alterBlue;
                    getImage.setRGB(width, height, rgbValue);
                }
            }

            getNewFile = new File("/Users/loukj/Documents/GitHub/Hziee_class_code_backup/Advanced_Math/Mission_02/src/image/outImage.png");
            ImageIO.write(getImage, "png", getNewFile);

        } catch (IOException ignored) {
        }
    }

    public static int execFunction(int x, double r) {
        return Math.min((int) Math.pow(x, r), 255);
    }
}