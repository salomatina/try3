package ru.mephi;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.ArrayList;

public class XMLPars {

    ArrayList<Reactor> xmlReactors;

    public void read(String directory) throws FileNotFoundException, XMLStreamException {
        xmlReactors = new ArrayList<>();
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(directory));
            String type = "";
            double burnup = 0;
            double kpd = 0;
            double enrichment = 0;
            double termalCapacity = 0;
            double electricalCapacity = 0;
            double lifeTime = 0;
            double firstLoad = 0;
            String source = "XML";
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement start = xmlEvent.asStartElement();
//                    if (start.getName().getLocalPart().equals("ReactorType")) {
//                    }
                    if (start.getName().getLocalPart().equals("type")) {
                        xmlEvent = reader.nextEvent();
                        type = (xmlEvent.asCharacters().getData());
                        System.out.println(type);
                    } else if (start.getName().getLocalPart().equals("burnup")) {
                        xmlEvent = reader.nextEvent();
                        burnup = (Double.parseDouble(xmlEvent.asCharacters().getData()));
                        System.out.println(burnup);
                    } else if (start.getName().getLocalPart().equals("kpd")) {
                        xmlEvent = reader.nextEvent();
                        kpd = (Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("enrichment")) {
                        xmlEvent = reader.nextEvent();
                        enrichment = (Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("termalCapacity")) {
                        xmlEvent = reader.nextEvent();
                        termalCapacity = (Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("electricalCapacity")) {
                        xmlEvent = reader.nextEvent();
                        electricalCapacity = (Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("lifeTime")) {
                        xmlEvent = reader.nextEvent();
                        lifeTime = (Double.parseDouble(xmlEvent.asCharacters().getData()));
                    } else if (start.getName().getLocalPart().equals("firstLoad")) {
                        xmlEvent = reader.nextEvent();
                        firstLoad = (Double.parseDouble(xmlEvent.asCharacters().getData()));
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("ReactorType")) {
                        Reactor reactor = new Reactor(type, burnup, kpd, enrichment, termalCapacity, electricalCapacity,
                                lifeTime, firstLoad, source);
                        xmlReactors.add(reactor);
                    }
                }
            }
    }
}
