//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import demo.DemoPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class Main extends ApplicationFrame {
    public Main(String var1) {
        super(var1);
        GetData();
        JPanel var2 = createDemoPanel();
        this.getContentPane().add(var2);
    }
    private void GetData() {
        DecimalFormat df = new DecimalFormat("#.###");
        Scanner scan = new Scanner(System.in);
        System.out.println("Для завершения ввода введите любой символ (кроме цифровых, я цифровые не понимаю(с))");
        String result_data = "";
        boolean end_of_insertion = false;
        double var = 0.0;
        while (!end_of_insertion) {
            String source_data = scan.next();
            try {
                var = (Double.parseDouble(source_data));
                result_data += source_data + ",";
            } catch (NumberFormatException nfe) {
                System.out.println("Выход из программы");
                end_of_insertion = true;
            }
        }
        System.out.println(result_data);
        String[] items = result_data
                .replaceAll("\\s", "") // \\s+ --> replaces 1 or more spaces. \\\\s+ --> replaces the literal \ followed by s one or more times.
                .split(",");
        double[] result = new double[items.length];
        double summa = 0;
        for (int i = 0; i < items.length; i++) {
            try {
                result[i] = 1 / (Double.parseDouble(items[i]) * 3);
                System.out.println("1/(" + Double.parseDouble(items[i]) + " * 3):\t" + df.format(result[i]));
                summa += result[i];
            } catch (NumberFormatException nfe) {
                System.out.println("Something went wrong");
            }
            ;
        }
        System.out.println("Sum = " + df.format(summa));
    }



    public static JPanel createDemoPanel() {
        return new Main.MyDemoPanel();
    }

    public static void main(String[] var0) {
        Main var1 = new Main("JFreeChart: Main.java");
        var1.pack();
        RefineryUtilities.centerFrameOnScreen(var1);
        var1.setVisible(true);
    }

    static class MyDemoPanel extends DemoPanel {
        private XYDataset data1 = this.createSampleData();

        public MyDemoPanel() {
            super(new BorderLayout());
            this.add(this.createContent());
        }

        private XYDataset createSampleData() {
            XYSeries var1 = new XYSeries("Series 1");
            var1.add(2.0D, 56.27D);
            var1.add(3.0D, 41.32D);
            var1.add(4.0D, 31.45D);
            var1.add(5.0D, 30.05D);
            var1.add(6.0D, 24.69D);
            var1.add(7.0D, 19.78D);
            var1.add(8.0D, 20.94D);
            var1.add(9.0D, 16.73D);
            var1.add(10.0D, 14.21D);
            var1.add(11.0D, 12.44D);
            XYSeriesCollection var2 = new XYSeriesCollection(var1);
            XYSeries var3 = new XYSeries("Series 2");
            var3.add(11.0D, 56.27D);
            var3.add(10.0D, 41.32D);
            var3.add(9.0D, 31.45D);
            var3.add(8.0D, 30.05D);
            var3.add(7.0D, 24.69D);
            var3.add(6.0D, 19.78D);
            var3.add(5.0D, 20.94D);
            var3.add(4.0D, 16.73D);
            var3.add(3.0D, 14.21D);
            var3.add(2.0D, 12.44D);
            var2.addSeries(var3);
            return var2;
        }

        private JTabbedPane createContent() {
            JTabbedPane var1 = new JTabbedPane();
            var1.add("Splines:", this.createChartPanel1());
            var1.add("Lines:", this.createChartPanel2());
            return var1;
        }

        private ChartPanel createChartPanel1() {
            NumberAxis var1 = new NumberAxis("X");
            var1.setAutoRangeIncludesZero(false);
            NumberAxis var2 = new NumberAxis("Y");
            var2.setAutoRangeIncludesZero(false);
            XYSplineRenderer var3 = new XYSplineRenderer();
            XYPlot var4 = new XYPlot(this.data1, var1, var2, var3);
            var4.setBackgroundPaint(Color.lightGray);
            var4.setDomainGridlinePaint(Color.white);
            var4.setRangeGridlinePaint(Color.white);
            var4.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));
            JFreeChart var5 = new JFreeChart("XYSplineRenderer", JFreeChart.DEFAULT_TITLE_FONT, var4, true);
            this.addChart(var5);
            ChartUtilities.applyCurrentTheme(var5);
            ChartPanel var6 = new ChartPanel(var5);
            return var6;
        }

        private ChartPanel createChartPanel2() {
            NumberAxis var1 = new NumberAxis("X");
            var1.setAutoRangeIncludesZero(false);
            NumberAxis var2 = new NumberAxis("Y");
            var2.setAutoRangeIncludesZero(false);
            XYLineAndShapeRenderer var3 = new XYLineAndShapeRenderer();
            XYPlot var4 = new XYPlot(this.data1, var1, var2, var3);
            var4.setBackgroundPaint(Color.lightGray);
            var4.setDomainGridlinePaint(Color.white);
            var4.setRangeGridlinePaint(Color.white);
            var4.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));
            JFreeChart var5 = new JFreeChart("XYLineAndShapeRenderer", JFreeChart.DEFAULT_TITLE_FONT, var4, true);
            this.addChart(var5);
            ChartUtilities.applyCurrentTheme(var5);
            ChartPanel var6 = new ChartPanel(var5);
            return var6;
        }
    }
}
