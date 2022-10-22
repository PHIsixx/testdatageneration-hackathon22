package hackathon22;

import java.lang.Math;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

public class Message {
	//TODO datatype in map
	Map<String, String> data = new HashMap<String, String>();
	
	public Message(String[][] template) {
		for (int i=0; i<template.length; i++) {
			String val;
			switch(template[i][1]) {
			case "rnd":
				val = Integer.toString((int)Math.ceil(Math.random()*1000));
				break;
			case "id":
				//TODO generate unique ID
				val = UUID.randomUUID().toString();
				break;
			case "ts":
				val = String.valueOf(System.currentTimeMillis());
				break;
			default:
				val = template[i][1];
			}
			data.put(template[i][0], val);
			
		}
	}
	
	public Message(Map<String, String> data) {
		this.data = data;
	}
	
	//send Message
	public void send() {
		System.out.println(this.data.toString());
	}
}
