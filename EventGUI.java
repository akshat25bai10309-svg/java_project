import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EventGUI extends JFrame implements ActionListener {

    ArrayList<Event> eventList = new ArrayList<Event>();

    JTextField txtEventId = new JTextField();
    JTextField txtEventName = new JTextField();
    JTextField txtDate = new JTextField();
    JTextField txtVenue = new JTextField();

    JTextField txtPartId = new JTextField();
    JTextField txtPartName = new JTextField();
    JTextField txtEmail = new JTextField();

    JButton btnAddEvent = new JButton("Add Event");
    JButton btnViewEvents = new JButton("View All Events");
    JButton btnDeleteEvent = new JButton("Delete Event");
    JButton btnClear = new JButton("Clear");

    JButton btnAddPart = new JButton("Register Participant");
    JButton btnViewParts = new JButton("View Participants");
    JButton btnDeletePart = new JButton("Delete Participant");
    JButton btnExit = new JButton("Exit");

    JTextArea displayArea = new JTextArea();

    public EventGUI() {
        setTitle("Event Management System");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        formPanel.add(new JLabel("Event ID:"));
        formPanel.add(txtEventId);
        formPanel.add(new JLabel("Event Name:"));
        formPanel.add(txtEventName);
        formPanel.add(new JLabel("Event Date:"));
        formPanel.add(txtDate);
        formPanel.add(new JLabel("Venue:"));
        formPanel.add(txtVenue);
        formPanel.add(new JLabel("Participant ID:"));
        formPanel.add(txtPartId);
        formPanel.add(new JLabel("Participant Name:"));
        formPanel.add(txtPartName);
        formPanel.add(new JLabel("Participant Email:"));
        formPanel.add(txtEmail);

        JPanel btnPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        btnPanel.add(btnAddEvent);
        btnPanel.add(btnViewEvents);
        btnPanel.add(btnDeleteEvent);
        btnPanel.add(btnClear);
        btnPanel.add(btnAddPart);
        btnPanel.add(btnViewParts);
        btnPanel.add(btnDeletePart);
        btnPanel.add(btnExit);

        btnAddEvent.addActionListener(this);
        btnViewEvents.addActionListener(this);
        btnDeleteEvent.addActionListener(this);
        btnClear.addActionListener(this);
        btnAddPart.addActionListener(this);
        btnViewParts.addActionListener(this);
        btnDeletePart.addActionListener(this);
        btnExit.addActionListener(this);

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(btnPanel, BorderLayout.SOUTH);

        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(displayArea);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddEvent) {
            try {
                int id = Integer.parseInt(txtEventId.getText().trim());
                String name = txtEventName.getText().trim();
                String date = txtDate.getText().trim();
                String venue = txtVenue.getText().trim();

                if (name.equals("") || date.equals("") || venue.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter all event details.");
                    return;
                }

                for (int i = 0; i < eventList.size(); i++) {
                    if (eventList.get(i).get_event_Id() == id) {
                        JOptionPane.showMessageDialog(this, "Event with this ID already exists!");
                        return;
                    }
                }

                Event ev = new Event(id, name, date, venue);
                eventList.add(ev);
                JOptionPane.showMessageDialog(this, "Event added successfully!");
                txtEventId.setText("");
                txtEventName.setText("");
                txtDate.setText("");
                txtVenue.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Event ID must be a valid number!");
            }
        } else if (e.getSource() == btnViewEvents) {
            displayArea.setText("");
            if (eventList.size() == 0) {
                displayArea.append("No events found.\n");
                return;
            }
            for (int i = 0; i < eventList.size(); i++) {
                Event ev = eventList.get(i);
                displayArea.append("-----------------------------------\n");
                displayArea.append("Event ID   : " + ev.get_event_Id() + "\n");
                displayArea.append("Event Name : " + ev.get_event_name() + "\n");
                displayArea.append("Date       : " + ev.get_event_date() + "\n");
                displayArea.append("Venue      : " + ev.get_venue() + "\n");
                displayArea.append("Participants Registered : " + ev.get_parts().size() + "\n");
            }
            displayArea.append("-----------------------------------\n");
        } else if (e.getSource() == btnDeleteEvent) {
            try {
                int id = Integer.parseInt(txtEventId.getText().trim());
                boolean found = false;
                for (int i = 0; i < eventList.size(); i++) {
                    if (eventList.get(i).get_event_Id() == id) {
                        eventList.remove(i);
                        found = true;
                        JOptionPane.showMessageDialog(this, "Event deleted successfully!");
                        txtEventId.setText("");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "Event not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter Event ID to delete!");
            }
        } else if (e.getSource() == btnAddPart) {
            try {
                int eventId = Integer.parseInt(txtEventId.getText().trim());
                int partId = Integer.parseInt(txtPartId.getText().trim());
                String name = txtPartName.getText().trim();
                String email = txtEmail.getText().trim();

                if (name.equals("") || email.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter participant name and email.");
                    return;
                }

                Event targetEvent = null;
                for (int i = 0; i < eventList.size(); i++) {
                    if (eventList.get(i).get_event_Id() == eventId) {
                        targetEvent = eventList.get(i);
                        break;
                    }
                }

                if (targetEvent == null) {
                    JOptionPane.showMessageDialog(this, "Event not found.");
                    return;
                }

                Participant p = new Participant(partId, name, email);
                targetEvent.addParticipant(p);
                JOptionPane.showMessageDialog(this, "Participant registered successfully!");
                txtPartId.setText("");
                txtPartName.setText("");
                txtEmail.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid Event ID and Participant ID!");
            }
        } else if (e.getSource() == btnViewParts) {
            try {
                int eventId = Integer.parseInt(txtEventId.getText().trim());
                Event targetEvent = null;
                for (int i = 0; i < eventList.size(); i++) {
                    if (eventList.get(i).get_event_Id() == eventId) {
                        targetEvent = eventList.get(i);
                        break;
                    }
                }

                if (targetEvent == null) {
                    JOptionPane.showMessageDialog(this, "Event not found.");
                    return;
                }

                displayArea.setText("");
                ArrayList<Participant> parts = targetEvent.get_parts();
                if (parts.size() == 0) {
                    displayArea.append("No participants registered for this event.\n");
                    return;
                }

                displayArea.append("Participants for " + targetEvent.get_event_name() + ":\n");
                for (int i = 0; i < parts.size(); i++) {
                    Participant p = parts.get(i);
                    displayArea.append("-----------------------------------\n");
                    displayArea.append("Participant ID : " + p.getPart_Id() + "\n");
                    displayArea.append("Name           : " + p.getName() + "\n");
                    displayArea.append("Email          : " + p.getEmail() + "\n");
                }
                displayArea.append("-----------------------------------\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter Event ID to view participants!");
            }
        } else if (e.getSource() == btnDeletePart) {
            try {
                int eventId = Integer.parseInt(txtEventId.getText().trim());
                int partId = Integer.parseInt(txtPartId.getText().trim());

                Event targetEvent = null;
                for (int i = 0; i < eventList.size(); i++) {
                    if (eventList.get(i).get_event_Id() == eventId) {
                        targetEvent = eventList.get(i);
                        break;
                    }
                }

                if (targetEvent == null) {
                    JOptionPane.showMessageDialog(this, "Event not found.");
                    return;
                }

                boolean removed = targetEvent.removeParticipant(partId);
                if (removed) {
                    JOptionPane.showMessageDialog(this, "Participant removed successfully!");
                    txtPartId.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Participant not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid Event ID and Participant ID!");
            }
        } else if (e.getSource() == btnClear) {
            txtEventId.setText("");
            txtEventName.setText("");
            txtDate.setText("");
            txtVenue.setText("");
            txtPartId.setText("");
            txtPartName.setText("");
            txtEmail.setText("");
            displayArea.setText("");
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new EventGUI();
    }
}
