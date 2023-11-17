package cz.cvut.fit.tjv.client.domain;

public class Route implements AbstractEntity{
    private Long id;
    private String name;
    private Integer grade;
    private Centre centre;

    public Route(Long id, String name, Integer grade, Centre centre) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.centre = centre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", centre=" + centre +
                '}';
    }

    @Override
    public String getReadable() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", centre: " + centre.getReadable();
    }

    public String getReadableShort(){
        return "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", centre id=" + centre.getId();
    }
}
