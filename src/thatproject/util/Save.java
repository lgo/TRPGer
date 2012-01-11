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
    private int saveNun;
    private Document document = null;

    public Save() {
        init();
    }

    private void init() {
        if (fileExists(paths[0])) {

        } else {

        }
    }

    private boolean fileExists(String path) {
        File f = new File(path);
        if (f.exists())
            return true;
        else
            return false;
    }

    private void save() {
        for (String path : paths) {

        }
    }

    public void createSave() {
        DocumentBuilder builder = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // Insert Root Order
        Element root = (Element) document.createElement("Character");
        // Insert child Manifest
        document.appendChild(root);
        Node manifestChild = document.createElement("save"+saveNum);
        root.appendChild(manifestChild);
        // Insert Items
        insertItem(document, manifestChild, "101", "Name one", "$29.99");
        insertItem(document, manifestChild, "108", "Name two", "$19.99");
        insertItem(document, manifestChild, "125", "Name three", "$39.99");
        insertItem(document, manifestChild, "143", "Name four", "$59.99");
        insertItem(document, manifestChild, "118", "Name five", "$99.99");

        // Normalizing the DOM
        document.getDocumentElement().normalize();
        
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        //initialize StreamResult with File object to save to file
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
     * Insert "Item" to Document
     * 
     * @param document
     *            - Order Document
     * @param parent
     *            - Node where to insert a "Item"
     * @param id
     *            - Item's ID
     * @param name
     *            - Item's Name
     * @param price
     *            - Item's Price
     */
    private void insertItem(Document document, Node parent, String id,
            String name, String price) {
        // Insert child Item
        Node itemChild = document.createElement("Item");
        parent.appendChild(itemChild);

        // Insert child ID
        Node item = document.createElement("ID");
        itemChild.appendChild(item);
        // Insert ID value
        Node value = document.createTextNode(id);
        item.appendChild(value);

        // Insert child NAME
        item = document.createElement("NAME");
        itemChild.appendChild(item);
        // Insert NAME value
        value = document.createTextNode(name);
        item.appendChild(value);

        // Insert child PRICE
        item = document.createElement("PRICE");
        itemChild.appendChild(item);
        // Insert PRICE value
        value = document.createTextNode(price);
        item.appendChild(value);
    }

}
