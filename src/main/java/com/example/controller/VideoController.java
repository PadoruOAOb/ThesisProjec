package com.example.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@GetMapping("/v1")
    public String getVideo() {
        return "forward:/WEB-INF/videos/1.mp4";
    }
	
//	@GetMapping("/v2/{resourceId}")
//	@ResponseBody 
//	public FileSystemResource getVideo(@PathVariable("resourceId") String resourceId  ,HttpServletRequest request) {
//		String videoPath = request.getSession().getServletContext().getRealPath("/WEB-INF/videos/"+resourceId+".mp4");
//	    return new FileSystemResource(videoPath);
//	}
	
	@GetMapping("/v2/{resourceId}")
    public ResponseEntity<StreamingResponseBody> streamVideo(@PathVariable("resourceId") String resourceId,
                                                            HttpServletRequest request) {
        String videoPath = request.getSession().getServletContext().getRealPath("/WEB-INF/videos/" + resourceId + ".mp4");
        FileSystemResource videoFile = new FileSystemResource(videoPath);

        StreamingResponseBody responseBody = outputStream -> {
            try (InputStream videoStream = videoFile.getInputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = videoStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "video.mp4");

        return new ResponseEntity<>(responseBody, headers, org.springframework.http.HttpStatus.OK);
    }
}

