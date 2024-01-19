package main;

import DAO.ProductDAO;
import entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product("marque", "ref1", new Date(), 105.0, 10);
        Product product2 = new Product("marque2", "ref1", new Date(), 150.0, 10);
        Product product3 = new Product("marque3", "ref1", new Date(), 20.0, 10);
        Product product4 = new Product("marque4", "ref1", new Date(), 10.0, 10);
        Product product5 = new Product("marque5", "ref1", new Date(), 10.0, 10);


       ProductDAO dao = new ProductDAO();
      /*   dao.AddProduct(product1);
        dao.AddProduct(product2);
        dao.AddProduct(product3);
        dao.AddProduct(product4);
        dao.AddProduct(product5);


        System.out.println(dao.ShowInformation(2L));

   dao.DeleteProduct(3L);

        Product product = dao.ShowInformation(1L);
        product.setPrix(200.0);
        dao.UpdateProduct(product, 1L);

        List<Product> listProduit = dao.ShowAllProduct();
        for (Product i : listProduit) {
            System.out.println(i);
        }


        List<Product> list1 = dao.ShowProductsByCost(100.0);
        for (Product i : list1) {
            System.out.println(i);
        }
        */
/*
        System.out.println("Veuillez donner une date");
        Scanner scanner = new Scanner(System.in);
        String dateUn = scanner.nextLine();
        String dateDeux = scanner.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = format.parse(dateUn);
            Date date2 = format.parse(dateDeux);

            List<Product> listProduitDate =  dao.ShowProductsByDate(date1, date2);
            for (Product i : listProduitDate) {
                System.out.println(i);
            }


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        */



  /*  System.out.println("Veuillez donner un nombre (stock)");
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        List<Product> listProduitDate =  dao.ShowProductsByStock(s);
        System.out.println(listProduitDate); */


       /* System.out.println("Veuillez saisir la marque");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Product> listProduitByMarque = dao.ShowProductsByMarque(s);
        System.out.println(listProduitByMarque); */


        /* System.out.println("Veuillez saisir la marque");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Product> listProduit = dao.ShowListProductByMarque(s);
        System.out.println(listProduit); */

        System.out.println(dao.CountCost());

    }
}
