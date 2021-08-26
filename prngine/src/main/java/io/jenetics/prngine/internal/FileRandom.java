package io.jenetics.prngine.internal;

import static java.util.Objects.requireNonNull;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.Enumeration;

import io.jenetics.prngine.PRNGSupport;
import io.jenetics.prngine.Random64;

public class FileRandom extends Random64 implements Closeable {
	private static final long serialVersionUID = 1L;

	private long _seed;

	private final DataInputStream _input;

	public FileRandom(final File dir) {
		_seed = PRNGSupport.seed();
		_input = new DataInputStream(new InfiniteInput(
			dir.listFiles((dir1, name) -> name.endsWith(".jpg"))
		));
	}

	public FileRandom() {
		this(new File("/home/fwilhelm/Workspace/Photos/Repository/print/200x/2007/Los Angeles - Maui/Maui"));
	}

	@Override
	public long nextLong() {
		try {
			return _seed = mix(_input.readLong(), _seed);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	private static long mix(final long a, final long b) {
		long c = a^b;
		c ^= c << 17;
		c ^= c >>> 31;
		c ^= c << 8;
		return c;
	}

	@Override
	public void close() throws IOException {
		_input.close();
	}
}

class InfiniteInput extends SequenceInputStream {

	static final class Inputs implements Enumeration<InputStream> {
		private final File[] _files;

		private boolean _open = true;
		private int _index = -1;

		Inputs(final File[] files) {
			_files = requireNonNull(files);
		}

		@Override
		public boolean hasMoreElements() {
			return _open;
		}
		@Override
		public InputStream nextElement() {
			_index = (_index + 1) % _files.length;
			//System.out.println(_index + ": " + _files[_index] + "(" + _files[_index].length()/1_000_000 + ")");
			try {
				return new BufferedInputStream(Files.newInputStream(_files[_index].toPath()));
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		}

		void close() {
			_open = false;
		}
	}

	private final Inputs _inputs;

	InfiniteInput(final Inputs inputs) {
		super(inputs);
		_inputs = inputs;
	}

	InfiniteInput(final File[] files) {
		this(new Inputs(files));
	}

	@Override
	public void close() throws IOException {
		_inputs.close();
		super.close();
	}

}
