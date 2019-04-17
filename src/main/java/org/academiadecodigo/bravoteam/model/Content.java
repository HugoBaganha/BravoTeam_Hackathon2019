package org.academiadecodigo.bravoteam.model;

import org.springframework.web.multipart.MultipartFile;

public class Content {

    private MultipartFile file;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
