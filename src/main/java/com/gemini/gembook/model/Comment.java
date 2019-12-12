package com.gemini.gembook.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name="comments")
public class Comment {
	
	@Id
	@Column(name="comment_id")
	private int commentId;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	@Column(name="comment_content")
	private String commentContent;
	
	@Column(name="comment_time")
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date commentTime;
	
	public Comment() {}
	
	public Comment(int commentId) {
		this.commentId = commentId;
	}
	
	public Comment(int postId, String userId, String commentContent) {
		this.post = new Post(postId) ;
		this.user = new User(userId);
		this.commentContent = commentContent;
		this.commentTime = new Date();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

}
