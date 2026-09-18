import java.util.ArrayList;

public class Event {

    private int event_Id;
    private String event_name;
    private String event_date;
    private String venue;
    private ArrayList<Participant> parts;

    public Event(int event_Id, String event_name, String event_date, String venue) {
        this.event_Id = event_Id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.venue = venue;
        this.parts = new ArrayList<Participant>();
    }

    public int get_event_Id() {
        return event_Id;
    }

    public String get_event_name() {
        return event_name;
    }

    public String get_event_date() {
        return event_date;
    }

    public String get_venue() {
        return venue;
    }

    public ArrayList<Participant> get_parts() {
        return parts;
    }

    public void addParticipant(Participant p) {
        parts.add(p);
    }

    public boolean removeParticipant(int part_Id) {
        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i).getPart_Id() == part_Id) {
                parts.remove(i);
                return true;
            }
        }
        return false;
    }

    public void printDetails() {
        System.out.println("Event ID   : " + event_Id);
        System.out.println("Event Name : " + event_name);
        System.out.println("Date       : " + event_date);
        System.out.println("Venue      : " + venue);
        System.out.println("Participants Registered : " + parts.size());
    }
}