package com.lazycece.commons.utils.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2018/4/6
 */
public class ElementNode {

    private String name;
    private List<NameSpace> nameSpaces;
    private List<Attribute> attributes;
    private String value;
    private String cData;
    private List<ElementNode> children;

    public ElementNode() {
        this.nameSpaces = new ArrayList<>();
        this.attributes = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public ElementNode(String name, List<NameSpace> nameSpaces, List<Attribute> attributes,
                       String value, String cData, List<ElementNode> children) {
        this.name = name;
        this.nameSpaces = nameSpaces;
        this.attributes = attributes;
        this.value = value;
        this.cData = cData;
        this.children = children;
    }

    public String getcData() {
        return cData;
    }

    public void setcData(String cData) {
        this.cData = cData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NameSpace> getNameSpaces() {
        return nameSpaces;
    }

    public void setNameSpaces(List<NameSpace> nameSpaces) {
        this.nameSpaces = nameSpaces;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ElementNode> getChildren() {
        return children;
    }

    public void setChildren(List<ElementNode> children) {
        this.children = children;
    }

    public void addNameSpace(NameSpace nameSpace) {
        this.nameSpaces.add(nameSpace);
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    public void addChild(ElementNode child) {
        this.children.add(child);
    }

}
