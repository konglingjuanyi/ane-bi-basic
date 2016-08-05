package com.ane56.bi.port.adapter.utils;

import java.math.BigInteger;

public class IdGenerater {

	private final static long twepoch = 1464710400000L; // 2016/6/1
	private long worker;
	private long sequence = 0L;
	private final static long workerBits = 4L;
	private final static long maxWorker = -1L ^ -1L << workerBits;
	private final static long sequenceBits = 12L;
	private final static long workerShift = sequenceBits;
	private final static long timestampLeftShift = sequenceBits + workerBits;
	private final static long sequenceMask = -1L ^ -1L << sequenceBits;
	private long lastTimestamp = -1L;

	public IdGenerater() {
		this(0);
	}

	public IdGenerater(final long workerId) {
		super();
		if (workerId > maxWorker || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", maxWorker));
		}
		this.worker = workerId;
	}

	public synchronized long generateId() {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & sequenceMask;
			if (this.sequence == 0) {
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		} else {
			this.sequence = 0;
		}
		this.lastTimestamp = timestamp;
		long nextId = ((timestamp - twepoch << timestampLeftShift)) | (worker << workerShift) | (this.sequence);
		return nextId;
	}

	public synchronized String generate() {
		return BigInteger.valueOf(generateId()).toString(36);
	}

	public long asLongId(String id) {
		return new BigInteger(id, 36).longValue();
	}

	public long asTime(String id) {
		return time(asLongId(id));
	}

	private long tilNextMillis(final long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	public long time(long id) {
		return (id >> timestampLeftShift) + twepoch;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
		IdGenerater worker2 = new IdGenerater();
		long MAX = 1000000L;
		long t = System.currentTimeMillis();
		for (int i = 0; i < MAX; i++) {
			worker2.generateId();
		}

		System.out.println(System.currentTimeMillis() - t);
		System.out.println(MAX / (System.currentTimeMillis() - t));

	}

}
