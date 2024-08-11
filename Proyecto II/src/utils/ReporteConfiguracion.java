package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReporteConfiguracion {
	
	public static JasperPrint generarReporte(String filename, 
			JRBeanCollectionDataSource dataSource, HashMap<String, Object> parameters) {
		
		JasperPrint jasperPrint = null;
		
		try {
			
			FileInputStream file = new FileInputStream(filename);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(file);
			JasperReport jasperReport = (JasperReport) 
					JRLoader.loadObject(bufferedInputStream);
			
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return jasperPrint;
		
	}
	
}
