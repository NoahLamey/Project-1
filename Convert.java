import java.io.File;
import java.io.FileWriter;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Convert {
	public static void convertFile(String filename) {
		String csvFile = "triplog.csv";
		int time = 0;
		
		try {
			File input = new File(filename);
			DocumentBuilderFactory documentBuilder = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentBuilder.newDocumentBuilder();
			org.w3c.dom.Document doc1 = builder.parse(input);
			doc1.getDocumentElement().normalize();
			NodeList list = doc1.getElementsByTagName("trkpt");
			
			FileWriter writer1 = new FileWriter(csvFile);
			writer1.append("Time,Latitude,Longitude\n");
			
			
			for(int i = 0; i < list.getLength(); i++ ) {
				Element trkptElement = (Element) list.item(i);
				String latitude = data(trkptElement.getAttribute("lat"));
				String longitude = data(trkptElement.getAttribute("lon"));
				writer1.append(time + "," + latitude + "," + longitude + "\n");
				time += 5;
			}
			writer1.flush();
			writer1.close();
			}catch(Exception e) {
				
			}
	}

	private static String data(String data) {
		String data1 = data.replace("?","", "\t").trim();
		return data1;
	}
}
