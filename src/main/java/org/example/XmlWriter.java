package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger log = Logger.getLogger(XmlWriter.class.getName());
    private static final String ROOT_XML = "src/main/xmlReqs/req_" + LocalDate.now() + "_.xml";
    private XmlWriter(){
    }

    public static void createXmlFiles(DataForXmlJsonFile dataForXmlJsonFile){
        File dir = new File("src/main/xmlReqs");
        if (!dir.exists()){
            dir.mkdirs();
        }
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(DataForXmlJsonFile.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(dataForXmlJsonFile, new File(ROOT_XML));
            log.info("XML файл успешно создан");
        } catch (JAXBException e) {
            e.printStackTrace();
            log.severe("Ошибка создания XML файла");
        }
    }
}
