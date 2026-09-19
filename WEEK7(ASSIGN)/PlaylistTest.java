class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}

public class PlaylistTest {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs:");

        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }

        copy[0] = "Hacked";

        System.out.println("After modifying copy:");
        String[] newCopy = p.getSongs();

        for (int i = 0; i < newCopy.length; i++) {
            System.out.println(newCopy[i]);
        }

        System.out.println("Song Count = " + p.getSongCount());
    }
}