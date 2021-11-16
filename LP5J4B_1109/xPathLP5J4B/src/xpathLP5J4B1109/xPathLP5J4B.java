package xpathYJJLDH1109;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class xPathYJJLDH {

	 public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true); // never forget this!
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.parse("C:/xml/YJJLDH_1109/studentYJJLDH.xml");

	        //Create XPath

	        XPathFactory xpathfactory = XPathFactory.newInstance();
	        XPath xpath = xpathfactory.newXPath();

	        System.out.println("n//7) Get all");

	        // 7) Get all writers
	        XPathExpression firstNameExpr = xpath.compile("//student/vezeteknev/text()");
	        XPathExpression lastNameExpr = xpath.compile("//student/keresztnev/text()");
	        XPathExpression nickNameExpr = xpath.compile("//student/becenev/text()");
	        XPathExpression marksExpr = xpath.compile("//student/kor/text()");

	        Object firstNameResult = firstNameExpr.evaluate(doc, XPathConstants.NODESET);
	        Object lastNameResult = lastNameExpr.evaluate(doc, XPathConstants.NODESET);
	        Object nickNameResult = nickNameExpr.evaluate(doc, XPathConstants.NODESET);
	        Object marksResult = marksExpr.evaluate(doc, XPathConstants.NODESET);

	        NodeList firstNameNodes = (NodeList) firstNameResult;
	        NodeList lastNameNodes = (NodeList) lastNameResult;
	        NodeList nickNodes = (NodeList) nickNameResult;
	        NodeList marksNodes = (NodeList) marksResult;
	        System.out.println( "-------------------------------");

	        for (int i = 0; i < firstNameNodes.getLength(); i++) {
	            System.out.println( firstNameNodes.item(i).getNodeValue());
	            System.out.println(lastNameNodes.item(i).getNodeValue());
	            System.out.println( nickNodes.item(i).getNodeValue());
	            System.out.println( marksNodes.item(i).getNodeValue());
	            System.out.println( "-------------------------------");

	        }
	    }

	}

