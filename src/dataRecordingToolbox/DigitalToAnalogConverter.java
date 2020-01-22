/*
 * @package: dataRecordingToolbox
 * @file: DigitalToAnalogConverter.java
 * 
 * @author: Himanshu Babbar
 * 
 * Copyright (C) 2013. All rights reserved.
 */
package dataRecordingToolbox;

/**
 * The Class DigitalToAnalogConverter calculates voltage values corresponding to
 * the data bytes acquired.
 */
public class DigitalToAnalogConverter {

	/**
	 * Convert data to volts.
	 * 
	 * @param dataBytes
	 *            the data bytes
	 * @return the float[] containing the voltage values of the data
	 */
	public float[] convertDataToVolts(byte[] dataBytes) {

		float[] data = new float[(dataBytes.length / 2)];
		int dataIndex = 0;

		for (int i = 0; i < (dataBytes.length - 1); i += 2) {

			if (dataIndex == data.length) {
				dataIndex = 0;
			}

			byte[] sample = new byte[2];
			int sampleIndex = 0;

			sample[sampleIndex] = dataBytes[i];
			sample[sampleIndex + 1] = dataBytes[i + 1];

			int sampleInDecimal = convertBinarySampleToDecimal(convertDataSampleToBinary(sample));

			data[dataIndex] = convertDecimalSampleToVolt(sampleInDecimal);

			dataIndex++;
		}

		return data;

	}

	/**
	 * Convert data sample to binary.
	 * 
	 * @param sample
	 *            the data sample
	 * @return the byte[], binary value of the data sample
	 */
	private byte[] convertDataSampleToBinary(byte[] sample) {

		byte[] sampleInBinary = new byte[16];

		byte[] mostSigByte = new byte[(sampleInBinary.length / 2)];
		byte[] leastSigByte = new byte[(sampleInBinary.length / 2)];

		byte[] data = new byte[sample.length];

		for (int i = 0; i < data.length; i++) {
			if (sample[i] < 0) {
				data[i] = (byte) -(sample[i]);
			} else {
				data[i] = (byte) sample[i];
			}

		}

		int mostSigByteBit;
		int leastSigByteBit;

		for (mostSigByteBit = 0; mostSigByteBit < (sampleInBinary.length / 2); mostSigByteBit++) {
			mostSigByte[mostSigByteBit] = (byte) (data[0] % 2);
			data[0] >>= 1;
		}

		for (leastSigByteBit = 0; leastSigByteBit < (sampleInBinary.length / 2); leastSigByteBit++) {
			leastSigByte[leastSigByteBit] = (byte) (data[1] % 2);
			data[1] >>= 1;
		}

		if (sample[0] < 0) {
			convertToTwosComplement(mostSigByte);
		}

		if (sample[1] < 0) {
			convertToTwosComplement(leastSigByte);
		}

		mostSigByteBit = 0;
		leastSigByteBit = 0;
		for (int sampleBit = 0; sampleBit < sampleInBinary.length; sampleBit++) {

			if (sampleBit < (sampleInBinary.length / 2)) {
				sampleInBinary[sampleBit] = mostSigByte[mostSigByteBit];
				mostSigByteBit++;
			} else {
				sampleInBinary[sampleBit] = leastSigByte[leastSigByteBit];
				leastSigByteBit++;
			}

		}

		return sampleInBinary;

	}

	/**
	 * Convert to twos complement.
	 * 
	 * @param sampleByte
	 *            the sample byte
	 * @return the byte[], the 2's complement of the sample byte
	 */
	private byte[] convertToTwosComplement(byte[] sampleByte) {

		int bitsToChangeFrom = 0;

		for (int bit = 0; bit < sampleByte.length; bit++) {

			if (sampleByte[bit] == 1) {
				bitsToChangeFrom = bit + 1;
				break;
			}

		}

		while (bitsToChangeFrom < sampleByte.length) {

			if (sampleByte[bitsToChangeFrom] == 1) {
				sampleByte[bitsToChangeFrom] = 0;
			} else if (sampleByte[bitsToChangeFrom] == 0) {
				sampleByte[bitsToChangeFrom] = 1;
			}
			bitsToChangeFrom++;
		}

		return sampleByte;
	}

	/**
	 * Convert binary sample to decimal.
	 * 
	 * @param sample
	 *            the sample
	 * @return the decimal value of the data sample
	 */
	private int convertBinarySampleToDecimal(byte[] sample) {

		int decimal = 0;
		for (int i = 0; i < sample.length; i++) {
			decimal += (sample[i] << i);
		}
		return decimal;
	}

	/**
	 * Convert decimal sample to volt.
	 * 
	 * @param decimal
	 *            the decimal value of the data sample
	 * @return the voltage value of the data sample
	 */
	private float convertDecimalSampleToVolt(int decimal) {
		float volt = 0.0F;
		if (decimal <= 32767) {
			volt = (float) (decimal * (1 / 32768.0));
		} else if (decimal > 32767) {
			volt = (float) (decimal * (1 / 32768.0) - 2);
		}
		return volt;

	}
}
