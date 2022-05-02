package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.Models.Person;
import com.stkaskin.restaurantmanager.Models.Table;

import java.util.ArrayList;

public class PersonManager {

    public Person getPerson(int id) {
        for (Person person:getPersons())
            if (id==person.getId())
                return person;

        return null;
    }

    public ArrayList<Person> getPersons() {
        return addAllPersons();
    }

    public Person setPerson(Person person, Person setPerson) {
        return setPersonProperties(person, setPerson);
    }


    public ArrayList<Person> setAllPersons(ArrayList<Person> persons) {
        ArrayList<Person> list = getPersons();
        for (int y = 0; y < persons.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == persons.get(y).getId())
                    list.set(i, setPersonProperties( list.get(i),persons.get(y)));
        return list;
    }
    public Person setPersonProperties(Person person, Person setPerson) {
        person = setPerson;
      /*  person.setId(temp.getId());
        person.setAd(temp.getAd());*/
        return person;
    }
    private ArrayList<Person> addAllPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        //veritabanı
        persons.add(new Person(1, "Sıtkı"));
        persons.add(new Person(2, "Oğuz"));
        persons.add(new Person(3, "Utku"));
        return persons;
    }
}
