import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Question02 {
    public static void main(String args[]) throws IOException {
        System.out.println("请输入r的值：");
        Scanner sc=new Scanner(System.in);
        double r=sc.nextDouble();
        Pixel pixel=new Pixel();
        Pixel.changeImage(r);
    }
}
class Pixel{
    public static void changeImage(double r){
        BufferedImage image = null;
        File file = null;
        try {
            file = new File("image/inImage.png");
            image = ImageIO.read(file);
            for (int j = 0; j < image.getHeight(); j++) {
                for (int i = 0; i < image.getWidth(); i++) {
                    int p = image.getRGB(i, j);
                    int alpha = (p >> 24) & 0xff;
                    int red = (p >> 16) & 0xff;
                    int green = (p >> 8) & 0xff;
                    int blue = p & 0xff;
                    int changeRed=changePixel(red,r);
                    int changeGreen=changePixel(green,r);
                    int changeBlue=changePixel(blue,r);
                    p = (alpha << 24) | (changeRed << 16) | (changeGreen << 8) | changeBlue;
                    image.setRGB(i, j, p);
                }
            }
            file = new File("image/outImage.png");
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static int changePixel(int x,double r){
        if ((int)Math.pow(x,r)>255) return 255;
        else return (int)Math.pow(x,r);
    }
}