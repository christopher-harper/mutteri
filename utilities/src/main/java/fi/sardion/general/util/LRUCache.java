package fi.sardion.general.util;

import java.util.LinkedHashMap;
import java.util.Map;

/** <p>
 * Least recently used cache implementation.
 * </p>
 * <p>
 * <ul>
 * <li>Created: Jul 10, 2016 3:05:41 PM</li>
 * <li>Project: Utilities</li>
 * <li>File: fi.wn.general.util.LRUCache</li>
 * </ul>
 * </p>
 * @param <K>
 * @param <V>
 * @author Christopher Harper, account: chris
 * @version %version%
 * @since 0.0.1-SNAPSHOT-b23-22.10.2016 16:36:44.977 (built by: chris) */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	/** <p>
	 * <ul>
	 * <li>Created: Jan 14, 2016 8:59:24 AM</li>
	 * <li>Author: Christopher Harper, account: dmadmin</li>
	 * <li><code>serialVersionUID = -5069882379867312678L;</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b23-22.10.2016 16:36:44.977 (built by: chris) */
	private static final long	serialVersionUID	= -5069882379867312678L;
	/** <p>
	 * How many entries this cache will contain.
	 * <ul>
	 * <li>Created: Jul 10, 2016 3:05:22 PM</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>maxEntries = </code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b23-22.10.2016 16:36:44.977 (built by: chris) */
	private final int			maxEntries;

	/** <p>
	 * Constructor defining the maximum size of the cache.
	 * <ul>
	 * <li>Created: Jul 10, 2016 3:01:48 PM</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param theMax
	 *            the maximum cache size.
	 * @throws IllegalArgumentException
	 *             not thrown.
	 * @since 0.0.1-SNAPSHOT-b23-22.10.2016 16:36:44.977 (built by: chris) */
	public LRUCache(final int theMax) throws IllegalArgumentException {
		this(theMax / 2, theMax);
	}

	/** <p>
	 * Constructor for map with an initial size and maximum size of the cache.
	 * <ul>
	 * <li>Created: Jul 10, 2016 3:01:53 PM</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param initialSize
	 *            how big to create the cache initially.
	 * @param theMax
	 *            the maximum size of the cache.
	 * @throws IllegalArgumentException
	 *             if the max value is smaller than initial size.
	 * @since 0.0.1-SNAPSHOT-b23-22.10.2016 16:36:44.977 (built by: chris) */
	public LRUCache(final int initialSize, final int theMax) throws IllegalArgumentException {
		super(initialSize);
		this.maxEntries = theMax;
		if (this.maxEntries < initialSize) {
			throw new IllegalArgumentException(String.format("Initial size is %s which is greater than the allowed cache size %s.", //$NON-NLS-1$
					String.valueOf(initialSize), String.valueOf(this.maxEntries)));
		}
	}

	/** <p>
	 * Constructor where map is initialized with a already populated map and the maximum size of the map been constructed..
	 * <ul>
	 * <li>Created: Jul 10, 2016 3:02:01 PM</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param initialValues
	 *            the initial values.
	 * @param theMax
	 *            how much will this cache contain.
	 * @throws IllegalArgumentException
	 *             if there are more initial values than the maximum size of the cache is.
	 * @since 0.0.1-SNAPSHOT-b23-22.10.2016 16:36:44.977 (built by: chris) */
	public LRUCache(final Map<K, V> initialValues, final int theMax) throws IllegalArgumentException {
		super(initialValues);
		this.maxEntries = theMax;
		if (this.maxEntries < initialValues.size()) {
			throw new IllegalArgumentException(
					String.format("Initial values map size is %s which is greater than the allowed cache size %s.", initialValues.size(), //$NON-NLS-1$
							String.valueOf(this.maxEntries)));
		}
	}

	/** <p>
	 * Should the eldest entry be removed.
	 * <ul>
	 * <li>Created: Jul 10, 2016 3:02:19 PM</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param eldest
	 *            the eldest entry
	 * @return true if the eldest entry should be removed.
	 * @since 0.0.1-SNAPSHOT-b23-22.10.2016 16:36:44.977 (built by: chris)
	 * @see {@link LinkedHashMap#removeEldestEntry(Map.Entry<K, V>) removeEldestEntry}(final Map.Entry<K, V> eldest); */
	@Override
	protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
		return this.size() > this.maxEntries;
	}
}
