// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class purchase
        extends JFrame
        implements ActionListener {

    // Components of the Form
    public Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel ticket;
    private JCheckBox adult;
    private JCheckBox student;
    private CheckboxGroup tickettype;
    private JLabel showdate;
    private JComboBox movie;
    private JComboBox ticketno;
    private JComboBox sticketno;
    private JComboBox date;
    private JComboBox time;
    private JComboBox month;
    private JComboBox year;
    private JLabel showtimes;

    private JCheckBox term;
    private JButton sub;
    private JButton reset;

    JTextField message;
    private JButton back;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String number[]
            = { "0","1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10"};
    private String number2[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10"};
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "2022" };
    private String showtime[] = {"8:00","11:00","3:00","6:00","10:00"};
    private String record[] = {"Spider-Man", "Inception", "Avatar", "The Conjuring", "Catch me if you can", "Joker", "Get-Out", "silent","Matrix","Baby" };
//    private String[] record;
    // constructor, to initialize the components
    // with default values.
    public purchase() throws SQLException {
        setTitle("Purchase Form");

        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Purchase Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Movie Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(200, 20);
        name.setLocation(100, 90);
        c.add(name);

        movie = new JComboBox(record);
        movie.setFont(new Font("Arial", Font.PLAIN, 15));
        movie.setSize(180, 20);
        movie.setLocation(250, 90);
        c.add(movie);

        ticket = new JLabel("Ticket Types");
        ticket.setFont(new Font("Arial", Font.PLAIN, 20));
        ticket.setSize(200, 20);
        ticket.setLocation(100, 150);
        c.add(ticket);

        adult = new JCheckBox("Adult");
        adult.setFont(new Font("Arial", Font.PLAIN, 15));
        adult.setSelected(true);
        adult.setSize(80, 20);
        adult.setLocation(250, 150);
        c.add(adult);

        ticketno = new JComboBox(number2);
        ticketno.setFont(new Font("Arial", Font.PLAIN, 15));
        ticketno.setSize(80, 20);
        ticketno.setLocation(360, 150);
        c.add(ticketno);

        student = new JCheckBox("Student");
        student.setFont(new Font("Arial", Font.PLAIN, 15));
        student.setSelected(false);
        student.setSize(120, 20);
        student.setLocation(250, 200);
        c.add(student);

        sticketno = new JComboBox(number);
        sticketno.setFont(new Font("Arial", Font.PLAIN, 15));
        sticketno.setSize(80, 20);
        sticketno.setLocation(370, 200);
        c.add(sticketno);

        tickettype = new CheckboxGroup();

        showdate = new JLabel("Show Date");
        showdate.setFont(new Font("Arial", Font.PLAIN, 20));
        showdate.setSize(150, 20);
        showdate.setLocation(100, 250);
        c.add(showdate);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(250, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(300, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(350, 250);
        c.add(year);

        showtimes = new JLabel("Show time");
        showtimes.setFont(new Font("Arial", Font.PLAIN, 20));
        showtimes.setSize(150, 20);
        showtimes.setLocation(100, 300);
        c.add(showtimes);

        time = new JComboBox(showtime);
        time.setFont(new Font("Arial", Font.PLAIN, 15));
        time.setSize(50, 20);
        time.setLocation(230, 300);
        c.add(time);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 20);
        back.setLocation(380, 450);
        back.addActionListener(this);
        c.add(back);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == sub && (adult.isSelected() || student.isSelected())) {
             {
                if (term.isSelected()) {
                    String data1 = "";
                    String data6 = "";
                    String seat = "";
                    String seat2 = "";
                    String data
                            = "Movie Name : "
                            + movie.getSelectedItem() + "\n"
                            + "Number of ticket for Adult: "
                            + ticketno.getSelectedItem() + "\n"
                            + "Number of ticket for Student: "
                            + sticketno.getSelectedItem() + "\n";
                    if (adult.isSelected() && student.isSelected()) {
                        data1 = "Seat Type : Student And Adult"
                                + "\n";
                        seat2 = "Student";
                        seat = "Adult";

                    } else if (student.isSelected()) {
                        data1 = "Seat Type : Student"
                                + "\n";
                        seat2 = "Student";
                    } else {
                        data1 = "Seat Type : Adult"
                                + "\n";
                        seat = "Adult";
                    }
                    String data2
                            = "Booking Date : "
                            + (String) date.getSelectedItem()
                            + "/" + (String) month.getSelectedItem()
                            + "/" + (String) year.getSelectedItem()
                            + "\n";
                    String date1 = (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/" + (String) year.getSelectedItem();
                    String data3 = "Show time : " + time.getSelectedItem();
                    tout.setText(data + data1 + data6 + data2 + data3);
                    tout.setEditable(false);
                    Connection connection = null;
                    try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "Sudip@2560");//Crating connection with database
                        Statement statement = connection.createStatement();//creating statement object
                        String query = "Insert into ticket(movie,no_ticket,seat_type,show_date,show_time,Number2,seattype2)"
                                + " values (?, ?, ?, ?, ?,?,?)";

                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setString(1, movie.getSelectedItem().toString());
                        preparedStmt.setString(2, ticketno.getSelectedItem().toString());
                        preparedStmt.setString(3, seat);
                        preparedStmt.setString(4, date1);
                        preparedStmt.setString(5, time.getSelectedItem().toString());
                        preparedStmt.setString(6, sticketno.getSelectedItem().toString());
                        preparedStmt.setString(7, seat2);
                        preparedStmt.execute();
//                        connection.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    res.setText("Registration Successfully..");
                } else {
                    tout.setText("");
                    resadd.setText("");
                    res.setText("Please accept the"
                            + " terms & conditions..");
                }
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            movie.setSelectedIndex(0);
            ticketno.setSelectedIndex(0);
            sticketno.setSelectedIndex(0);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            time.setSelectedIndex(0);
            resadd.setText(def);
        }
        else if (e.getSource() == back) {
            try {
//
                c.setVisible(false);
                dispose();
                ticketsystem.main(null);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please select  seat type.");
            while(true){ //<- Runs forever
                message.requestFocusInWindow();
                if(!message.equals(""))
                    break;
        }
    }
}

// Driver Code
class Registration {

    public void main(String[] args) throws Exception {
        purchase f = new purchase();
    }
}
}
