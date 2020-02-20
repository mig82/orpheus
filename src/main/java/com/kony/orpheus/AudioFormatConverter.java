package com.kony.orpheus;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.kony.orpheus.helpers.FileHelper;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

public class AudioFormatConverter {
	//Supported file formats.
	//public final static String FORMAT_OGG = "ogg";
	public final static String FORMAT_MP3 = "mp3";
	public final static String FORMAT_WAV = "wav";
	public final static String FORMAT_AIFF = "aiff";

	//Codecs
	private final static String CODEC_OGG = "vorbis";

	private static final Integer BIT_RATE = 256000;//Minimal BIT_RATE only

	private static final Integer CHANNEL_MONO = 1; //1 for mono.
	private static final Integer CHANNEL_STEREO = 2; //2 for stereo.

	private static final Integer SAMPLING_RATE = 44100;//For good quality.

	//Data structures for the audio and Encoding attributes
	//private AudioAttributes audioAttr = new AudioAttributes();
	//private EncodingAttributes encoAttrs = new EncodingAttributes();
	//private Encoder encoder;

	/* Set the default attributes
	 * for encoding
	 */
	public AudioFormatConverter(){
		//TODO: Define constructor if any.
	}

	public static File convert(File source, File target) throws EncoderException {

		//Takes an audio WAV file and generates a 128 kbit/s, stereo, 44100 Hz MP3 file.
		//From: http://www.sauronsoftware.it/projects/jave/manual.php#1
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));

		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);

		Encoder encoder = new Encoder();

		System.out.println("Decoding formats : " + Arrays.toString(encoder.getSupportedDecodingFormats()));
		System.out.println("Audio decoders : " + Arrays.toString(encoder.getAudioDecoders()));
		System.out.println("Audio encoders : " + Arrays.toString(encoder.getAudioEncoders()));

		encoder.encode(source, target, attrs);
		return target;
	}

	public static void main(String[] args) throws IOException {
		File source = new File("source.wav");
		System.out.println("Source: " + source.getCanonicalPath());
		File target = new File("target.mp3");

		try {
			AudioFormatConverter.convert(source, target);
		} catch (EncoderException e) {
			System.out.println("Failed misserably");
			e.printStackTrace();
		}
	}
}
