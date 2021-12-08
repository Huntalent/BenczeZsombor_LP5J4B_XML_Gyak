package hu.domparse.LP5J4B;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomModifyLP5J4B {
    public static void main(String[] args) {
        NodeList nodeList;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Fájl beolvasása
            Document document = builder.parse(new File("XMLLP5J4B.xml"));
            document.getDocumentElement().normalize();
            // Aktuális elem meghatározása
            nodeList = document.getElementsByTagName("CreditCard");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                // Kártya adatainak kiirása
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Kártyaszámának eltárolása
                    String id = element.getAttribute("CardNO");

                    System.out.println("Card Number: " + element.getAttribute("CardNO"));
                    System.out.println("Type: " + element.getElementsByTagName("Type").item(0).getTextContent());
                    System.out.println("Expire: "
                            + element.getElementsByTagName("Expire").item(0).getTextContent());
                    System.out.println("Bank: " + element.getElementsByTagName("Bank").item(0).getTextContent());

                    if (id.equals("12344567893")) { // Ha igen akkor annak a lejárati dátumát megváltoztatjuk erre és
                                                    // kiírjuk egy új XML fájlba
                        ((Element) node).getElementsByTagName("Expire").item(0).setTextContent("24-10");
                    }
                }
            }
            // létrehozza az xml fájlt módositva
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source input = new DOMSource(document);
            Result output = new StreamResult(new File("XMLLP5J4BModify.xml"));
            transformer.transform(input, output);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
