package com.example.tp2_najoua.configuration;

import com.example.tp2_najoua.entity.*;
import com.example.tp2_najoua.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //tiens compte de cela
public class Tp2Config implements CommandLineRunner {


    private ClientRepository clientRepository;

    private  LivreRepository livreRepository;

    private ClientOrderRepository clientOrderRepository;

    private OrderItemRepository orderItemRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public Tp2Config(ClientRepository clientRepository, LivreRepository livreRepository, ClientOrderRepository clientOrderRepository, OrderItemRepository orderItemRepository, PaymentRepository paymentRepository) {
        this.clientRepository = clientRepository;
        this.livreRepository = livreRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.orderItemRepository = orderItemRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //si la bd est vide=> remplis la
        //if (clientRepository.findAll().isEmpty()) {
            //cree la bd des clients

        orderItemRepository.deleteAllInBatch();
        clientOrderRepository.deleteAllInBatch();
        paymentRepository.deleteAllInBatch();
        clientRepository.deleteAllInBatch();
        livreRepository.deleteAllInBatch();
        createClients(clientRepository, livreRepository, clientOrderRepository, orderItemRepository);
        //}
        //si la bd est vide=> remplis la
        //if (livreRepository.findAll().isEmpty()) {
            //cree la bd des livres
            //createLivres(livreRepository);
        //}

    }

    private void createClients(ClientRepository clientRepository, LivreRepository livreRepository, ClientOrderRepository clientOrderRepository, OrderItemRepository orderItemRepository) {


        Livre livre1 = new Livre("9781449392680", "Introducing Regular Expressions", "Michael Fitzgerald", "Michael", "Fitzgerald",
                "If you&rsquo;re a programmer new to regular expressions, this easy-to-follow guide is a great place to start. You&rsquo;ll learn the fundamentals step-by-step with the help of numerous examples, discovering first-hand how to match, extract, and transform text by matching specific words, characters, and patterns.Regular expressions are an essential part of a programmer&rsquo;s toolkit, available in various Unix utlilities as well as programming languages such as Perl, Java, JavaScript, and C#. When you&rsquo;ve finished this book, you&rsquo;ll be familiar with the most commonly used syntax in regular expressions, and you&rsquo;ll understand how using them will save you considerable time.Discover what regular expressions are and how they workLearn many of the differences between regular expressions used with command-line tools and in various programming languagesApply simple methods for finding patterns in text, including digits, letters, Unicode characters, and string literalsLearn how to use zero-width assertions and lookaroundsWork with groups, backreferences, character classes, and quantifiersUse regular expressions to mark up plain text with HTML5",
                "O'Reilly Media", "2012-08-03",19.25,154);
        livreRepository.save(livre1);
        Livre livre2 = new Livre("9780521898065", "Analytic Combinatorics", "Philippe Flajolet, Robert Sedgewick", "Philippe", "Flajolet",
                "Analytic Combinatorics is a self-contained treatment of the mathematics underlying the analysis of discrete structures, which has emerged over the past several decades as an essential tool in the understanding of properties of computer programs and scientific models with applications in physics, biology and chemistry. Thorough treatment of a large number of classical applications is an essential aspect of the presentation. Written by the leaders in the field of analytic combinatorics, this text is certain to become the definitive reference on the topic. The text is complemented with exercises, examples, appendices and notes to aid understanding therefore, it can be used as the basis for an advanced undergraduate or a graduate course on the subject, or for self-study.",
                "Cambridge University Press", "2009-01-19",103,824);
        livreRepository.save(livre2);

        OrderItem orderItem1 = new OrderItem(3, livre1);
        OrderItem orderItem2 = new OrderItem(5, livre2);

        ClientOrder clientOrder1 = new ClientOrder("2023-06-11");
        clientOrder1.ajouterOrderItem(orderItem1);
        clientOrder1.ajouterOrderItem(orderItem2);

        Client client1 = new Client("Jean", "Tremblay", "jean.tremblay@example.com", "123 Rue Principale, Québec, QC");

        Client client2 = new Client("Sophie", "Bélanger", "sophie.belanger@example.com", "456 Avenue des Chênes, Montréal, QC");

        Payment payment = new Payment("numeroCarte", "2023-07-12");
        clientOrder1.setPayment(payment);

        client1.ajouterClientOrder(clientOrder1);



        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        clientOrderRepository.save(clientOrder1);


        clientRepository.save(client1);
        clientRepository.save(client2);

    }



}
