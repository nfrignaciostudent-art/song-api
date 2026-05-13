package com.ignacio.songapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final SongRepository songRepository;

    public DataSeeder(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (songRepository.count() == 0) {
            seedSongs();
        }
    }

    private void seedSongs() {
        Song[] songs = {
            song("Bohemian Rhapsody",        "Queen",                    "A Night at the Opera",                 "Rock",     "https://www.youtube.com/watch?v=fJ9rUzIMcZQ"),
            song("Blinding Lights",           "The Weeknd",               "After Hours",                          "Pop",      "https://www.youtube.com/watch?v=4NRXx6U8ABQ"),
            song("Shape of You",              "Ed Sheeran",               "Divide",                               "Pop",      "https://www.youtube.com/watch?v=JGwWNGJdvx8"),
            song("Hotel California",          "Eagles",                   "Hotel California",                     "Rock",     "https://www.youtube.com/watch?v=EqPtz5qN7HM"),
            song("HUMBLE.",                   "Kendrick Lamar",           "DAMN.",                                "Hip Hop",  "https://www.youtube.com/watch?v=tvTRZJ-4EyI"),
            song("Levitating",                "Dua Lipa",                 "Future Nostalgia",                     "Pop",      "https://www.youtube.com/watch?v=TUVcZfQe-Kw"),
            song("Butter",                    "BTS",                      "Butter",                               "K-Pop",    "https://www.youtube.com/watch?v=WMweEpGlu_U"),
            song("Watermelon Sugar",          "Harry Styles",             "Fine Line",                            "Pop",      "https://www.youtube.com/watch?v=E07s5ZYadZg"),
            song("Smells Like Teen Spirit",   "Nirvana",                  "Nevermind",                            "Rock",     "https://www.youtube.com/watch?v=hTWKbfoikeg"),
            song("Stay",                      "The Kid LAROI & Justin Bieber", "F*CK LOVE 3: OVER YOU",          "Pop",      "https://www.youtube.com/watch?v=kTJczUoc26U"),
            song("Despacito",                 "Luis Fonsi ft. Daddy Yankee", "Vida",                             "Latin",    "https://www.youtube.com/watch?v=kJQP7kiw5Fk"),
            song("Save Your Tears",           "The Weeknd",               "After Hours",                          "Pop",      "https://www.youtube.com/watch?v=XXYlFuWEuKI"),
            song("God's Plan",                "Drake",                    "Scorpion",                             "Hip Hop",  "https://www.youtube.com/watch?v=xpVfcZ0ZcFM"),
            song("bad guy",                   "Billie Eilish",            "WHEN WE ALL FALL ASLEEP, WHERE DO WE GO?", "Indie","https://www.youtube.com/watch?v=DyDfgMOUjCI"),
            song("Uptown Funk",               "Mark Ronson ft. Bruno Mars","Uptown Special",                     "Pop",      "https://www.youtube.com/watch?v=OPf0YbXqDm0"),
            song("Rolling in the Deep",       "Adele",                    "21",                                   "Pop",      "https://www.youtube.com/watch?v=rYEDA3JcQqw"),
        };

        for (Song s : songs) {
            songRepository.save(s);
        }

        System.out.println("[DataSeeder] Seeded " + songs.length + " songs into the database.");
    }

    private Song song(String title, String artist, String album, String genre, String url) {
        Song s = new Song();
        s.setTitle(title);
        s.setArtist(artist);
        s.setAlbum(album);
        s.setGenre(genre);
        s.setUrl(url);
        return s;
    }
}
