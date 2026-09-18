import java.util.ArrayList;
import java.util.Scanner;
 
public class EventManager {
 
    private ArrayList<Event> events;
    private int nextEventId;       
    private int nextParticipantId; 
    private Scanner sc;
 
    
    public EventManager(Scanner sc) {
        events = new ArrayList<Event>();
        nextEventId = 1;
        nextParticipantId = 1;
        this.sc = sc;
    }
 
    public void addEvent() {
        System.out.print("Enter the Event Name: ");
        String name = sc.nextLine();
 
        System.out.print("Enter the Event Date (dd-mm-yyyy): ");
        String date = sc.nextLine();
 
        System.out.print("Enter the Venue: ");
        String venue = sc.nextLine();
 
        Event newEvent = new Event(nextEventId, name, date, venue);
        events.add(newEvent);
 
        System.out.println("Event added successfully! Event ID = " + nextEventId);
        nextEventId++;
    }
 
    public void viewAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found. Please add an event first.");
            return;
        }
 
        System.out.println("\n---- LIST OF EVENTS ----");
        for (int i = 0; i < events.size(); i++) {
            System.out.println("-------------------------");
            events.get(i).printDetails();
        }
        System.out.println("-------------------------");
    }
 
    public void deleteEvent() {
        if (events.isEmpty()) {
            System.out.println("No events to delete.");
            return;
        }
 
        System.out.print("Enter Event ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
 
        Event eventToDelete = findEventById(id);
 
        if (eventToDelete == null) {
            System.out.println("Event with ID " + id + " not found.");
        } else {
            events.remove(eventToDelete);
            System.out.println("Event deleted successfully.");
        }
    }
 
    // Helper method - finds an event object using its ID
    // Returns null if not found
    private Event findEventById(int id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).get_event_Id() == id) {
                return events.get(i);
            }
        }
        return null;
    }
 
    // ---------- PARTICIPANT RELATED METHODS ----------
 
    public void registerParticipant() {
        if (events.isEmpty()) {
            System.out.println("No events available. Please add an event first.");
            return;
        }
 
        viewAllEvents();
 
        System.out.print("Enter Event ID to register participant for: ");
        int eventId = Integer.parseInt(sc.nextLine());
 
        Event event = findEventById(eventId);
 
        if (event == null) {
            System.out.println("Invalid Event ID.");
            return;
        }
 
        System.out.print("Enter Participant Name: ");
        String name = sc.nextLine();
 
        System.out.print("Enter Participant Email: ");
        String email = sc.nextLine();
 
        Participant p = new Participant(nextParticipantId, name, email);
        event.addParticipant(p);
 
        System.out.println("Participant registered successfully! Participant ID = " + nextParticipantId);
        nextParticipantId++;
    }
 
    public void viewParticipantsOfEvent() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
 
        System.out.print("Enter Event ID to view participants: ");
        int eventId = Integer.parseInt(sc.nextLine());
 
        Event event = findEventById(eventId);
 
        if (event == null) {
            System.out.println("Invalid Event ID.");
            return;
        }
 
        ArrayList<Participant> parts = event.get_parts();
 
        if (parts.isEmpty()) {
            System.out.println("No participants registered for this event yet.");
            return;
        }
 
        System.out.println("\n---- PARTICIPANTS FOR EVENT: " + event.get_event_name() + " ----");
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("-------------------------");
            parts.get(i).printDetails();
        }
        System.out.println("-------------------------");
    }
 
    public void deleteParticipant() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
 
        System.out.print("Enter Event ID: ");
        int eventId = Integer.parseInt(sc.nextLine());
 
        Event event = findEventById(eventId);
 
        if (event == null) {
            System.out.println("Invalid Event ID.");
            return;
        }
 
        System.out.print("Enter Participant ID to remove: ");
        int participantId = Integer.parseInt(sc.nextLine());
 
        boolean removed = event.removeParticipant(participantId);
 
        if (removed) {
            System.out.println("Participant removed successfully.");
        } else {
            System.out.println("Participant ID not found for this event.");
        }
    }
}
 
