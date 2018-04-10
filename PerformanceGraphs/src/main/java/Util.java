import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.util.ArrayUtilities;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.util.*;


public class Util {

    public static void main(String[] args) {
        double[][] array = {
                { 2.552, 7.252, 4.234, 3.831, 1.242},
                { 8.542, 4.252, 9.823, 7.421, 3.764},
        };

        Create create = new Create();
        Contains contains = new Contains();
        Remove remove = new Remove();
        /*
        drawDiagram(create.arrayMaker(), "Array filling times");
        drawDiagram(create.arrayListMaker(), "Array list filling times");
        drawDiagram(create.linkedListMaker(), "Linked list filling times");
        drawDiagram(create.hashSetMaker(), "Hash set filling times");
        drawDiagram(create.treeSetMaker(), "Tree set filling times");
        */
        drawDiagram(contains.arrayContains(), "Array contains times");
        drawDiagram(contains.arrayListContains(), "Array list contains times");
        drawDiagram(contains.linkedListContains(), "Linked list contains times");
        drawDiagram(contains.hashSetContains(), "Hash set contains times" );
        drawDiagram(contains.treeSetContains(), "Tree set contains times");
        /*
        drawDiagram(remove.arrayRemove(), "Array remove times");
        drawDiagram(remove.arrayListRemove(), "Array list remove times");
        drawDiagram(remove.linkedListRemove(), "Linked list remove times" );
        drawDiagram(remove.hashSetRemove(69), "Hash set remove times");
        drawDiagram(remove.treeSetRemove(69), "Tree set remove times");
        */
    }

    public static void showChart(JFreeChart chart) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Charts");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                ChartPanel cp = new ChartPanel(chart);

                frame.getContentPane().add(cp);
            }
        });
    }

    public static void drawDiagram(double[][] data, String name) {
        // Diagram elkeszitese
        DefaultXYDataset ds = new DefaultXYDataset();
        ds.addSeries(name, data);
        JFreeChart chart = ChartFactory.createXYLineChart(name, "input size", "time", ds,
                PlotOrientation.VERTICAL, true, true, false);

        LogarithmicAxis xAxis = new LogarithmicAxis("input size");

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);

        // Diagram megjelenitese
        showChart(chart);
    }
}