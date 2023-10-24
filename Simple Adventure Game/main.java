import java.util.Scanner;

public class TextAdventure {

    private static final Scanner scanner = new Scanner(System.in);

    private static Room currentRoom;

    public static void main(String[] args) {
        currentRoom = new Room("Starting room");

        gameLoop();
    }

    private static void gameLoop() {
        while (true) {
            System.out.println("You are in " + currentRoom.getName());
            System.out.println("What do you want to do?");

            String command = scanner.nextLine();

            switch (command) {
                case "go north":
                    currentRoom = currentRoom.getNorthRoom();
                    break;
                case "go south":
                    currentRoom = currentRoom.getSouthRoom();
                    break;
                case "go east":
                    currentRoom = currentRoom.getEastRoom();
                    break;
                case "go west":
                    currentRoom = currentRoom.getWestRoom();
                    break;
                case "examine":
                    System.out.println(currentRoom.getDescription());
                    break;
                default:
                    System.out.println("I don't understand that command.");
            }
        }
    }

    private static class Room {

        private final String name;
        private final String description;
        private final Room northRoom;
        private final Room southRoom;
        private final Room eastRoom;
        private final Room westRoom;

        public Room(String name) {
            this.name = name;
            this.description = "";
            this.northRoom = null;
            this.southRoom = null;
            this.eastRoom = null;
            this.westRoom = null;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Room getNorthRoom() {
            return northRoom;
        }

        public Room getSouthRoom() {
            return southRoom;
        }

        public Room getEastRoom() {
            return eastRoom;
        }

        public Room getWestRoom() {
            return westRoom;
        }

        public void setNorthRoom(Room northRoom) {
            this.northRoom = northRoom;
        }

        public void setSouthRoom(Room southRoom) {
            this.southRoom = southRoom;
        }

        public void setEastRoom(Room eastRoom) {
            this.eastRoom = eastRoom;
        }

        public void setWestRoom(Room westRoom) {
            this.westRoom = westRoom;
        }
    }
}
