package com.et.lesson05.xml;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;

import com.et.lesson05.JavaRedis;

import redis.clients.jedis.Jedis;

public class RedisCache implements Cache {
	Jedis jedis = new Jedis("localhost", 6379);
	private String cacheId;

	public RedisCache(String cacheId) {
		this.cacheId=cacheId;
	}

	public void clear() {
		jedis.flushDB();
	}

	public String getId() {
		return cacheId;
	}
/**
 * mybatis�Զ�����getObject ��������Ƿ����
 */
	public Object getObject(Object key) {
		try {
			byte [] bt = jedis.get(JavaRedis.objectToByteArray(key));
			if(bt==null){
				return null;
			}
			return JavaRedis.byteArrayToObject(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ReadWriteLock getReadWriteLock() {
		return new ReentrantReadWriteLock();
	}
/**
 * ���ᱻ����
 * ���ػ����еĸ���
 */
	public int getSize() {
		return 0;
	}

	/***
	 * mybatis ��ȡ����ʱ�������ݿ��ж�ȡ��������ͨ�� putObject���õ������� putObject���õ�������
	 */
	public void putObject(Object key, Object value) {
		// д��redis��
		try {
			jedis.set(JavaRedis.objectToByteArray(key), JavaRedis.objectToByteArray(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public Object removeObject(Object key) {
		Object object = getObject(key);
		try {
			jedis.del(JavaRedis.objectToByteArray(key));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

}
