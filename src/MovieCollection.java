

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MovieCollection {
    Movie[] movieList;
    Scanner scan;
    public  MovieCollection (){
        scan = new Scanner(System.in);
        readFile();
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";

        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scan.nextLine();

            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }


    }


    private void readFile(){
        try{
            File movieSlop = new File("src//movies_data.csv");
            Scanner reader = new Scanner(movieSlop);
            int count = 0;
            reader.nextLine();
            while(reader.hasNext()){
                reader.nextLine();
                count++;
                System.out.println(count);
            }
            File movieSlop2 = new File("src//movies_data.csv");
            Scanner reader2 = new Scanner(movieSlop2);
            movieList = new Movie[count];
            reader2.nextLine();

            for (int i = 0; i < count; i++){
                String data = reader2.nextLine();
                String[] split = data.split(",");
                //System.out.println(split[0]);
                movieList[i] = new Movie(split[0],split[1],split[2],split[3],Integer.parseInt(split[4]),Double.parseDouble(split[5]));
            }
        } catch (IOException e){
            System.out.println(e.getMessage() + "\n\n\n" + e.getCause());
        }


    }

    private void searchTitles(){
        System.out.println("What is the title of the movie you're looking for?");
        String searchTerm = scan.nextLine();
        boolean found = false;
        ArrayList<Movie> matchMovie = new ArrayList<>();
        for (Movie movie: movieList){
            if (movie.title.contains(searchTerm)){
                matchMovie.add(new Movie(movie.title,movie.cast,movie.director,movie.overview,movie.runtime,movie.rating));
                found = true;
            }
        }
        if (!found){
            System.out.println("None of the movies match your search term, try again.");
            searchTitles();
        } else {
            System.out.println("Here are the movies that fits your search term\n\n");
                for (Movie movie: matchMovie){System.out.println(matchMovie.indexOf(movie) + 1 + ". " + movie.getTitle());}
                System.out.println("Which one are you interested in? ");
                System.out.println(matchMovie.get(scan.nextInt()-1));

        }
    }

    private void searchCast(){
        System.out.println("What is the name of the actor you're looking for?"); //| |
        String searchTerm = scan.nextLine();
        boolean found = false;
        ArrayList<Movie> matchActors = new ArrayList<>();
        for (Movie movie: movieList){
            if (movie.cast.toLowerCase().contains(searchTerm.toLowerCase())){
                found = true;
                String[] split = movie.cast.split("|");
                for (int i = 0; i < split.length; i++){
                    if (split[i].toLowerCase().toLowerCase().contains(searchTerm.toLowerCase())){
                        //check if is already in match actor list
                        System.out.println("hi");
                    }

                }

            }
        }

    }


}
