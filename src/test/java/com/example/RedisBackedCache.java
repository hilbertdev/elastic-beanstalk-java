package com.example;

import redis.clients.jedis.Jedis;

public class RedisBackedCache {

    private final Jedis jedis;

    public RedisBackedCache(String host, int port) {
        this.jedis = new Jedis(host, port);
    }

    /**
     * Stores a value in the cache with the given key.
     * 
     * @param key   The cache key.
     * @param value The value to store.
     */
    public void put(String key, String value) {
        jedis.set(key, value);
    }

    /**
     * Retrieves a value from the cache.
     * 
     * @param key The cache key.
     * @return The stored value, or null if not found.
     */
    public String get(String key) {
        return jedis.get(key);
    }

    /**
     * Deletes a value from the cache.
     * 
     * @param key The cache key.
     */
    public void delete(String key) {
        jedis.del(key);
    }

    /**
     * Clears the entire cache (useful for tests).
     */
    public void clear() {
        jedis.flushAll();
    }

    /**
     * Closes the Redis connection.
     */
    public void close() {
        jedis.close();
    }
}
