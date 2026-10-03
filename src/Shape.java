public abstract class Shape {

    protected String id;
    protected Renderer renderer;

    public Shape(String id, Renderer renderer) {
        this.id = id;
        this.renderer = renderer;
    }

    public void setImplementation(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String execute();

    public String getId() {
        return id;
    }
}