package com.ijse.instagram_clone.controller;


import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/post")

public class PostController {


    @Autowired
    private PostServiceImpl postService;


    @PostMapping("/add")
    public Post addPost(@RequestParam("file") MultipartFile file,Post post) {


        File uploadedFile = new File(file.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(uploadedFile)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String bucketName = "com.kavindu.bucket";
        String objectKey = "test_file";


        Region region = Region.US_WEST_1;
        S3Client s3 = S3Client.builder()
                .region(region)
                .build();

        PutObjectResponse response = s3.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectKey)
                        .build(),
                software.amazon.awssdk.core.sync.
                RequestBody.fromFile(uploadedFile)
        );
        System.out.println(response.eTag());


        return postService.addPost(post);

    }


}
