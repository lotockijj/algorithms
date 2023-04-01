package army;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

public class Test {
   /* public static void main(String[] args) throws  ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        StringBuilder xmlStringBuilder = new StringBuilder();
        String appendage = Constants.XML_CONTENT; //This string holds the xml formatted data I'll be
        //using in a long annoying line, I'll include it
        //separately for clarity
        xmlStringBuilder.append(appendage);
        ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));

        System.out.println("Test Results:");
        System.out.println();

        Document doc = builder.parse(input);
        Element root = doc.getDocumentElement();
        NodeList children = root.getChildNodes();

        System.out.println(root.getTagName());
        System.out.println();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child instanceof Element) {
                Element childElement = (Element) child;
                System.out.println(childElement.getTagName() + " " + childElement);

                NodeList grandChildren = child.getChildNodes();
                for (int x = 0; x < grandChildren.getLength(); x++) {
                    Node grandChild = grandChildren.item(x);
                    if (grandChild instanceof Element) {
                        Element grandChildElement = (Element) grandChild;
                        System.out.print("\t" + grandChildElement.getTagName() + ":\t");

                        NodeList greatGrandChildren = grandChild.getChildNodes();
                        for (int y = 0; y < greatGrandChildren.getLength(); y++) {
                            Node greatGrandChild = greatGrandChildren.item(y);
                            if (greatGrandChild instanceof Element) {
                                Element greatGrandChildElement = (Element) greatGrandChild;
                                System.out.print(" " + greatGrandChildElement.getTextContent());
                                if ( y < greatGrandChildren.getLength() - 1) { System.out.print(","); } }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
*/

   private static String string = "Формуляр %s,  акт технічного стану _____ від ________ . \n";
   private static String passport = "МОУ 030548\n" +
           "не було \n" +
           "БЕ 090658\n" +
           "МОУ 000127\n" +
           "БЕ 086424\n" +
           "ВА 051627\n";
   private static String vins = "110468042\n" +
           "б/н\n" +
           "110168043\n" +
           "38501011Б\n" +
           "68905024\n" +
           "68905015\n";

    public static void main(String[] args) {
        String[] split = vins.split("\n");
        String[] splitPassport = passport.split("\n");
        for (int i = 0; i < split.length; i++) {
            System.out.printf(string, splitPassport[i]);
        }
    }

}