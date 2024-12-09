import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;

public class JMeterRunner {
    public static void main(String[] args) throws Exception {
        // JMeter motorunu başlat
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // JMeter ayarlarını yükle
        String jmeterHome = "C:/Users/ASUS/OneDrive/Desktop/apache-jmeter-5.6.2/apache-jmeter-5.6.2";
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(jmeterHome + "/bin/jmeter.properties");
        SaveService.loadProperties();

        // JMX dosyasını yükle
        File testPlanFile = new File("src/test/resources/Test_Plan.jmx");
        HashTree testPlanTree = SaveService.loadTree(testPlanFile);

        // Test planını çalıştır
        jmeter.configure(testPlanTree);
        jmeter.run();
        System.out.println("Test tamamlandı.");
    }
}
