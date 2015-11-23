package com.dxj.wecard.util;

public class Seq {
	
	private static int Seq_no = (int) ( Math.random( ) * 999999 );

	private static Object seqLock = new Object( );

	public static int getRawSeq( ) {
		synchronized( seqLock ) {
			if( Seq_no >= 999999 )
				Seq_no = 0;
			return Seq_no++;
		}
	}
}
