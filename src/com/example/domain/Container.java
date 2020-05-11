package com.example.domain;
//Model
public class Container {
    private String name;
    private String image;
    private String id;
    private String status;
    private String[] ports;//ports list
    private String created; //created time

    public Container() {
    }

    public Container(String name, String image, String id, String status, String[] ports, String created) {
        this.name = name;
        this.image = image;
        this.id = id;
        this.status = status;
        this.ports = ports;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getPorts() {
        return ports;
    }

    public void setPorts(String[] ports) {
        this.ports = ports;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
