package org.svardhan.restproj.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.svardhan.restproj.messenger.database.DatabaseClass;
import org.svardhan.restproj.messenger.model.Message;
import org.svardhan.restproj.messenger.model.Comment;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		System.out.println("message ID = " + messageId);
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		System.out.println("Comment retrieved " + comments.size());
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		System.out.println("message ID = " + messageId);
		System.out.println("message length = " + messages.size());
		System.out.println("comments size = " + comments.size());
		System.out.println("comment inserted!!!"+ comment.getMessage());
		
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		messages.get(messageId).setComments(comments);
		
		System.out.println("Message : " + messages.get(messageId));
		System.out.println("Comments size = " + messages.get(messageId).getComments().size());
		System.out.println("Comments size = " + messages.get(messageId).getComments());
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
