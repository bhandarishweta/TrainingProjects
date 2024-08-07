package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Note;
import com.demo.repository.NoteRepository;

@RestController
@RequestMapping("note/v1")
public class NoteController 
{
	@Autowired
	private NoteRepository noterepository;

	private ResponseEntity<?> respentity;
	
	@PostMapping("/addNote")
	public ResponseEntity<?> saveNote(@RequestBody Note nobj)
	{
		Note Noteobj = this.noterepository.createNote(nobj);
		ResponseEntity respe = new ResponseEntity(Noteobj,HttpStatus.CREATED);
		return respe;
	}

	
	@PutMapping("/updateNote/{nid}")
	public ResponseEntity<?> updateNote(@RequestBody Note nobj,@PathVariable String nid)
	{
		String Noteobj = this.noterepository.updateNoteById(nobj, nid);
		ResponseEntity respe = new ResponseEntity(Noteobj,HttpStatus.CREATED);
		return respe;
	}

	
	@GetMapping("/getNotes")
	public ResponseEntity<?> getAllNotes()
	{
		ResponseEntity respe = new ResponseEntity(this.noterepository.getAllNotes(),HttpStatus.OK);
		return respe;
	}
	
	@GetMapping("/getNotebyid/{nid}")
	public ResponseEntity<?> getNoteById(@PathVariable String nid)
	{
		Note uobj = this.noterepository.getNoteById(nid);
		ResponseEntity respe = new ResponseEntity(uobj,HttpStatus.OK);
		return respe;
	}
	
	@DeleteMapping("/delNotebyid/{nid}")
	public ResponseEntity<?> delNoteById(@PathVariable String nid)
	{
		String status = this.noterepository.deleteNoteById(nid);
		ResponseEntity respe = new ResponseEntity("Note details deleted ",HttpStatus.OK);
		return respe;
	}
}