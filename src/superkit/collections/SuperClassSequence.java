package superkit.collections;

import java.util.Iterator;

public class SuperClassSequence<B extends A, A> implements Iterable<A> {
	
	private Iterable<B> sequence;

	public SuperClassSequence(Iterable<B> sequence) {
		this.sequence = sequence;
	}

	@Override
	public Iterator<A> iterator() {
		
		return new Iterator<A>() {
			
			Iterator<B> iterator = sequence.iterator();

			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public A next() {
				return (A) iterator.next();
			}			
		};
	}
}
