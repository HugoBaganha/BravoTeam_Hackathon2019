package org.academiadecodigo.bravoteam.controller;

import org.academiadecodigo.bravoteam.services.model.Content;
import org.academiadecodigo.bravoteam.services.ContentService;
import org.academiadecodigo.bravoteam.services.UserService;
import org.academiadecodigo.bravoteam.services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class ContentController {
    private ContentService contentService;
    private UserService userService;

    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{uid}/content")
    public ResponseEntity<List<Content>> listCustomerAccounts(@PathVariable Integer uid) {

        User user = userService.get(uid);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Content> contents = new ArrayList<>();
        for (Content content : user.getContents()) {
            contents.add(content);
        }

        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{uid}/content/{cid}")
    public ResponseEntity<Content> showCustomerAccount(@PathVariable Integer uid, @PathVariable Integer cid) {

        Content content = contentService.get(cid);

        if (content == null || content.getUser() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!content.getUser().getId().equals(cid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(content, HttpStatus.OK);
    }


}

}

