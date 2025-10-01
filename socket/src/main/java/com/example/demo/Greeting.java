package com.example.demo;


public class Greeting {

  private String action;
  private String content;

  public Greeting() {
  }

  public Greeting(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

    
public Greeting(String action, String content) {
	super();
	this.action = action;
	this.content = content;
}

public String getAction() {
	return action;
}

public void setAction(String action) {
	this.action = action;
}

public void setContent(String content) {
	this.content = content;
}

  
}