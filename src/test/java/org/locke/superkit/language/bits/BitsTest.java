package org.locke.superkit.language.bits;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.locke.superkit.collections.lists.ObjectList;
import org.locke.superkit.language.count.Count;

public class BitsTest
{
	@Test
	public void testArraySize()
	{
		assertEquals(Count.SIX, Bits.of(48).arraySize(Bits.EIGHT));
		assertEquals(Count.SEVEN, Bits.of(49).arraySize(Bits.EIGHT));
	}

	@Test
	public void testBitsLessThan()
	{
		assertEquals(new ObjectList<Bits>(Bits.ONE, Bits.TWO, Bits.THREE, Bits.FOUR),
		        new ObjectList<Bits>(Bits.of(5).bitsLessThan()));
	}

	@Test
	public void testMask()
	{
		assertEquals(0xff, Bits.perByte().mask());
		assertEquals(0xffff, Bits.perCharacter().mask());
		assertEquals(0xffff, Bits.perShort().mask());
		assertEquals(0xffffffffL, Bits.perInteger().mask());
		assertEquals(0xffffffffffffffffL, Bits.perLong().mask());
	}

	@Test
	public void testMaximumValue()
	{
		assertEquals(0xff, Bits.perByte().maximumValue());
		assertEquals(0xffff, Bits.perCharacter().maximumValue());
		assertEquals(0xffff, Bits.perShort().maximumValue());
		assertEquals(0xffffffffL, Bits.perInteger().maximumValue());
		assertEquals(0xffffffffffffffffL, Bits.perLong().maximumValue());
	}

	@Test
	public void testSizes()
	{
		assertEquals(Bits.of(8), Bits.perByte());
		assertEquals(Bits.of(16), Bits.perCharacter());
		assertEquals(Bits.of(16), Bits.perShort());
		assertEquals(Bits.of(32), Bits.perInteger());
		assertEquals(Bits.of(64), Bits.perLong());
		assertEquals(Bits.of(16), Bits.perCharacter());
	}

	@Test
	public void testToRepresent()
	{
		assertEquals(Bits.perByte(), Bits.toRepresent(0xff));
		assertEquals(Bits.perByte().incremented(), Bits.toRepresent(0xff + 1));
		assertEquals(Bits.perShort(), Bits.toRepresent(0xffff));
		assertEquals(Bits.perShort().incremented(), Bits.toRepresent(0xffff + 1));
		assertEquals(Bits.perInteger(), Bits.toRepresent(0xffffffffL));
		assertEquals(Bits.perInteger().incremented(), Bits.toRepresent(0xffffffffL + 1));
		assertEquals(Bits.perLong(), Bits.toRepresent(0xffffffffffffffffL));
	}
}
