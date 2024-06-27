package vn.edu.likelion.services;

import vn.edu.likelion.model.Persons;

public interface PersonServices {
     void addPerson(Persons persons);
     void editPerson(Persons persons);
     void deletePerson(Persons persons);
     void personDetailById(String id);
     void showAllPerson();
}
