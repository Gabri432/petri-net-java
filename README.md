# Petri-net-java
Simple implementation of Petri nets made with Java 17 and Gradle.

## How to use it
Here is a simple snippet:
```java
public class Main {
    public static void main(String[] args) {
        PetriNetBuilder builder = new ConcretePetriNet.Builder(); //Create a net-builder
        builder.setPetriNetName("My Java Petri Net"); //Define its name
        builder.createArch(1, "p1", 2, "t1", true); //Create an arch (incoming)
        builder.createArch(1, "p2", 0, "t1", false); //Create an arch (outgoing)
        PetriNet pNet = builder.build(); //Build the net
        System.out.println(pNet); //Printing the net
        pNet.fireTransition("t1"); //Firing a transition
        System.out.println(pNet); //Printing again to see the result
    }
}
```

## Expected result
With the previous code, by running the command `gradle run`, you should get:
```
Net name: My Java Petri Net
Incoming arches: 
(p1 : 2) --1--> t1
Outgoing arches: 
t1 --1--> (p2 : 0)
Current Marking:
(p1 : 2)(p2 : 0)

Net name: My Java Petri Net
Incoming arches:
(p1 : 1) --1--> t1
Outgoing arches:
t1 --1--> (p2 : 1)
Current Marking:
(p1 : 1)(p2 : 1)
```

## Interpreting the code

Create a builder for a Petri net:
```java
public class Main {
    public static void main(String[] args) {
        PetriNetBuilder builder = new ConcretePetriNet.Builder();
        //...
    }
}
```
Decide the name that such net will have:
```java
public class Main {
    public static void main(String[] args) {
        PetriNetBuilder builder = new ConcretePetriNet.Builder();
        builder.setPetriNetName("My Java Petri Net");
        //...
    }
}
```
Build the arches of the net, starting from its weight, the name of the place, the tokens of the place, the name of the transition and whether such arch is incoming or outgoing.

If `true` then it will be incoming, that is, will start from the place and end in the transition.
If `false` then it will be outgoing, that is, will start from the transition and end in the place.
```java
public class Main {
    public static void main(String[] args) {
        PetriNetBuilder builder = new ConcretePetriNet.Builder();
        builder.setPetriNetName("My Java Petri Net");
        builder.createArch(1, "p1", 2, "t1", true); //Incoming arch of weight 1, with p1 having 2 tokens, ends in t1
        builder.createArch(1, "p2", 0, "t1", false); //Outgoing arch of weight 1, with p2 having 0 tokens, starts from t1
        //...
    }
}
```
Once you have finished with adding arches, build the net:
```java
public class Main {
    public static void main(String[] args) {
        PetriNetBuilder builder = new ConcretePetriNet.Builder(); 
        builder.setPetriNetName("My Java Petri Net"); 
        builder.createArch(1, "p1", 2, "t1", true); 
        builder.createArch(1, "p2", 0, "t1", false);
        PetriNet pNet = builder.build();
        //...
    }
}
```
Now you can fire any transition that you have defined (assuming it is enabled):
```java
public class Main {
    public static void main(String[] args) {
        PetriNetBuilder builder = new ConcretePetriNet.Builder(); 
        builder.setPetriNetName("My Java Petri Net"); 
        builder.createArch(1, "p1", 2, "t1", true); 
        builder.createArch(1, "p2", 0, "t1", false);
        PetriNet pNet = builder.build();
        pNet.fireTransition("t1");
    }
}
```

## Interpreting the output
The first line will tell the name of the Petri net:
```
Net name: My Java Petri Net
```
The following section will list all the incoming arches, that is, all the arches entering a transition.
Each arch is shown is such sequence: the place name with the specified amount of tokens, the weight of the arch, and the transition name.

Example (an arch from p1 to t1):
```
Incoming arches:
(p1 : 2) --1--> t1
```
Similarly, the list of outgoing arches are the ones exiting a transition.
Each arch is shown is such sequence: the transition name, the weight of the arch, and the place name with the specified amount of tokens

Example (an arch from t1 to p2):
```
Outgoing arches:
t1 --1--> (p2 : 0)
```
Lastly, the current marking of the Petri net, which is the set of places with their respective tokens:
```
Current Marking:
(p1 : 2)(p2 : 0)
```
In this case, after firing the transition t1 once, the next marking will be:
```
Current Marking:
(p1 : 1)(p2 : 1)
```

## Extra notes
- This project is under the [Apache license 2.0](https://github.com/Gabri432/petri-net-java/blob/main/license);
- This project was developed with IntelliJ Community Edition, Java 17, and Gradle 8.11;
- This project was intended for learning/education purposes, therefore it does not claim to be the most efficient/convenient solution/implementation;
