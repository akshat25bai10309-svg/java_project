# Event Management System

A basic Java desktop application to create and manage events along with participant registrations using a Swing GUI.

## Features

- Add new events with event ID, name, date, and venue
- View a list of all existing events
- Delete events by event ID
- Register participants with ID, name, and email under specific events
- View participants registered for a particular event
- Remove participants from events
- Clear form fields and output screen

## Project Structure

- `Main.java` - Entry point of the program that starts the application.
- `EventGUI.java` - GUI interface created using Java Swing (JFrame, JPanel, ActionListener).
- `Event.java` - Represents an event and handles participant storage for that event.
- `Participant.java` - Represents an individual participant with ID, name, and email.
- `EventManager.java` - Console-based event manager logic.

## Requirements

- Java Development Kit (JDK 8 or higher)

## How to Run

1. Open your terminal or command prompt in the project folder.
2. Compile all the Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java Main
   ```

You can also run the GUI directly using:
```bash
java EventGUI
```
