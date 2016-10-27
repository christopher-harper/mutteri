package fi.sardion.general.util;

import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/** <p>
 * TODO: Write a brief description of the type here.
 * </p>
 * <p>
 * <ul>
 * <li>Created: 27 Oct 2016 20.38.39</li>
 * <li>Project: Utilities</li>
 * <li>File: fi.sardion.general.util.TestLRUCache</li>
 * </ul>
 * </p>
 * @author Christopher Harper, account: chris
 * @version %version%
 * @since %since% */
public class TestLRUCache {

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 27 Oct 2016 20.38.46</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since %since% */
	@Test
	public void testCache() {
		final Map<String, String> cache = new LRUCache<>(10);
		for (int index = 0; index < 50; index++) {
			cache.put(General.getGeneratedPassword(), General.getGeneratedPassword());
			if (cache.size() > 10) {
				Assert.fail(String.format("Cache size %s is greater that allowed cache size.", new Integer(cache.size())));
			}
		}
	}

}
