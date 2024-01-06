// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;

class receipt
        extends JFrame
        {

            private JLabel ticket;
            private JLabel type;
            private JLabel showdate;

            private JLabel showtimes;
            private JLabel price;

            private JButton back;
            private JButton back2;
    // Components of the Form
    public Container c;
    private JLabel title;
    private JLabel name;

    // constructor, to initialize the components
    // with default values.
    public receipt() throws SQLException {

        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "Sudip@2560");//Crating connection with database
        Statement statement = connection.createStatement();//creating statement object
        String query = "select movie, no_ticket, seat_type,show_date,show_time,Number2,seattype2 from ticket";//Storing MySQL query in A string variable
        ResultSet results = statement.executeQuery(query);//executing query and storing result in ResultSet
//        Class.forName("com.mysql.jdbc.Driver").newInstance();
        if (!results.next()) {
//            System.out.printf(results.getString("movie"));
        }
        setTitle("Ticket Receipt");

        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Ticket Receipt");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Movie Name: " + results.getString("movie"));
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(400, 100);
        name.setLocation(100, 90);
        c.add(name);

        ticket = new JLabel("Number of Ticket for Adults:" + results.getString("no_ticket"));
        ticket.setFont(new Font("Arial", Font.PLAIN, 20));
        ticket.setSize(400, 50);
        ticket.setLocation(100, 150);
        c.add(ticket);

        ticket = new JLabel("Number of Ticket for Students:" + results.getString("Number2"));
        ticket.setFont(new Font("Arial", Font.PLAIN, 20));
        ticket.setSize(450, 150);
        ticket.setLocation(100, 150);
        c.add(ticket);

        type = new JLabel("Seat Type:" + results.getString("seat_type")+ "\t\t\t" +  results.getString("seattype2"));
        type.setFont(new Font("Arial", Font.PLAIN, 20));
        type.setSize(400, 200);
        type.setLocation(100, 200);
        c.add(type);


        showdate = new JLabel("Show Date:" + results.getString("show_date"));
        showdate.setFont(new Font("Arial", Font.PLAIN, 20));
        showdate.setSize(650, 20);
        showdate.setLocation(100, 250);
        c.add(showdate);

        showtimes = new JLabel("Show time:" + results.getString("show_time"));
        showtimes.setFont(new Font("Arial", Font.PLAIN, 20));
        showtimes.setSize(800, 80);
        showtimes.setLocation(100, 300);
        c.add(showtimes);

        int prices= 15*Integer.parseInt(results.getString("no_ticket"))+10*Integer.parseInt(results.getString("Number2"));
        price = new JLabel("Total Price(GBP) :" + prices);
        price.setFont(new Font("Arial", Font.PLAIN, 20));
        price.setSize(800, 80);
        price.setLocation(100, 350);
        c.add(price);

        back = new JButton("Print file");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 20);
        back.setLocation(380, 450);
//        back.addActionListener(this);
        Connection finalConnection = connection;
        back.addActionListener(actionEvent -> {
//            HashMap hm = new HashMap<>();
//            System.out.println("hello");
            PrintWriter out = null; // Step 2
            try {

                out = new PrintWriter("receipt.txt");


                    // Write the name of four oceans to the file
                    out.println("Movie Name: " + results.getString("movie"));   // Step 3
                    out.println("Adult Tickets: " + results.getString("no_ticket"));
                    out.println("Students Tickets: " + results.getString("Number2"));
                    out.println("Seat Type: " + results.getString("seat_type") + results.getString("seattype2"));
                    out.println("Show Date: " + results.getString("show_date"));
                    out.println("Show Time: " + results.getString("show_time"));
                    out.println("Price(GBP): " + prices);
                    out.close();



//                out.close();
                JOptionPane.showMessageDialog(null, "Sucessful");
                while (true) { //<- Runs forever
                    showtimes.requestFocusInWindow();
                    dispose();
                    ticketsystem.main(null);
                    if (!showtimes.equals(""))
                        break;
                }
//                finalConnection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        c.add(back);
        back2 = new JButton("Back");
        back2.setFont(new Font("Arial", Font.PLAIN, 15));
        back2.setSize(100, 20);
        back2.setLocation(500, 450);
        back2.addActionListener(actionEvent -> {
            dispose();
            try {
                ticketsystem.main(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        c.add(back2);
    }


    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    }

// Driver Code
class register2 {

    public static void main(String[] args) throws Exception
    {
        receipt f = new receipt();
    }
}
