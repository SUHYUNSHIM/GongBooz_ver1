package com.gb.wnn.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.gb.wnn.service.StudyService;

@Controller
public class StudyRoom {
	@Resource(name="StudyRoomService")
	private StudyService studyService;

}
