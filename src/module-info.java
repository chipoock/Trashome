module Trashome {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
    requires javafx.web;
	
	opens application.controller to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	opens application.model to javafx.base;
	
	exports application;
	exports application.controller;
	exports application.model;
}