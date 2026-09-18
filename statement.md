# Problem Statement

## Problem Statement
Organizing an event manually — tracking which events are happening, when, where,
and who has registered for each one — becomes hard to manage once the number of
events or participants grows. A simple, structured system is needed to record
event details and manage participant registrations without relying on scattered
notes, spreadsheets, or memory.

This project implements a **console-based Event Management System in Java** that
allows an organizer to create events, register participants against those events,
and view or remove either as needed — all through a simple menu-driven interface.

## Scope of the Project
- The system is a **single-user, console-based application** (no login/authentication).
- Data is stored **in-memory** for the duration of a single run (ArrayLists); it does
  not persist to a file or database once the program exits. This was a deliberate
  scope decision to keep the project focused on core object-oriented design rather
  than persistence, and can be extended later (see "Future Enhancements").
- The system manages two entities: **Events** and **Participants**, with a
  one-to-many relationship (one event can have many participants).
- Out of scope: authentication, GUI, editing existing event/participant details
  (only add/view/delete are supported), and multi-user/concurrent access.

## Target Users
- A small club, college department, or individual organizer who needs a simple
  way to track events and who has registered for them, without needing a full
  web application or paid software.

## High-Level Features
- Add a new event (name, date, venue)
- View all events and their registered participant counts
- Delete an event
- Register a participant against a specific event
- View all participants registered for a specific event
- Remove a participant from an event
