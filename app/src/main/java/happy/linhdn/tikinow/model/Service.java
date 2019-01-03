package happy.linhdn.tikinow.model;

public class Service {
    private String name;
    private int imgResource;

    public Service(String name, int imgResource) {
        this.name = name;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
