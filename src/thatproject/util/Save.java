package thatproject.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Save {

    private static String[] paths = { "data/save.xml" };
    private static String[] sections = { "stats", "attributes", "items" };
    private static String[] stats = { "lvl", "exp", "str", "end", "luc", "dex", "gold" };
    private static int saveNum = 0;
    private static Document document = null;
    private static NodeList save;

    public Save() {
        init();
    }

    /**
     * Initialization - Checks if files exists
     */
    private static void init() {
        if (fileExists(paths[0])) {
            openFile("data/save.xml");
        } else {
            createSave();
        }
    }

    /**
     * Opens the XML file
     * 
     * @param uri of the XML location
     */
    private static void openFile(String uri) {
        try {

            File fXmlFile = new File(uri);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            save = doc.getElementsByTagName("save0");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int[] read() {
        int[] temp = new int[10];
        for (int i = 0; i < save.getLength(); i++) {

            Node nNode = save.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                for (int j = 0; j < stats.length; j++) {
                    temp[j] = Integer.parseInt(getTagValue(stats[j], eElement));
                }
            }
        }
        return temp;
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

        Node nValue = nlList.item(0);

        return nValue.getNodeValue();
    }

    /**
     * Checks if the given file exists (Includes directories)
     * 
     * @param path to file for checking
     * @return Boolean
     */
    private static boolean fileExists(String path) {
        File f = new File(path);
        if (f.exists())
            return true;
        else
            return false;
    }

    /**
     * Save all current XML objects to disk
     */
    private void save() {
        for (String path : paths) {

        }
    }

    /**
     * Create a new save
     */
    public static void createSave() {
        DocumentBuilder builder = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // Insert Root Order
        Element root = document.createElement("Character");
        // Insert child Manifest
        document.appendChild(root);
        Node child = document.createElement("save" + saveNum);
        root.appendChild(child);
        // Insert Items
        createSave(document, child, sections);
        saveToFile();

    }

    /**
     * Create document base for new character
     * 
     * @param document - Document to add to
     * @param parent - Save to append to
     */
    private static void createSave(Document d, Node parent, String[] elements) {
        Node[] element = new Node[elements.length];
        for (int i = 0; i < elements.length; i++) {
            element[i] = document.createElement(elements[i]);
            parent.appendChild(element[i]);
        }

        insertElement(d, element[0], "lvl", "1");
        insertElement(d, element[0], "exp", "0");
        insertElement(d, element[0], "str", "1");
        insertElement(d, element[0], "end", "1");
        insertElement(d, element[0], "dex", "1");
        insertElement(d, element[0], "luc", "1");
        insertElement(d, element[0], "gold", "100");
    }

    /**
     * Saves the a string to file - Mainly for XML use
     * 
     * @param xml String to output
     */
    public static void saveToFile() {
        // Normalizing the DOM
        document.getDocumentElement().normalize();

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // initialize StreamResult with File object to save to file
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(document);
            transformer.transform(source, result);

            String xmlString = result.getWriter().toString();
            FileOutputStream fout = new FileOutputStream("data/save.xml");
            new PrintStream(fout).println(xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert element into parent
     * 
     * @param document - Document to add to
     * @param parent - Parent to appent elements into
     * @param element - Element to create
     * @param content - Content to insert into element
     */
    private static void insertElement(Document document, Node parent, String element, String content) {
        Node item = document.createElement(element);
        parent.appendChild(item);
        Node value = document.createTextNode(content);
        item.appendChild(value);
    }

}
