package simple_generics;

/**
 * So what is cool about this is that this can be replaced with anything we want,
 * for example if we use List<Integer>, the compiler replaces everything at compile time
 * for the letter "E" (or any other letter, you can use anything) allowing consistency.
 *
 * If we use List<Integer> then that means the add method accepts only an Integer. Same for
 * MyIterator.
 *
 * Note: You can also have <K, V> if you want to have multiple types
 *
 * @param <E> the generic type
 */
public interface List<E> {
    void add(E x);
    MyIterator<E> iterator();
}

interface MyIterator<E> {
    E next();
    boolean hasNext();
    void remove();
}

