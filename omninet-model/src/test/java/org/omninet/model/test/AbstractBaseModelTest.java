/**
 * 
 */
package org.omninet.model.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omninet.model.AbstractBaseModel;

/**
 * @author tfite
 *
 */
public class AbstractBaseModelTest {

    private static SessionFactory sessionFactory = null;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // A SessionFactory is set up once for an application
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(TestModel.class);
        sessionFactory = config.buildSessionFactory();
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        sessionFactory.close();
    }

    @Test
    public void test() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            TestModel test = new TestModel();
            session.save(test);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Entity
    @Table(name = "TEST")
    class TestModel extends AbstractBaseModel {

        @Id
        private long id;

        /**
         * Default Constructor
         */
        public TestModel() {
            super();
        }

    }
}
