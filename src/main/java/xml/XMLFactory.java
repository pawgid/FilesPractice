package xml;

import com.sun.xml.internal.stream.XMLInputFactoryImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLFactory <T> {

    private Class<T> type;

    public XMLFactory(Class<T> type) {
        this.type = type;
    }

    public T XMLToObject(String xml) {
        T object = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(type);
            XMLInputFactory xif = XMLInputFactory.newInstance();
            StringReader stringReader = new StringReader(xml);
            XMLStreamReader xsr = null;
            try {
                xsr = xif.createXMLStreamReader(stringReader);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            object = (T) unmarshaller.unmarshal(xsr);
            return object;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }

    public String objectToXML(T object) {
        String result = null;

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(type);

        Marshaller m = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(object, stringWriter);
        result = stringWriter.toString();
        return result;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
