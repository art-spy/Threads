public class PolitePerson {

    private final String name;

    public PolitePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void sayHello(PolitePerson person) {
        // fist %s is gonna be replaced by the first parameter this.name,
        // second %s is gonna be replaced by the second parameter person.getName()
        System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
        person.sayHelloBack(this);
    }

    public synchronized void sayHelloBack(PolitePerson person) {
        // fist %s is gonna be replaced by the first parameter this.name,
        // second %s is gonna be replaced by the second parameter person.getName()
        System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
    }
}