package com.lazycece.commons.utils.xmlc;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author lazycece
 * @date 2018/4/6
 */
public class XmlUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

    /**
     * write writexml file according to the <obj>elementNode</obj>
     * @see ElementNode
     *
     * @param elementNode  writexml content
     * @param filePath file path for save
     * @throws Exception
     */
    public static void writeXml(ElementNode elementNode, String filePath) throws Exception {

        Document document = createDocumentTree(elementNode);

        LOGGER.info("begin write writexml");
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        OutputFormat of = new OutputFormat();
        of.setEncoding("utf-8");
        of.setIndent(true);
        of.setIndent("  ");
        of.setNewlines(true);
        XMLWriter writer = new XMLWriter(osw, of);
        writer.write(document);
        writer.close();
        LOGGER.info("end write writexml");
    }

    private static Document createDocumentTree(ElementNode elementNode) {
        LOGGER.info("create document begin");
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("utf-8");
        if (elementNode == null) {
            LOGGER.error("null elementNode");
            throw new XmlIOException("null elementNode");
        }
        if (StringUtils.isBlank(elementNode.getName())) {
            LOGGER.error("root node label name is null");
            throw new XmlIOException("root node label name is null");
        }
        Element root = document.addElement(elementNode.getName());
        addNameSpace(root, elementNode.getNameSpaces());
        addAttribute(root, elementNode.getAttributes());
        addText(root, elementNode.getValue());
        addCDATA(root, elementNode.getcData());
        addChildren(root, elementNode.getChildren());
        LOGGER.info("create document end");
        return document;
    }

    private static void addNameSpace(Element element, List<NameSpace> nameSpaces) {
        for (NameSpace nameSpace : nameSpaces) {
            if (StringUtils.isNotBlank(nameSpace.getName())) {
                element.addNamespace(nameSpace.getName(), nameSpace.getValue());
            }
        }
    }

    private static void addAttribute(Element element, List<Attribute> attributes) {
        for (Attribute attribute : attributes) {
            if (StringUtils.isNotBlank(attribute.getName())) {
                element.addAttribute(attribute.getName(), attribute.getValue());
            }
        }
    }

    private static void addText(Element element, String text) {
        if (StringUtils.isNotBlank(text)) {
            element.addText(text);
        }
    }

    private static void addCDATA(Element element, String data) {
        if (StringUtils.isNotBlank(data)) {
            element.addCDATA(data);
        }
    }

    private static void addChildren(Element element, List<ElementNode> children) {
        for (ElementNode elementNode : children) {
            if (StringUtils.isBlank(elementNode.getName())) {
                LOGGER.error("node label name is null");
                throw new XmlIOException("node label name is null");
            }
            Element child = element.addElement(elementNode.getName());
            addNameSpace(child, elementNode.getNameSpaces());
            addAttribute(child, elementNode.getAttributes());
            addText(child, elementNode.getValue());
            addCDATA(child, elementNode.getcData());
            addChildren(child, elementNode.getChildren());
        }
    }
}