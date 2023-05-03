import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingRoom {
    Scanner sc = new Scanner(System.in);

    public void start() {
        BookingRoom bkRoom = new BookingRoom();
        bkRoom.userPersonalInfo();
        bkRoom.bookRoom();
    }

    public void userPersonalInfo() {
        try {
            System.out.println("Welcome to Rose Hotel.");
            System.out.print("Please enter your name: ");
            String userName = sc.nextLine();
            System.out.print("Please enter your phone number: ");
            Long userContactNum = sc.nextLong();
        }
        catch (NumberFormatException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void bookRoom(){
        ArrayList<Room> rooms = new ArrayList<>(); 

        //room structure 
        //for 1st floor
        for (int i = 101; i <= 120; i++){
            Room room = new Room ("Single", i);
            rooms.add(room);
        }
        for (int i = 121; i <= 141; i++){
            Room room = new Room ("Double", i);
            rooms.add(room);
        }
        for (int i = 142; i <= 152; i++){
            Room room = new Room ("Suite", i);
            rooms.add(room);
        }
        //for 2nd floor 
        for (int i = 201; i <= 216; i++){
            Room room = new Room ("Single", i);
            rooms.add(room);
        }
        for (int i = 217; i <= 232; i++){
            Room room = new Room ("Double", i);
            rooms.add(room);
        }
        for (int i = 233; i <= 248; i++){
            Room room = new Room ("Suite", i);
            rooms.add(room);
        }
        //for 3rd floor
        for (int i = 301; i <= 325; i++){
            Room room = new Room ("Single", i);
            rooms.add(room);
        }
         for (int i = 326; i <= 341; i++){
            Room room = new Room ("Double", i);
            rooms.add(room);
        }
        for (int i = 342; i <= 352; i++){
            Room room = new Room ("Suite", i);
            rooms.add(room);
        }

        try {
            System.out.println("\nOur Hotel Check-in and check-out time is from 12 pm to the next day 12 pm. ");
            System.out.print("How long will you be staying?" + "\nEnter duration (in days); ");
            int durationOfStay = sc.nextInt();
            System.out.print("Enter total numbers of rooms you want: ");
            int userTotalRoom = sc.nextInt();
            int totalRoomPrice = 0;
            for (int i = 1; i <= userTotalRoom; i++ ){
                System.out.print("Choose " + i + " room type: " + "\n1)single" + "\n2)double" + "\n3)suite");
                int roomType = sc.nextInt();
                String roomTypeName = "";
                int roomPrice = 0;
                if(roomType == 1){
                    roomTypeName = "Single";
                    roomPrice = 500;
                } else if(roomType == 2){
                    roomTypeName = "Double";
                    roomPrice = 1000;
                } else if(roomType == 3){
                    roomTypeName = "Suite";
                    roomPrice = 5000; 
                }
                boolean roomFound = false;
                for (Room room : rooms) {
                    if(room.getRoomType().equals(roomTypeName) && room.getRoomAvailability()){
                        room.setAvailability(false);
                        System.out.println("Room booked. Room number: " + room.getRoomNum());
                        roomFound = true;
                        break;
                    }
                }
                if(!roomFound){
                    System.out.println("Sorry, no available rooms of this type.");
                }
                else { 
                    totalRoomPrice += roomPrice * durationOfStay; 
                }
            }
                System.out.println("Total room price: " + totalRoomPrice);
        }
        catch (InputMismatchException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

}
