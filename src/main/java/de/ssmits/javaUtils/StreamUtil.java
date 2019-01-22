package de.ssmits.javaUtils;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Utility Class with helper methods for the Java 8 Streaming API.
 *
 * @author Sascha Smits
 */
public class StreamUtil {
    private StreamUtil() {

    }

    /**
     * Maps the given list into a stream of chunked streams.
     *
     * @param list List to be sliced into chunked streams
     * @param chunkSize Size of each chunk
     * 
     * @return Stream of chunked streams
     * 
     * @see java.util.List
     * @see java.util.stream.Stream
     */
    public static final <T> Stream<Stream<T>> chunkedStream(List<T> list, int chunkSize) {
        if (list.size() <= chunkSize) {
            // No chunking required
            return Stream.of(list.stream());
        }

        final int size = list.size();
        final int fullChunks = (size - 1) / chunkSize;

        return IntStream
            .range(0, fullChunks + 1)
            .mapToObj(n -> list.subList(n * chunkSize, n == fullChunks ? size : (n + 1) * chunkSize).stream());
    }
}
