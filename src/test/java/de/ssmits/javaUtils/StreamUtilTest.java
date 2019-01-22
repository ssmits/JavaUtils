package de.ssmits.javaUtils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamUtilTest {
    @Test
    public void testChunkedStream() {
        // Given
        final List<String> testData = IntStream
            .range(0, 237)
            .mapToObj(i -> UUID.randomUUID().toString())
            .collect(Collectors.toList());

        // When
        final List<Stream<String>> result = StreamUtil
            .chunkedStream(testData, 100)
            .collect(Collectors.toList());

        assertThat(result).isNotNull();
        assertThat(result).hasSize(3);
        assertThat(result.get(0).count()).isEqualTo(100);
        assertThat(result.get(1).count()).isEqualTo(100);
        assertThat(result.get(2).count()).isEqualTo(37);
    }

    @Test
    public void testChunkedStream_noChunkingRequired() {
        // Given
        final List<String> testData = IntStream
            .range(0, 237)
            .mapToObj(i -> UUID.randomUUID().toString())
            .collect(Collectors.toList());

        // When
        final List<Stream<String>> result = StreamUtil
            .chunkedStream(testData, 237)
            .collect(Collectors.toList());

        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).count()).isEqualTo(237);
    }
}
