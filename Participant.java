public class Participant {

    private int part_Id;
    private String name;
    private String email;

    public Participant(int part_Id, String name, String email) {
        this.part_Id = part_Id;
        this.name = name;
        this.email = email;
    }

    public int getPart_Id() {
        return part_Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void printDetails() {
        System.out.println("Participant ID : " + part_Id);
        System.out.println("Name           : " + name);
        System.out.println("Email          : " + email);
    }
}
