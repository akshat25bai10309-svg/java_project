import java.util.ArrayList;
import java.util.Scanner;

public class EventManager {

    private ArrayList<Event> events;
    private Scanner sc;

    public EventManager(Scanner sc) {
        this.events = new ArrayList<Event>();
        this.sc = sc;
    }

    public void addEvent() {
        System.out.print("Enter Event ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Event Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Event Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();

        Event event = new Event(id, name, date, venue);
        events.add(event);
        System.out.println("Event added successfully!");
    }

    public void viewAllEvents() {
        if (events.size() == 0) {
            System.out.println("No events found.");
            return;
        }

        for (int i = 0; i < events.size(); i++) {
            System.out.println("-----------------------------------");
            events.get(i).printDetails();
        }
        System.out.println("-----------------------------------");
    }

    public void deleteEvent() {
        if (events.size() == 0) {
            System.out.println("No events found.");
            return;
        }

        System.out.print("Enter Event ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).get_event_Id() == id) {
                events.remove(i);
                found = true;
                System.out.println("Event deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Event not found.");
        }
    }

    public void registerParticipant() {
        if (events.size() == 0) {
            System.out.println("No events found.");
            return;
        }

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();

        Event event = null;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).get_event_Id() == eventId) {
                event = events.get(i);
                break;
            }
        }

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter Participant ID: ");
        int partId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Participant Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Participant Email: ");
        String email = sc.nextLine();

        Participant p = new Participant(partId, name, email);
        event.addParticipant(p);
        System.out.println("Participant registered successfully!");
    }

    public void viewParticipantsOfEvent() {
        if (events.size() == 0) {
            System.out.println("No events found.");
            return;
        }

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();

        Event event = null;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).get_event_Id() == eventId) {
                event = events.get(i);
                break;
            }
        }

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        ArrayList<Participant> parts = event.get_parts();
        if (parts.size() == 0) {
            System.out.println("No participants registered for this event.");
            return;
        }

        System.out.println("Participants for " + event.get_event_name() + ":");
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("-----------------------------------");
            parts.get(i).printDetails();
        }
        System.out.println("-----------------------------------");
    }

    public void deleteParticipant() {
        if (events.size() == 0) {
            System.out.println("No events found.");
            return;
        }

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();

        Event event = null;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).get_event_Id() == eventId) {
                event = events.get(i);
                break;
            }
        }

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter Participant ID to delete: ");
        int partId = sc.nextInt();

        boolean removed = event.removeParticipant(partId);
        if (removed) {
            System.out.println("Participant removed successfully!");
        } else {
            System.out.println("Participant not found.");
        }
    }
}
