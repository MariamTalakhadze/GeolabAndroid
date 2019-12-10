package com.example.recycleview.mock;

import com.example.recycleview.R;
import com.example.recycleview.models.Person;

import java.util.ArrayList;
import java.util.List;

public class mockdata {
        public static List<Person> getPersons(){
            ArrayList<Person> person = new ArrayList<>();
            person.add(new Person("something", "fortest", 19, R.drawable.joker, "555555555", false));
            person.add(new Person("something1", "fortest1", 109, R.drawable.joker, "555555555",false));
            person.add(new Person("something2", "fortest2", 18, R.drawable.ironman, "555555555",false));
            person.add(new Person("something3", "fortest34", 29, R.drawable.joker, "555555555",false));
            person.add(new Person("something4", "fortest4", 10, R.drawable.joker, "555555555",false));
            person.add(new Person("something5", "fortest5", 49, R.drawable.ironman, "555555555",false));
            person.add(new Person("something6", "fortest6", 79, R.drawable.ironman, "555555555",false));
            person.add(new Person("something7", "fortest7", 13, R.drawable.joker, "555555555",false));
            return person;
        }
        public static List<Person> deletePersons(Person persons){
            ArrayList<Person> person = new ArrayList<>();
            person.remove(persons);
            return person;
        }
}
