package pictures;

import utils.Pair;
import utils.PhotoType;

import java.util.ArrayList;

public class Photo {

    private int id;
    private PhotoType photoType;
    private int numberOfTags;
    private ArrayList<String> tags;

    public int getId() {
        return id;
    }

    public Photo(){

    }

    public Photo(PhotoType photoType, int numberOfTags, ArrayList<String> tags, Integer id) {
        this.photoType = photoType;
        this.numberOfTags = numberOfTags;
        this.tags = tags;
        this.id = id;

    }

    public PhotoType getPhotoType() {
        return photoType;
    }

    public void setPhotoType(PhotoType photoType) {
        this.photoType = photoType;
    }

    public int getNumberOfTags() {
        return numberOfTags;
    }

    public void setNumberOfTags(int numberOfTags) {
        this.numberOfTags = numberOfTags;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return id + "\n";
    }

    public int getCommonNoOfTags(Photo B){
        int rv = 0;
        for(String tag:  B.getTags()){
            if(this.getTags().contains(tag))
                rv++;
        }
        return rv;
    }

    public int getMinNumberOfTags(Photo B){
        return (this.getTags().size() < B.getTags().size())?
                this.getTags().size():
                B.getTags().size();
    }

}
