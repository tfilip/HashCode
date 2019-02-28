package utils;

import pictures.Photo;

import java.io.PrintStream;
import java.util.ArrayList;

public class Writer {

    public static void writeToFile(PrintStream printStream, ArrayList<Photo> photos){
        printStream.println(photos.size());
        for(Photo photo: photos){
            printStream.print(photo);
        }
    }

}
