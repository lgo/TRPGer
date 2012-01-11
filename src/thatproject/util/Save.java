package thatproject.util;

import java.io.File;
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

public class Save {

    private static String[] paths = { "data/save.xml" };
    private static int saveNum;
    private static Document document = null;

    public Save() {
        init();
    }

    /**
     * Initialization - Checks if files exists
     */
    private static void init() {
        if (fileExists(paths[0])) {

        } else {

        }
    }

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
        createSave(document, child);

        // Normalizing the DOM
        document.getDocumentElement().normalize();

        try {
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // initialize StreamResult with File object to save to file
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(document);
            transformer.transform(source, result);

            String xmlString = result.getWriter().toString();
            System.out.println(xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create document base for new character
     * 
     * @param document
     *            - Document to add to
     * @param parent
     *            - Save to append to
     */
    private static void createSave(Document d, Node parent) {
        Node stats = document.createElement("stats");
        parent.appendChild(stats);

        insertElement(d, stats, "lvl", "1");
        insertElement(d, stats, "exp", "0");
        insertElement(d, stats, "str", "1");
        insertElement(d, stats, "end", "1");
        insertElement(d, stats, "dex", "1");
        insertElement(d, stats, "luc", "1");
        insertElement(d, stats, "gold", "100");
    }

    /**
     * Insert element into parent
     * 
     * @param document
     *            - Document to add to
     * @param parent
     *            - Parent to appent elements into
     * @param element
     *            - Element to create
     * @param content
     *            - Content to insert into element
     */
    private static void insertElement(Document document, Node parent,
            String element, String content) {
        Node item = document.createElement(element);
        parent.appendChild(item);
        Node value = document.createTextNode(content);
        item.appendChild(value);
    }

}
