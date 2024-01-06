import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.Vector;

public class ticketsystem {
    // default constructor
    public static void main(String[] args) throws Exception {
     String record[] = {"Sci-fi", "Horror", "Comedy", "Action"};
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "Sudip@2560");//Crating connection with database
        Statement statement = connection.createStatement();//creating statement object

        JFrame f = new JFrame("Cinema Ticket System");
        //List Movies
        JButton b = new JButton("List Movies");
        b.setBounds(10, 15, 120, 30);
        f.add(b);
        b.addActionListener(actionEvent -> {
            String line = "";
            String splitBy = ",";
            Vector v13 = null;
            Vector v11=new Vector();
            v11.addElement("ID");   //column name in JTable
            v11.addElement("NAME"); //column name in JTable
            v11.addElement("Genre"); //column name in JTable
            v13 = new Vector();
            try {
                BufferedReader br = new BufferedReader(new FileReader("movie.csv"));
                while ((line = br.readLine()) != null)
                {
                    //Get all tokens available in line
                    String[] movie = line.split(splitBy);
                    Vector v12 = new Vector();
                    v12.addElement(movie[0]);
                    v12.addElement(movie[1]);
                    v12.addElement(movie[2]);
                    v13.add(v12);

                }
            }

            catch (Exception e) {
                throw new RuntimeException(e);
            }

            JScrollPane scrollPane = new JScrollPane();
            JTable table = new JTable(v13, v11);
            scrollPane.setViewportView(table);
            scrollPane.setBounds(25, 90, 600, 600);
            f.add(scrollPane);
            f.setSize(700, 700);
            f.setVisible(true);
        });
        //Show times
        JButton show = new JButton("Show times");
        show.setBounds(135, 15, 120, 30);
        f.add(show);


        //Text Field
        JTextField showtimes;
        showtimes = new JTextField();
        show.addActionListener(actionEvent -> {

            if(!showtimes.getText().isEmpty()) {
                String str = showtimes.getText();
                PreparedStatement st = null;
                try {
                    String listquery = "select * from movies where showtime LIKE '%" + str + "%'";//Storing MySQL query in A string variable
                    ResultSet rs = statement.executeQuery(listquery);
                    Vector v3 = null;
                    Vector v1=new Vector();
                    v1.addElement("ID");   //column name in JTable
                    v1.addElement("NAME"); //column name in JTable
                    v1.addElement("Genre"); //column name in JTable
                    v1.addElement("Show Time");
                    v3 = new Vector();
                        try {
                            while (rs.next()) {
                                Vector v2 = new Vector();
                                v2.addElement(rs.getString(1));  // 8 is column number,And it depends on your query
                                v2.addElement(rs.getString(2));  // 2 is column number,And it depends on your query
                                v2.addElement(rs.getString(3));
                                v2.addElement(rs.getString(6));
                                v3.add(v2);
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    JScrollPane scrollPane2 = new JScrollPane();
                    JTable table2 = new JTable(v3, v1);
                    scrollPane2.setViewportView(table2);
                    scrollPane2.setBounds(25, 90, 600, 600);
                    f.add(scrollPane2);
                    f.setSize(700, 700);
                    f.setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
         else
                {
                    JOptionPane.showMessageDialog(null,"Please enter showtime.");
                    while(true){ //<- Runs forever
                        showtimes.requestFocusInWindow();
                        if(!showtimes.equals(""))
                            break;
                    }
                }
        });
        showtimes.setBounds(265, 15, 50, 30);
        f.add(showtimes);
        //search by name
        //Show times

        JButton serachbutton = new JButton("Search Movies");
        serachbutton.setBounds(155, 55, 150, 30);
        f.add(serachbutton);
        //Text Field

        JComboBox search = new JComboBox(record);
        serachbutton.addActionListener(actionEvent -> {

            if(!search.getSelectedItem().toString().isEmpty()) {
                String str = search.getSelectedItem().toString();
                PreparedStatement st = null;
                try {


                    String listquery = "select * from movies where genre LIKE '%" + str + "%'";//Storing MySQL query in A string variable
                    ResultSet rs = statement.executeQuery(listquery);
                    Vector v33 = null;
                    Vector v11=new Vector();
                    v11.addElement("ID");   //column name in JTable
                    v11.addElement("NAME"); //column name in JTable
                    v11.addElement("Genre"); //column name in JTable
                    v11.addElement("Show Time"); //column name in JTable
                    v33 = new Vector();
                    try {
                        while (rs.next()) {
                            Vector v22 = new Vector();
                            v22.addElement(rs.getString(1));  // 8 is column number,And it depends on your query
                            v22.addElement(rs.getString(2));  // 2 is column number,And it depends on your query
                            v22.addElement(rs.getString(3));
                            v22.addElement(rs.getString(6));
                            v33.add(v22);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    JScrollPane scrollPane3 = new JScrollPane();
                    JTable table3 = new JTable(v33, v11);
                    scrollPane3.setViewportView(table3);
                    scrollPane3.setBounds(25, 90, 600, 600);
                    f.add(scrollPane3);
                    f.setSize(700, 700);
                    f.setVisible(true);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please enter movie-name.");
                while(true){ //<- Runs forever
                    showtimes.requestFocusInWindow();
                    if(!showtimes.equals(""))
                        break;
                }
            }
        });

        search.setBounds(320, 55, 130, 30);
        f.add(search);


        //Purchase Ticket
        JButton purchase = new JButton("Purchase ticket");
        purchase.setBounds(325, 15, 150, 30);
        purchase.addActionListener(actionEvent -> {
            try {
                f.setVisible(false);
                purchase test = new purchase() ;
                test.setVisible(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        f.add(purchase);

//        show receipt
        JButton receipt = new JButton("Show receipt");
        receipt.setBounds(480, 15, 135, 30);
        receipt.addActionListener(actionEvent -> {
            try {
                f.setVisible(false);
                receipt test = new receipt() ;
                test.setVisible(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
                });
        f.add(receipt);

        JButton exit = new JButton("Exit");
        exit.setBounds(480, 55, 135, 30);
        exit.addActionListener(actionEvent -> {
            f.dispose();
        });
        f.add(exit);
        f.setSize(700, 700);
        f.setLayout(null);
        f.setVisible(true);
//        connection.close();
    }
    }
