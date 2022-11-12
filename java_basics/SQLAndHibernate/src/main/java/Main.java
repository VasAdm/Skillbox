import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static final Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    private static final SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    private static final Session session = sessionFactory.openSession();


    public static void main(String[] args) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        List<PurchaseList> subscriptionList = session.createQuery(query).getResultList();
        subscriptionList.forEach(sub -> createRecordToLpl(sub.getStudent().getId(), sub.getCourse().getId()));

        sessionFactory.close();
        session.close();
    }

//    private static void getRecord(String studentName, String courseName) {
//        String hql = "From " + Subscription.class.getSimpleName();
//        List<Subscription> subscriptions = session.createQuery(hql).getResultList();
//        subscriptions.forEach(sub -> {
//            if (sub.getStudent().getName().equals(studentName) && sub.getCourse().getName().equals(courseName)) {
//                Student student = sub.getStudent();
//                Course course = sub.getCourse();
//                createRecordToLpl(student.getId(), course.getId());
//            }
//        });
//    }

    private static void createRecordToLpl(int studentId, int courseId) {
        Transaction transaction = session.beginTransaction();

        LinkedPurchaseList list = new LinkedPurchaseList();
        list.setCourseId(courseId);
        list.setStudentId(studentId);
        list.setId(new LinkedPurchaseList.LinkedPurchaseListKey(studentId, courseId));
        session.save(list);

        transaction.commit();
    }
}