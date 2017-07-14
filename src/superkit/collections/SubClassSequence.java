package superkit.collections;

import java.util.Iterator;

public class SubClassSequence<B extends A, A> implements Iterable<B> {
	
	private Iterable<A> sequence;

	public SubClassSequence(Iterable<A> sequence) {
		this.sequence = sequence;
	}

	@Override
	public Iterator<B> iterator() {
		
		return new Iterator<B>() {
			
			Iterator<A> iterator = sequence.iterator();

			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			@SuppressWarnings("unchecked")
			public B next() {
				return (B) iterator.next();
			}			
		};
	}
}
