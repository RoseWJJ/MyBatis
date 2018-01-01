package com.et.lesson05;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class JavaRedis {
	public static byte[] objectToByteArray(Object obj) throws Exception{
		
		ByteOutputStream bos = new ByteOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bos);
		oo.writeObject(obj);
		return bos.getBytes();
	}
	public static Object byteArrayToObject(byte[] bt) throws Exception{
		ByteInputStream bi  = new ByteInputStream(bt,bt.length);
		ObjectInputStream ois = new ObjectInputStream(bi);
		return ois.readObject();

	}
	
	
	
	public static void main(String[] args) {
		
		
	}
}
