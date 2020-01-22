/*
* @package: staffWriterToolbox
* @file: MiddleBar.java
*
* @author: Himanshu Babbar
*
* Copyright (C) 2013. All rights reserved.
*/
package staffWriterToolbox;
/**
* The Class MiddleBar represents the middle bar of the staff.
*/
public class MiddleBar extends Bar {
/** The display. */
private String display;
/**
* Instantiates a new middle bar.
*
* @param barNumber
* the bar number
*/
public MiddleBar(int barNumber) {
super(barNumber);
}
/**
* Gets the display.
*
* @return the display
*/
public String getDisplay() {
return this.display;
}
/**
* Sets the display.
*
* @param display
* the new display
*/
public void setDisplay(String display) {
this.display = display;
}
}
