package org.academiadecodigo.bravoteam.model;

import org.springframework.web.multipart.MultipartFile;

public class Content {

    private MultipartFile file;
    private User user;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public User getUser(){
        return user;
    }

}
