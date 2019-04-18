package org.academiadecodigo.bravoteam.controller;

import org.academiadecodigo.bravoteam.persistence.model.Content;
import org.academiadecodigo.bravoteam.services.ContentService;
import org.academiadecodigo.bravoteam.services.UserService;
import org.academiadecodigo.bravoteam.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    /*@RequestMapping(method = RequestMethod.GET, path = "/{uid}/content")
    public ResponseEntity<List<Content>> listContent(@PathVariable Integer uid) {

        User user = userService.get(uid);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Content> contents = new ArrayList<>();
        for (Content content : user.getContents()) {
            contents.add(content);
        }

        return new ResponseEntity<>(contents, HttpStatus.OK);
    }*/

    /*@RequestMapping(method = RequestMethod.GET, path = "/{uid}/content/{cid}")
    public ResponseEntity<Content> showContent(@PathVariable Integer uid, @PathVariable Integer cid) {

        Content content = contentService.get(uid);

        if (content == null || content.getUser() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!content.getUser().getId().equals(cid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(content, HttpStatus.OK);
    }*/

        @RequestMapping("/save-content")
        public String uploadResources( HttpServletRequest servletRequest,
                                       @ModelAttribute Content content,
                                       org.springframework.ui.Model model)
        {
            //Get the uploaded files and store them
            List<MultipartFile> files = content.getVideos();
            List<String> fileNames = new ArrayList<String>();
            if (null != files && files.size() > 0)
            {
                for (MultipartFile multipartFile : files) {

                    String fileName = multipartFile.getOriginalFilename();
                    fileNames.add(fileName);

                    File videoFile = new File(servletRequest.getServletContext().getRealPath("/video"), fileName);
                    try
                    {
                        multipartFile.transferTo(videoFile);
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            // Here, you can save the content details in database

            model.addAttribute("content", content);
            return "viewContentDetail";
        }

        @RequestMapping(value = "/content-input-form")
        public String inputProduct(Model model) {
            model.addAttribute("content", new Content());
            return "ContentForm";
        }
    }




