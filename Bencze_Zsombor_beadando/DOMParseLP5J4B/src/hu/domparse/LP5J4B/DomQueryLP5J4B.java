package hu.domparse.LP5J4B;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class DomQueryLP5J4B {
    public static void main(String[] args) {
        try {
            NodeList nodeList;

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Fájl beolvasása
            Document document = builder.parse(new File("XMLLP5J4B.xml"));
            document.getDocumentElement().normalize();

            // Aktuális elem meghatározása
            nodeList = document.getElementsByTagName("Product");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // Product adatainak kiirása
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int price = parseInt(element.getElementsByTagName("Price").item(0).getTextContent());

                    if (price > 3000) { // Változóba elmentem azok árát amik nagyobbak mint 3000
                        System.out.println("\nAktuális elem: " + node.getNodeName());
                        System.out.println("-------");
                        System.out.println("");
                        System.out.println("Product id: " + element.getAttribute("Pid"));
                        System.out.println("Price: " + element.getElementsByTagName("Price").item(0).getTextContent());
                        System.out.println(
                                "Descreption: " + element.getElementsByTagName("Descreption").item(0).getTextContent());
                        System.out.println("Name: " + element.getElementsByTagName("Name").item(0).getTextContent());

                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}