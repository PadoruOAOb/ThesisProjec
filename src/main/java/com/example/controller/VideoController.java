package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@GetMapping("/v1")
    public String getVideo() {
        return "forward:/WEB-INF/videos/1.mp4";
    }
	
	@GetMapping("/v2/{resourceId}")
	@ResponseBody 
	public FileSystemResource getVideo(@PathVariable("resourceId") String resourceId  ,HttpServletRequest request) {
		String videoPath = request.getSession().getServletContext().getRealPath("/WEB-INF/videos/"+resourceId+".mp4");
	    return new FileSystemResource(videoPath);
	}
}
