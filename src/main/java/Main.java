

import MODEL.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class Main {
    public static void main(String[] args) {


    }


    private static EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("nnn");
        return factory;
    }

    private static EntityManager factoryStart() {
        final EntityManagerFactory factory = entityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    private static void addUserInDb(String name, String surname, String email) {
        EntityManager manager = factoryStart();
        manager.getTransaction().begin();
        manager.persist(new User(name, surname, email));
        manager.getTransaction().commit();
        manager.close();
        entityManagerFactory().close();
    }

    private static void seeUserInDb() {
        EntityManager manager = factoryStart();
        manager.getTransaction().begin();

        Query query = manager.createQuery("select u from User u");
        List<User> list = query.getResultList();
        list.stream().forEach(System.out::println);

        manager.close();
        entityManagerFactory().close();
    }

    private static void seeUserBuIdInDb(int id) {
        EntityManager manager = factoryStart();
        manager.getTransaction().begin();
        Query query = manager.createQuery("select u from User u where u.id=:id");
        query.setParameter("id", id);
        List<User> list = query.getResultList();
        list.stream().forEach(System.out::println);

        manager.close();
        entityManagerFactory().close();
    }

    private static void seeUserBuNameInDb(String name) {
        EntityManager manager = factoryStart();
        manager.getTransaction().begin();

        Query query = manager.createQuery("select u from User u where u.name=:name");
        query.setParameter("name", name);
        List<User> list = query.getResultList();
        list.forEach(System.out::println);

        manager.close();
        entityManagerFactory().close();
    }

    private static void removeUserBuIdInDb(int id) {
        EntityManager manager = factoryStart();
        manager.getTransaction().begin();

        User user = manager.find(User.class, id);
        manager.remove(user);
        manager.getTransaction().commit();

        manager.close();
        entityManagerFactory().close();

    }

    private static void removeUserBuNameInDb(String name) {
        EntityManager manager = factoryStart();
        manager.getTransaction().begin();

        Query query = manager.createQuery("select u from User u where u.name=:name");
        query.setParameter("name", name);
        List<User> list = query.getResultList();
        list.forEach(manager::remove);
        manager.getTransaction().commit();



        manager.close();
        entityManagerFactory().close();
    }

}

