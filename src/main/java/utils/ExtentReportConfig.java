package utils;

public class ExtentReportConfig {

    public static void setReportName(String name) {

        System.setProperty("extent.reporter.spark.start", "true");
        System.setProperty("extent.reporter.spark.out", "./target/report/"+name+"/"+name+".html");
        System.setProperty("screenshot.dir", "./target/report/"+name+"/"+"Screenshots/");
        System.setProperty("screenshot.rel.path", "../"+name+"/"+"Screenshots/");

    }
}
