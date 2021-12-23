public class UseCamera {
    public static void main(String[] args) {
        Camera myCamera, yourCamera;
        myCamera = new Camera(true, 0);
        yourCamera = new Camera(false, 0);
        System.out.println(myCamera);
        System.out.println(yourCamera);

        myCamera.takePhotos(4);
        yourCamera.takePhotos(4);
        System.out.println(myCamera);
        System.out.println(yourCamera);

        myCamera.setOn(false);
        yourCamera.setOn(true);
        yourCamera.takePhotos(3);
        yourCamera.takePhotos(2);
        System.out.println(myCamera);
        System.out.println(yourCamera);
    }
}

class Camera {
    private boolean isOn;
    private int numPhotos;
    public Camera(boolean b, int n) {
        isOn = b;
        numPhotos = n;
    }
    public void takePhotos(int howMany) {
        if (isOn) {
            numPhotos += howMany;
        }
    }
    public void setOn(boolean b) {
        isOn = b;
    }
    public String toString() {
        return "Camera on: " + isOn + ", photos taken: " + numPhotos;
    }
}
