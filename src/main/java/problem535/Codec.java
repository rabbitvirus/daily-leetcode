package problem535;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class Codec {

    private static final String BASE_URL = "http://tinyurl.com/";

    private final AtomicLong seqGen = new AtomicLong(1);
    private final Map<String, String> shortToLongURLLookup = new HashMap<>();
    private final Map<String, String> longToShortURLLookup = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(final String longUrl) {
        if (longToShortURLLookup.containsKey(longUrl))
            return longToShortURLLookup.get(longUrl);

        final String shortUrl = BASE_URL + Long.toHexString(seqGen.getAndIncrement());
        shortToLongURLLookup.put(shortUrl, longUrl);
        longToShortURLLookup.put(longUrl, shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(final String shortUrl) {
        return shortToLongURLLookup.get(shortUrl);
    }

}
