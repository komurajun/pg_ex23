package kadai23;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Test;

public class RecordReaderTest {

	@Test
	public void readtest() throws Exception {
		RecordReader recordReader = new RecordReader(new StringReader(""));
		assertNull(recordReader.read());
	}

	@Test
	public void readtest2() throws Exception {
		RecordReader recordReader = new RecordReader(new StringReader(""));
		assertEquals("",recordReader.read());
	}

	@Test
	public void readtest3() throws Exception {
		RecordReader recordReader = new RecordReader(new StringReader("a"));
		assertNotNull(recordReader.read());
	}

}
