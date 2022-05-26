package com.stkaskin.restaurantmanager.Manager;

import com.stkaskin.restaurantmanager.Interface.IManager;
import com.stkaskin.restaurantmanager.Models.Person;

import java.util.ArrayList;

public class PersonManager implements IManager {

    public Person get(String id) {
        for (Person person : get())
            if (id == person.getId())
                return person;

        return null;
    }

    @Override
    public Object set(Object obj1_old, Object obj_set) {
        return null;
    }

    public ArrayList<Person> get() {
        return addAll();
    }

    public Person setPerson(Person person, Person setPerson) {
        return setProperties(person, setPerson);
    }


    public ArrayList<Person> setAll(ArrayList<Person> persons) {
        ArrayList<Person> list = get();
        for (int y = 0; y < persons.size(); y++)
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getId() == persons.get(y).getId())
                    list.set(i, setProperties(list.get(i), persons.get(y)));
        return list;
    }

    public Person setProperties(Person person, Person setPerson) {
        person = setPerson;
      /*  person.setId(temp.getId());
        person.setAd(temp.getAd());*/
        return person;
    }

    public ArrayList<Person> addAll() {
        ArrayList<Person> persons = new ArrayList<>();
        //veritabanı
     /*   persons.add(new Person(1, "Sıtkı"));
        persons.add(new Person(2, "Oğuz"));
        persons.add(new Person(3, "Utku"));*/
        return persons;
    }

    @Override
    public Object setProperties(ArrayList<Object> list) {
        return null;
    }
}
