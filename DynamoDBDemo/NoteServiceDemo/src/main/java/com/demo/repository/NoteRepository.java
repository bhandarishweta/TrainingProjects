package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.demo.model.Note;

@Repository
public class NoteRepository 
{
	@Autowired
	private DynamoDBMapper dynamDBMapper;

	
	public Note createNote(Note nObj) 
	{
		this.dynamDBMapper.save(nObj);
		return nObj;
	}

	public List<Note> getAllNotes() 
	{
		return this.dynamDBMapper.scan(Note.class, new DynamoDBScanExpression());
	}

	public Note getNoteById(String nid) 
	{
		return this.dynamDBMapper.load(Note.class, nid);
	}

	public String deleteNoteById(String nid) {
		
		Note nObj = this.dynamDBMapper.load(Note.class, nid);
		this.dynamDBMapper.delete(nObj);
		
		return "Note Record Successfully Deleted ...."+nid;
		
	}

	public String updateNoteById(Note noteobj, String nid) 
	{
		this.dynamDBMapper.save(noteobj, new DynamoDBSaveExpression()
				.withExpectedEntry("nid", new ExpectedAttributeValue(new AttributeValue().withS(nid))));
		return nid;
	}	
}