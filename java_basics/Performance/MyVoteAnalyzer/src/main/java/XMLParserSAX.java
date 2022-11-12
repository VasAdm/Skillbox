import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;

public class XMLParserSAX extends DefaultHandler {
    private static Session session;
    private static Transaction transaction;
    private static Voter voter;
    private static int counter;
    private static final int BATCH_SIZE = 1000;

    public XMLParserSAX() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        counter = 0;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("voter")) {

            try {
                voter = new Voter(attributes.getValue("name"), attributes.getValue("birthDay"));
                session.persist(voter);
                counter++;
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (counter > 0 && counter % BATCH_SIZE == 0) {
                session.flush();
                session.clear();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        voter = null;
    }

    @Override
    public void endDocument() {
        transaction.commit();
        session.close();
    }
}
