package pictures;

public class PairOfVertical {

    private Photo photoA;
    private Photo photoB;

    public PairOfVertical(Photo photoA, Photo photoB) {
        this.photoA = photoA;
        this.photoB = photoB;
    }

    public Photo getPhotoA() {
        return photoA;
    }

    public void setPhotoA(Photo photoA) {
        this.photoA = photoA;
    }

    public Photo getPhotoB() {
        return photoB;
    }

    public void setPhotoB(Photo photoB) {
        this.photoB = photoB;
    }
}
