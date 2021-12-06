package hu.domparse.LP5J48;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DomReadLP5J48 {
    public static void main(String[] args){
        NodeList list;
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=factory.newDocumentBuilder();
            //fájl beolvasása
            Document document=documentBuilder.parse(new File("XMLLP5J48.xml"));
            document.getDocumentElement().normalize();
            //Gyökér elem megkeresése
            System.out.println("Root element : " + document.getDocumentElement().getNodeName());
            System.out.println("----------------");
            //Aktuális elem meghatározása
            list=document.getElementsByTagName("car");

            for (int i=0;i<list.getLength();i++) {
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //car adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Plate Number: " + element.getAttribute("PlateNo"));
                    System.out.println("CID: " + element.getAttribute("CID"));
                    System.out.println("Brand: "
                            + element.getElementsByTagName("Brand").item(0).getTextContent());
                    System.out.println("Modell: "
                            + element.getElementsByTagName("Modell").item(0).getTextContent());
                    System.out.println("Produced: "
                            + element.getElementsByTagName("Produced").item(0).getTextContent());
                }
            }
            //Aktuális elem meghatározása
            list=document.getElementsByTagName("CreditCard");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Kártya adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("CardNumber: " + element.getAttribute("CardNO"));
                    System.out.println("CID: " + element.getAttribute("CID"));
                    System.out.println("Type: " + element.getElementsByTagName("Type").item(0).getTextContent());
                    System.out.println("Expire: " + element.getElementsByTagName("Expire").item(0).getTextContent());
                    System.out.println("Bank: " + element.getElementsByTagName("Bank").item(0).getTextContent());
                }
            }
            //Aktuális elem meghatározása
            list=document.getElementsByTagName("Costumer");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Costumer adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("CID: " + element.getAttribute("CID"));
                    System.out.println("Email: " + element.getElementsByTagName("email").item(0).getTextContent());
                    System.out.println("passwd: " + element.getElementsByTagName("passwd").item(0).getTextContent());
                    System.out.println("Username: " + element.getElementsByTagName("UserName").item(0).getTextContent());

                    //Costumer nevének adatai kiirása
                    Node nodenev=list.item(i);
                    if(nodenev.getNodeType()==Node.ELEMENT_NODE){
                        Element elementnev=(Element) node;
                        System.out.println("Születési idő: " + elementnev.getElementsByTagName("FirstName").item(0).getTextContent());
                        System.out.println("Születési hely: " + elementnev.getElementsByTagName("LastName").item(0).getTextContent());
                    }

                    //Costumer cimének kiratása
                    Node nodeaddress=list.item(i);
                    if(nodeaddress.getNodeType()==Node.ELEMENT_NODE){
                        Element elementaddress=(Element) node;
                        System.out.println("Country: " + elementaddress.getElementsByTagName("country").item(0).getTextContent());
                        System.out.println("County: " + elementaddress.getElementsByTagName("County").item(0).getTextContent());
                        System.out.println("Zip: " + elementaddress.getElementsByTagName("Zip").item(0).getTextContent());
                        System.out.println("City: " + elementaddress.getElementsByTagName("City").item(0).getTextContent());
                        System.out.println("Street: " + elementaddress.getElementsByTagName("Street").item(0).getTextContent());
                        System.out.println("StreetNo: " + elementaddress.getElementsByTagName("StreetNo").item(0).getTextContent());
                    }
                }
            }
            //Aktuális elem meghatározása
            list=document.getElementsByTagName("Request");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Request adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("ReqID: " + element.getAttribute("ReqID"));
                    System.out.println("CID: " + element.getAttribute("CID"));
                    System.out.println("PID: " + element.getAttribute("PID"));
                    System.out.println("ShipMode: " + element.getElementsByTagName("ShipMode").item(0).getTextContent());
                    System.out.println("Price: " + element.getElementsByTagName("Price").item(0).getTextContent());
                    System.out.println("ShipPrice: " + element.getElementsByTagName("ShipPrice").item(0).getTextContent());
                    System.out.println("PayMode: " + element.getElementsByTagName("PayMode").item(0).getTextContent());

                }
            }
            //Aktuális elem meghatározása
            list=document.getElementsByTagName("Rate");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Rate adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("PID: " + element.getAttribute("PID"));
                    System.out.println("Rid: " + element.getAttribute("RiD"));
                    System.out.println("Who: " + element.getElementsByTagName("Who").item(0).getTextContent());
                    System.out.println("Rate: " + element.getElementsByTagName("Ratee").item(0).getTextContent());
                }
            }
            //Aktuális elem meghatározása
            list=document.getElementsByTagName("Product");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Prooduct adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Product id: " + element.getAttribute("Pid"));
                    System.out.println("Price: " + element.getElementsByTagName("Price").item(0).getTextContent());
                    System.out.println("Descreption: " + element.getElementsByTagName("Descreption").item(0).getTextContent());
                    System.out.println("Name: " + element.getElementsByTagName("Name").item(0).getTextContent());
                }
            }

            //Aktuális elem meghatározása
            list=document.getElementsByTagName("CarType");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Cartype adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("CTID: " + element.getAttribute("CTID"));
                    System.out.println("PID: " + element.getAttribute("PID"));
                    System.out.println("Produced: " + element.getElementsByTagName("Produced").item(0).getTextContent());
                    System.out.println("Brand: " + element.getElementsByTagName("Brand").item(0).getTextContent());
                }
            }

            //Aktuális elem meghatározása
            list=document.getElementsByTagName("Picture");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Picture adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Picture id: " + element.getAttribute("PicID"));
                    System.out.println("PID: " + element.getAttribute("PID"));
                    System.out.println("Title: " + element.getElementsByTagName("Title").item(0).getTextContent());
                    System.out.println("FilePath: " + element.getElementsByTagName("filePath").item(0).getTextContent());
                    System.out.println("Caption: " + element.getElementsByTagName("Caption").item(0).getTextContent());
                }
            }

            //Aktuális elem meghatározása
            list=document.getElementsByTagName("Order");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Order adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("OrID: " + element.getAttribute("OrID"));
                    System.out.println("PID: " + element.getAttribute("PID"));
                    System.out.println("SID: " + element.getAttribute("SiD"));
                    System.out.println("PartName: " + element.getElementsByTagName("PartName").item(0).getTextContent());
                    System.out.println("CarType: " + element.getElementsByTagName("CarTypok").item(0).getTextContent());
                    System.out.println("Price: " + element.getElementsByTagName("Price").item(0).getTextContent());
                }
            }

            //Aktuális elem meghatározása
            list=document.getElementsByTagName("Supplier");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Supplier adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("SID: " + element.getAttribute("SID"));
                    System.out.println("Name: " + element.getElementsByTagName("Name").item(0).getTextContent());


                    //Costumer cimének kiratása
                    Node nodeaddress=list.item(i);
                    if(nodeaddress.getNodeType()==Node.ELEMENT_NODE){
                        Element elementaddress=(Element) node;
                        System.out.println("Country: " + elementaddress.getElementsByTagName("country").item(0).getTextContent());
                        System.out.println("County: " + elementaddress.getElementsByTagName("County").item(0).getTextContent());
                        System.out.println("Zip: " + elementaddress.getElementsByTagName("Zip").item(0).getTextContent());
                        System.out.println("City: " + elementaddress.getElementsByTagName("City").item(0).getTextContent());
                        System.out.println("Street: " + elementaddress.getElementsByTagName("Street").item(0).getTextContent());
                        System.out.println("StreetNo: " + elementaddress.getElementsByTagName("StreetNo").item(0).getTextContent());
                    }
                }
            }

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
