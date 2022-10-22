package hackathon22;

public class Machine extends Thread{
	String name;
	MState state;
	// \/ configure template here \/
	String[][] template = {
			{"id","id"},
			{"name",""},
			{"MessageType",""},
			{"Value","rnd"},
			{"ValueType","String"},
			{"timestamp","ts"}};
	int messageTime; //sends message every n milliseconds
	int stateChangeTime; //changes state every n milliseconds
	

	public Machine(String name, MState state, int messageTime, int stateChangeTime) {
		this.name = name;
		this.state = state;
		this.messageTime = messageTime;
		this.stateChangeTime = stateChangeTime;
		for (int i=0; i<template.length; i++) {
			if(template[i][1].equals("name")) {
				template[i][1] = this.name;
				break;
			}
		}
	}

	//updates state of machine
	public void setState(MState newState) {
		this.state = newState;
	}
	
	@Override
	public void run() {
		double tsct = System.currentTimeMillis();
		double tmt = System.currentTimeMillis();
		while(true) {
			if (System.currentTimeMillis() - tsct > this.stateChangeTime) {
				 this.changeState(MState.random());
				 tsct = System.currentTimeMillis();
			}
			if (System.currentTimeMillis() - tmt > this.messageTime) {
				 this.createMessage();
				 tmt = System.currentTimeMillis();
			}	
		}
	}
	
	//process of changing state, includes sending a message
	public void changeState(MState mState) {
		setState(mState);
		createMessage();		
	}
	
	//creates message (and sends it)
	public void createMessage() {
		for (int i=0; i<template.length; i++) {
			if(template[i][0].equals("MessageType")) {
				template[i][1] = this.state.toString();
				break;
			}
		}
		Message msg = new Message(template);
		msg.send();
	}
	

}
