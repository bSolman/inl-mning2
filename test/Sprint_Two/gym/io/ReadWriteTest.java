package Sprint_Two.gym.io;

import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteTest {

    ReadWrite readWrite = new ReadWrite();

    @Test
    void testWriteToFile() throws IOException {
        readWrite.writeToFile("src/Sprint_Two/gym/testFile.txt", "hej\n");
        assertNotNull(readWrite.readFile("src/Sprint_Two/gym/testFile.txt").getLast());
    }

    @Test
    void testReadFileThrowsException(){
        assertThrows(FileNotFoundException.class, () -> {
            readWrite.readFile("src/Sprint_Two/gym/logg.tt");
        });
    }

    @Test
    void testReadFileLastPos() throws IOException {
        assertEquals("hej", readWrite.readFile("src/Sprint_Two/gym/testFile.txt").getLast());
    }
}