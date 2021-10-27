import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.Scanner;

public class Question01_02 {
    public static void main(String[] args) {
        Scanner getDelta = new Scanner(System.in);
        double targetDelta = getDelta.nextDouble();
        XYSeries functionSeries = new XYSeries("xySeries");
        for (double getT = 0; getT <= 8; getT = getT + targetDelta) {
            double getX = -2 * getT * Math.sin(getT * getT);
            functionSeries.add(getT, getX);
        }

        XYSeriesCollection functionDataset = new XYSeriesCollection();
        functionDataset.addSeries(functionSeries);
        JFreeChart functionChart = ChartFactory.createXYLineChart(
                "x(t)=-2tsin(t*t)",
                "t",
                "-2tsin(t*t)",
                functionDataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );

        XYPlot functionPlot = (XYPlot)functionChart.getPlot();
        XYLineAndShapeRenderer functionRenderer = new XYLineAndShapeRenderer();
        functionRenderer.setSeriesLinesVisible(0, true);
        functionPlot.setRenderer(functionRenderer);

        ChartFrame frame = new ChartFrame("x(t)=-2tsin(t*t)的离散曲线图", functionChart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}