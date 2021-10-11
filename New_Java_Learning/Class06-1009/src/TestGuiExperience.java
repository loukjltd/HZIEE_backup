import javax.swing.*;

public class TestGuiExperience extends JFrame {
    TestGuiExperience() {
        setTitle("First GUI Program");
        setLocation(600, 400);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn001 = new JButton("Button");
        add(btn001);
    }
}

class LaunchProgram {
    public static void main(String[] args) {
        TestGuiExperience frm001 = new TestGuiExperience();
        frm001.setVisible(true);
    }
}
