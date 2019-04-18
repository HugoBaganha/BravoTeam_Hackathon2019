package org.academiadecodigo.bravoteam.persistence.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Component
public class Content implements Serializable {

    @Id
    private static final long serialVersionUID = 74458L;

    @NotNull
    @Size(min = 1, max = 10)
    private String name;

    private String description;

    private List<MultipartFile> videos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MultipartFile> getVideos() {
        return videos;
    }

    public void setVideos(List<MultipartFile> videos) {
        this.videos = videos;
    }

}

