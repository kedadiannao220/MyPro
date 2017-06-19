package com.pgy.yumrepo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YumRepoUtil {
    public static void main(String[] args) {
        readUrl();
        //        readFile();
    }

    public static void readUrl() {
        URL url;
        try {
            url = new URL("http://yum.idcos.net/centos/6/os/x86_64/Packages/");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(url);

            Element root = doc.getRootElement();

            System.out.println(root);
        } catch (MalformedURLException | DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void readFile() {
        File file = new File(
                "/tmp/501ad3bd2103686865891f5503f17f3d9af42830b732b7b0523b237cf4004a52-other.xml");

        SAXReader reader = new SAXReader();
        try {

            Document doc = reader.read(file);
            Element root = doc.getRootElement();

            for (Iterator i = root.elementIterator("package"); i.hasNext(); ) {
                Element el = (Element) i.next();
                // 解析package element
                //                for (int j = 0; j < el.attributeCount(); j++) {
                //                    Attribute att = el.attribute(j);
                //                    System.out.println(att.getName() + ":" + att.getStringValue());
                //                }

                // 解析version element
                Element verEl = el.element("version");
                for (int j = 0; j < verEl.attributeCount(); j++) {
                    Attribute att = verEl.attribute(j);
                    System.out.println(att.getName() + ":" + att.getStringValue());

                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Document getDocument(String filePath) {
        return getDocument(new File(filePath));
    }

    public Document getDocument(File file) {
        if (!file.exists()) {
            return null;
        }
        SAXReader reader = new SAXReader();
        try {
            return reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Element getRootElement(File file) {
        return getDocument(file).getRootElement();
    }

    public List<Element> getRootElements(List<File> fileList) {
        List<Element> els = new ArrayList<Element>();
        for (File file : fileList) {
            els.add(getRootElement(file));
        }
        return els;
    }

    public List<Attribute> getAttributes(Element el) {
        List<Attribute> atts = new ArrayList<Attribute>();
        for (int i = 0; i < el.attributeCount(); i++) {
            atts.add(el.attribute(i));
        }
        return atts;
    }
}
