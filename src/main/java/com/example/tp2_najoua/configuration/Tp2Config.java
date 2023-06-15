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


        orderItemRepository.deleteAllInBatch();
        clientOrderRepository.deleteAllInBatch();
        paymentRepository.deleteAllInBatch();
        clientRepository.deleteAllInBatch();
        livreRepository.deleteAllInBatch();
        createClients(clientRepository, livreRepository, clientOrderRepository, orderItemRepository, paymentRepository);

    }

    private void createClients(ClientRepository clientRepository, LivreRepository livreRepository, ClientOrderRepository clientOrderRepository, OrderItemRepository orderItemRepository, PaymentRepository paymentRepository) {
        //Insertion des livres dans la Bd
        Livre livre1 = new Livre("9781449392680", "Introducing Regular Expressions", "Michael Fitzgerald", "Michael", "Fitzgerald",
                "If you&rsquo;re a programmer new to regular expressions, this easy-to-follow guide is a great place to start. You&rsquo;ll learn the fundamentals step-by-step with the help of numerous examples, discovering first-hand how to match, extract, and transform text by matching specific words, characters, and patterns.Regular expressions are an essential part of a programmer&rsquo;s toolkit, available in various Unix utlilities as well as programming languages such as Perl, Java, JavaScript, and C#. When you&rsquo;ve finished this book, you&rsquo;ll be familiar with the most commonly used syntax in regular expressions, and you&rsquo;ll understand how using them will save you considerable time.Discover what regular expressions are and how they workLearn many of the differences between regular expressions used with command-line tools and in various programming languagesApply simple methods for finding patterns in text, including digits, letters, Unicode characters, and string literalsLearn how to use zero-width assertions and lookaroundsWork with groups, backreferences, character classes, and quantifiersUse regular expressions to mark up plain text with HTML5",
                "O'Reilly Media", "2012-08-03",19.25,154);
        livreRepository.save(livre1);
        Livre livre2 = new Livre("9780521898065", "Analytic Combinatorics", "Philippe Flajolet, Robert Sedgewick", "Philippe", "Flajolet",
                "Analytic Combinatorics is a self-contained treatment of the mathematics underlying the analysis of discrete structures, which has emerged over the past several decades as an essential tool in the understanding of properties of computer programs and scientific models with applications in physics, biology and chemistry. Thorough treatment of a large number of classical applications is an essential aspect of the presentation. Written by the leaders in the field of analytic combinatorics, this text is certain to become the definitive reference on the topic. The text is complemented with exercises, examples, appendices and notes to aid understanding therefore, it can be used as the basis for an advanced undergraduate or a graduate course on the subject, or for self-study.",
                "Cambridge University Press", "2009-01-19",103,824);
        livreRepository.save(livre2);
        Livre livre3 = new Livre("9780135188149", "Database Concepts", "David M. Kroenke, David J. Auer, Scott L. Vandenberg, Robert C. Yoder", "David", "Kroenke",
                "For courses in database management. Hands-on exploration of database fundamentals Database Concepts offers students practical help creating and managing small databases, from two of the world's leading database authorities. The text focuses on database concepts, rather than features and functions of a particular product, making it flexible enough to work with the instructor's preferred software. Data sets for three sample databases run throughout portions of the text so students can practice working with complete databases. Three running projects challenge learners to apply concepts and techniques to real business situations. In the 9th edition, Microsoft® Office 2019, and particularly Microsoft Access(tm) 2019, is now the basic software used and is shown running on Microsoft Windows(tm) 10.",
                "Pearson Education", "2019-04-23",69,552);
        livreRepository.save(livre3);
        Livre livre4 = new Livre("9780321714121", "C++ Templates", "David Vandevoorde, Nicolai M. Josuttis, DougLas Gregor", "David", "Vandevoorde",
                "Templates are among the most powerful features of C++, but they remain misunderstood and underutilized, even as the C++ language and development community have advanced. In C++ Templates, Second Edition, three pioneering C++ experts show why, when, and how to use modern templates to build software that's cleaner, faster, more efficient, and easier to maintain.   Now extensively updated for the C++11, C++14, and C++17 standards, this new edition presents state-of-the-art techniques for a wider spectrum of applications. The authors provide authoritative explanations of all new language features that either improve templates or interact with them, including variadic templates, generic lambdas, class template argument deduction, compile-time if, forwarding references, and user-defined literals. They also deeply delve into fundamental language concepts (like value categories) and fully cover all standard type traits.   The book starts with an insightful tutorial on basic concepts and relevant language features. The remainder of the book serves as a comprehensive reference, focusing first on language details and then on coding techniques, advanced applications, and sophisticated idioms. Throughout, examples clearly illustrate abstract concepts and demonstrate best practices for exploiting all that C++ templates can do. Understand exactly how templates behave, and avoid common pitfalls Use templates to write more efficient, flexible, and maintainable software Master today''s most effective idioms and techniques Reuse source code without compromising performance or safety Benefit from utilities for generic programming in the C++ Standard Library Preview the upcoming concepts feature The companion website, tmplbook.com, contains sample code and additional updates.",
                "Addison Wesley Professional", "2017-09-08",104,832);
        livreRepository.save(livre4);
        Livre livre5 = new Livre("9781118554937", "Numerical Methods for Engineers and Scientists", "Amos Gilat", "Amos", "Gilat",
                "Numerical Methods for Engineers and Scientists, 3rd Edition provides engineers with a more concise treatment of the essential topics of numerical methods while emphasizing MATLAB use. The third edition includes a new chapter, with all new content, on Fourier Transform and a new chapter on Eigenvalues (compiled from existing Second Edition content). The focus is placed on the use of anonymous functions instead of inline functions and the uses of subfunctions and nested functions. This updated edition includes 50% new or updated Homework Problems, updated examples, helping engineers test their understanding and reinforce key concepts.",
                "Wiley", "2013-10-14",72,576);
        livreRepository.save(livre5);
        Livre livre6 = new Livre("9780672337307", "Unix in 24 Hours, Sams Teach Yourself: Covers OS X, Linux, and Solaris (5th Edition)", "Dave Taylor", "Dave", "Taylor",
                "Learn to use Unix, OS X, or Linux quickly and easily!     In just 24 lessons of one hour or less, Sams Teach Yourself Unix in 24 Hours helps you get up and running with Unix and Unix-based operating systems such as Mac OS X and Linux.   Designed for beginners with no previous experience using Unix, this book’s straightforward, step-by-step approach makes it easy to learn.   Each lesson clearly explains essential Unix tools and techniques from the ground up, helping you to become productive as quickly and efficiently as possible.     Step-by-step instructions carefully walk you through the most common Unix tasks.  Practical, hands-on examples show you how to apply what you learn.  Quizzes and exercises help you test your knowledge and stretch your skills.  Notes and tips point out shortcuts and solutions     Learn how to…    Pick the command shell that’s best for you Organize the Unix file system (and why) Manage file and directory ownership and permissions Maximize your productivity with power filters and pipes Use the vi and emacs editors Create your own commands and shell scripts Connect to remote systems using SSH and SFTP Troubleshoot common problems List files and manage disk usage Get started with Unix shell programming Set up printing in a Unix environment Archive and back up files Search for information and files Use Perl as an alternative Unix programming language Set up, tweak, and make use of the GNOME graphical environment   Contents at a Glance       HOUR 1: What Is This Unix Stuff?  HOUR 2: Getting onto the System and Using the Command Line  HOUR 3: Moving About the File System    HOUR 4: Listing Files and Managing Disk Usage    HOUR 5: Ownership and Permissions  HOUR 6: Creating, Moving, Renaming, and Deleting Files and Directories    HOUR 7: Looking into Files    HOUR 8: Filters, Pipes, and Wildcards!    HOUR 9: Slicing and Dicing Command-Pipe Data    HOUR 10: An Introduction to the vi Editor    HOUR 11: Advanced vi Tricks, Tools, and Techniquess    HOUR 12: An Overview of the emacs Editor    HOUR 13: Introduction to Command Shells    HOUR 14: Advanced Shell Interaction    HOUR 15: Job Control    HOUR 16: Shell Programming Overview    HOUR 17: Advanced Shell Programming    HOUR 18: Printing in the Unix Environment    HOUR 19: Archives and Backups    HOUR 20: Using Email to Communicate    HOUR 21: Connecting to Remote Systems Using SSH and SFTP  HOUR 22: Searching for Information and Files  HOUR 23: Perl Programming in Unix    HOUR 24: GNOME and the GUI Environment    Appendix A: Common Unix Questions and Answers",
                "Sams Publishing", "2015-10-11",62,496);
        livreRepository.save(livre6);


        //Insertion des OrderItem de 2 clients
        //orderItems du client1
        OrderItem orderItem1 = new OrderItem(3, livre1);
        OrderItem orderItem2 = new OrderItem(5, livre2);
        OrderItem orderItem3 = new OrderItem(1,livre6);
        //orderItems du client2
        OrderItem orderItem4 = new OrderItem(1, livre1);
        OrderItem orderItem5 = new OrderItem(1,livre6);


        //Insertion des ClientOrder de 2 clients
        //ClientOrder du client1
        ClientOrder clientOrder1 = new ClientOrder("2023-06-11");
        clientOrder1.ajouterOrderItem(orderItem1);
        clientOrder1.ajouterOrderItem(orderItem2);
        clientOrder1.ajouterOrderItem(orderItem3);
        //ClientOrder du client2
        ClientOrder clientOrder2 = new ClientOrder("2023-06-14");
        clientOrder2.ajouterOrderItem(orderItem4);
        clientOrder2.ajouterOrderItem(orderItem5);


        //Insertion des payment de 2 client
        //Payment du client 1 et ajouter au clientOrder1
        Payment payment1 = new Payment("numeroCarte", "2023-07-12");
        clientOrder1.setPayment(payment1);
        //Payment du client 2 et ajouter au clientOrder2
        Payment payment2 = new Payment("mastercard", "2028-12-15");
        clientOrder2.setPayment(payment2);


        //Insertion des clients dans la Bd
        Client client1 = new Client("Jean", "Tremblay", "jean.tremblay@example.com", "123 Rue Principale, Québec, QC");
        Client client2 = new Client("Sophie", "Bélanger", "sophie.belanger@example.com", "456 Avenue des Chênes, Montréal, QC");
        Client client3 = new Client ("Gabriel", "Leclerc", "gabriel.leclerc@example.com", "789 Boulevard du Lac, Sherbrooke, QC");
        Client client4 = new Client("Léa", "Gagnon", "lea.gagnon@example.com", "321 Rue Saint-Paul, Trois-Rivières, QC");
        Client client5 = new Client("Olivier", "Fortin", "olivier.fortin@example.com", "987 Chemin de la Montagne, Québec, QC");
        Client client6 = new Client("Camille", "Morin", "camille.morin@example.com", "654 Boulevard Saint-Joseph, Gatineau, QC");


        //Ajouter les clientOrder au client
        client1.ajouterClientOrder(clientOrder1);
        client2.ajouterClientOrder(clientOrder2);


        //Sauvegarde de tous les données dans la Bd
        //sauvegarde des orderItem
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        orderItemRepository.save(orderItem3);
        orderItemRepository.save(orderItem4);
        orderItemRepository.save(orderItem5);
        //sauvegarde des payment
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
        //sauvegarde des clientOrder
        clientOrderRepository.save(clientOrder1);
        clientOrderRepository.save(clientOrder2);
        //sauvegarde des clients
        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        clientRepository.save(client4);
        clientRepository.save(client5);
        clientRepository.save(client6);

    }



}
