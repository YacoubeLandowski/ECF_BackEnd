package DAO;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProductDAO {


    private StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private SessionFactory  sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    public void AddProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }




    public Product ShowInformation (Long id) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);

        session.close();

        return product;

    }

    public void DeleteProduct(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);

        session.getTransaction().commit();
        session.close();
    }


    public void UpdateProduct(Product product, long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        product.setId(id);
        if (session.load(Product.class, id) == null ) {
            session.close();
            return;
        }


        session.update(product);

        session.getTransaction().commit();
        session.close();
    }

    public List<Product> ShowAllProduct() {
        Session session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("from Product");

        List<Product> productList = productQuery.list();

        session.close();
        return productList;
    }


    public List<Product> ShowProductsByCost(double prix) {
        Session session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("from Product where prix > :p").setParameter("p", prix);

        List<Product> productList = productQuery.list();

        session.close();
        return productList;
    }


    public List<Product> ShowProductsByDate(Date date1, Date date2) {
        Session session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("from Product where dateAchat between :d1 AND :d2  ");
        productQuery.setParameter("d1", date1);
        productQuery.setParameter("d2", date2);

        List<Product> productList = productQuery.list();
        session.close();
        return productList;
    }


    public List<Product> ShowProductsByStock(int stock) {
        Session session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("SELECT reference, id from Product where stock < :s").setParameter("s", stock);

        List<Product> productList = productQuery.list();

        session.close();
        return productList;
    }

    public List<Product> ShowProductsByMarque(String marque) {
        Session session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("SELECT stock from Product where marque = :m").setParameter("m", marque);

        List<Product> productList = productQuery.list();

        session.close();
        return productList;
    }


    public List<Product> ShowListProductByMarque(String marque) {
        Session session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("from Product where marque = :m").setParameter("m", marque);

        List<Product> productList = productQuery.list();

        session.close();
        return productList;
    }



    public int DeleteListProductByMarque(String marque) {
        Session session = sessionFactory.openSession();
        Query productQuery = session.createQuery("DELETE from Product where marque = :m").setParameter("m", marque);

        int productList = productQuery.executeUpdate();

        session.close();
        return productList;
    }


    public Double CountCost() {
        Session session = sessionFactory.openSession();
        Query<Double> m = session.createQuery("SELECT avg(prix) FROM Product ");

        Double moyenne = m.getSingleResult();
        session.close();
        return moyenne;
    }
}
