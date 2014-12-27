package com.trip.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Wish_comment;
import com.trip.service.Wish_comment_service;

@SuppressWarnings("serial")
public class Wish_comment_Action extends ActionSupport {
	private Wish_comment wish_comment;
    public Wish_comment getWish_comment() {
		return wish_comment;
	}
	public void setWish_comment(Wish_comment wishComment) {
		wish_comment = wishComment;
	}
	public Wish_comment_service getWish_comment_service() {
		return wish_comment_service;
	}
	public void setWish_comment_service(Wish_comment_service wishCommentService) {
		wish_comment_service = wishCommentService;
	}
	private Wish_comment_service wish_comment_service;
}
