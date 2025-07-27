package scanner;

    import java.util.*;

    public class MovieTicketBooking {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Menu Loop
            while (true) {
                System.out.println("=== Welcome to Movie Ticket Booking System ===");
                System.out.println("1. Book Ticket");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // To clear the buffer

                if (choice == 1) {
                    bookTicket(sc);
                } else if (choice == 2) {
                    System.out.println("Thank you for visiting! Have a nice day.");
                    break;
                } else {
                    System.out.println("Invalid option. Please try again.\n");
                }
            }

            sc.close();
        }

        public static void bookTicket(Scanner sc) {
            // Step 1: Enter City (Simulated GPS)
            System.out.print("\nEnter your city (Mumbai, Delhi, Bangalore): ");
            String cityInput = sc.nextLine().trim().toLowerCase();

            // Step 2: List of theatres by city
            Map<String, String[]> theatreList = new HashMap<>();
            theatreList.put("mumbai", new String[]{"PVR Juhu", "INOX R City", "Cinepolis Andheri"});
            theatreList.put("delhi", new String[]{"PVR Saket", "Carnival Rohini", "Delite Cinema"});
            theatreList.put("bangalore", new String[]{"PVR Orion", "INOX Garuda Mall", "Cinepolis Soul Space"});

            if (!theatreList.containsKey(cityInput)) {
                System.out.println("Sorry! No theatres available in this city.\n");
                System.out.println("Available cities: Mumbai, Delhi, Bangalore\n");
                return;
            }

            // Step 3: Show Theatres
            String[] theatres = theatreList.get(cityInput);
            System.out.println("\nAvailable Theatres:");
            for (int i = 0; i < theatres.length; i++) {
                System.out.println((i + 1) + ". " + theatres[i]);
            }

            System.out.print("Select a theatre (1-" + theatres.length + "): ");
            int theatreChoice = sc.nextInt();
            sc.nextLine();

            if (theatreChoice < 1 || theatreChoice > theatres.length) {
                System.out.println("Invalid theatre selection.\n");
                return;
            }

            String selectedTheatre = theatres[theatreChoice - 1];

            // Step 4: Choose Movie Genre
            String[] genres = {"Action", "Sci-Fi", "Comedy", "Horror"};
            System.out.println("\nAvailable Genres:");
            for (int i = 0; i < genres.length; i++) {
                System.out.println((i + 1) + ". " + genres[i]);
            }

            System.out.print("Choose a genre: ");
            int genreChoice = sc.nextInt();
            sc.nextLine();

            if (genreChoice < 1 || genreChoice > genres.length) {
                System.out.println("Invalid genre choice.\n");
                return;
            }

            String selectedGenre = genres[genreChoice - 1];

            // Step 5: Movies by Genre
            Map<String, String[]> moviesByGenre = new HashMap<>();
            Map<String, String[]> timesByGenre = new HashMap<>();
            String date = "27-07-2025";

            moviesByGenre.put("Action", new String[]{"John Wick 4", "Pathaan", "Extraction 2"});
            timesByGenre.put("Action", new String[]{"11:00 AM", "2:00 PM", "6:00 PM"});

            moviesByGenre.put("Sci-Fi", new String[]{"Inception", "Interstellar", "Avengers: Endgame"});
            timesByGenre.put("Sci-Fi", new String[]{"10:00 AM", "1:30 PM", "5:00 PM"});

            moviesByGenre.put("Comedy", new String[]{"3 Idiots", "Hera Pheri", "Dhamaal"});
            timesByGenre.put("Comedy", new String[]{"12:00 PM", "3:15 PM", "7:00 PM"});

            moviesByGenre.put("Horror", new String[]{"The Nun", "Conjuring", "Annabelle"});
            timesByGenre.put("Horror", new String[]{"5:00 PM", "8:00 PM", "10:30 PM"});

            String[] movies = moviesByGenre.get(selectedGenre);
            String[] times = timesByGenre.get(selectedGenre);

            // Step 6: Choose Movie
            System.out.println("\nMovies in " + selectedGenre + " Genre:");
            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i] + " at " + times[i]);
            }

            System.out.print("Choose a movie: ");
            int movieChoice = sc.nextInt();
            sc.nextLine();

            if (movieChoice < 1 || movieChoice > movies.length) {
                System.out.println("Invalid movie selection.\n");
                return;
            }

            String selectedMovie = movies[movieChoice - 1];
            String selectedTime = times[movieChoice - 1];

            // Step 7: Seat Type
            System.out.println("\nChoose Seat Type:");
            System.out.println("1. Front (Rs.150)");
            System.out.println("2. Middle (Rs.200)");
            System.out.println("3. Back (Rs.250)");
            System.out.print("Your choice: ");
            int seatType = sc.nextInt();
            sc.nextLine();

            String seatName = "";
            int seatPrice = 0;

            switch (seatType) {
                case 1:
                    seatName = "Front";
                    seatPrice = 150;
                    break;
                case 2:
                    seatName = "Middle";
                    seatPrice = 200;
                    break;
                case 3:
                    seatName = "Back";
                    seatPrice = 250;
                    break;
                default:
                    System.out.println("Invalid seat type.\n");
                    return;
            }

            // Step 8: Number of Tickets
            System.out.print("Enter number of tickets: ");
            int numTickets = sc.nextInt();
            sc.nextLine();

            if (numTickets <= 0) {
                System.out.println("Invalid number of tickets.\n");
                return;
            }

            int totalAmount = numTickets * seatPrice;

            // Step 9: Show Booking Summary
            System.out.println("\n=== Booking Summary ===");
            System.out.println("City: " + capitalize(cityInput));
            System.out.println("Theatre: " + selectedTheatre);
            System.out.println("Genre: " + selectedGenre);
            System.out.println("Movie: " + selectedMovie);
            System.out.println("Date: " + date);
            System.out.println("Time: " + selectedTime);
            System.out.println("Seat Type: " + seatName);
            System.out.println("Tickets: " + numTickets);
            System.out.println("Price per Ticket: Rs." + seatPrice);
            System.out.println("Total Amount: Rs." + totalAmount);
            System.out.println("Thank you! Enjoy your movie.\n");
        }

       
        
    }


