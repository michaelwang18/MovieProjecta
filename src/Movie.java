public class Movie {
    String title;
    String cast;
    String director;
    String overview;
    int runtime;
    double rating;


    public Movie(String name, String cast, String director, String overview, int runtime, double rating){
        this.title = name;
        this.cast = cast;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }


    public String getCast() {
        return cast;
    }


    public double getRating() {
        return rating;
    }


    public int getRuntime() {
        return runtime;
    }


    public String getDirector() {
        return director;
    }


    public String getOverview() {
        return overview;
    }

    @Override
    public String toString() {
        String fun = "";
        fun+= "Title: " + title + "\n";
        fun+= "Runtime: " + runtime + "\n";
        fun+= "Directed By: " + director + "\n";
        fun+= "Cast: " + cast + "\n";
        fun+= "Overview: " + overview + "\n";
        fun+= "User Rating: " + rating + "\n";


        return fun;
    }
}

