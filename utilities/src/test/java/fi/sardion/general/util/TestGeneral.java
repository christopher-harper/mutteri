package fi.sardion.general.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TestGeneral {

	private final Random RANDOM = new Random();

	/** <p>
	 * Check whether the days in between works.
	 * <ul>
	 * <li>Created: 24 Oct 2016 20.49.56</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b73-25.10.2016 14:34:26.383
	 *        (built by: chris) */
	@Test
	public void testDaysBetween() {
		final int between = this.RANDOM.nextInt(777);
		final Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DAY_OF_MONTH, -between);
		final Calendar now = Calendar.getInstance();
		final long actual = General.daysBetween(yesterday, now);
		Assert.assertEquals(String.format("It was expected for the result to be %s but was %s.", between, actual), between, actual);
	}

	/** <p>
	 * Get the duration string.
	 * <ul>
	 * <li>Created: 24 Oct 2016 21.02.29</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b73-25.10.2016 14:34:26.383
	 *        (built by: chris) */
	@Test
	public void testGetDuration() {
		final long end = System.currentTimeMillis();
		final long start = end - (General.WEEK * 2 + General.DAY * 3 + General.HOUR * 4 + General.MINUTE * 5 + General.SECOND * 6 + 7);
		final String temp = General.getDuration(start, end);
		Assert.assertEquals("Duration was expected to be '%s' but was '%s'.", "2 weeks 3 days 04:05:06.007", temp);
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 25 Oct 2016 17.56.54</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	@Test
	public void testGetGeneratedPassword() {
		this.testPassword(General.getGeneratedPassword(), 12, "");
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 25 Oct 2016 22.17.59</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	@Test
	public void testGetGeneratedPasswordInt() {
		final int length = this.RANDOM.nextInt(16) + 8;
		this.testPassword(General.getGeneratedPassword(length), length, "");
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 25 Oct 2016 22.17.53</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	@Test
	public void testGetGeneratedPasswordString() {
		final String seed = "åöäÅÖÄ";
		this.testPassword(General.getGeneratedPassword(seed), 12, seed);
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 25 Oct 2016 22.17.49</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	@Test
	public void testGetGeneratedPasswordStringInt() {
		final int length = this.RANDOM.nextInt(16) + 8;
		final String seed = "åöäÅÖÄ";
		this.testPassword(General.getGeneratedPassword(seed, length), length, seed);
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 26 Oct 2016 21.48.10</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	@Test
	public void testGetHash() {
		final Map<String, Object> map = new HashMap<>();
		map.put("JUnitTest", General.getGeneratedPassword());
		final long manualHash = new Long(map.keySet().hashCode() + map.hashCode()).longValue();
		final long utilHash = General.getHash(map);
		Assert.assertEquals("Failed to get the hash code of a map.", manualHash, utilHash);
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 26 Oct 2016 21.56.59</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	@Test
	public void testSingleQuoteEscape() {
		final String original = "O'leary";
		final String escaped = General.singleQuoteEscape(original);
		Assert.assertEquals("Escaped and expected strings did not match.", "O''leary", escaped);
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 26 Oct 2016 21.56.55</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	@Test
	public void testValidateRequired() {
		final Map<String, Object> required = new HashMap<>();
		required.put("key", Arrays.asList(new String[] { "value" }));
		General.validateRequired(required, "key");
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 25 Oct 2016 22.13.39</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param password
	 * @param aLenght
	 * @param aSeed
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	private void testPassword(final String password, final int aLenght, final String aSeed) {
		if (password.length() < aLenght) {
			Assert.fail(String.format("Failure validating password '%s'. It should be atleast %s characters long but in only %s.", password,
					aLenght, password.length()));
		}
		for (final char[] oneOfThese : new char[][] { aSeed.toCharArray(), General.SPECIAL,
				new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
				new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
						'w', 'x', 'y', 'z' },
				new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
						'W', 'X', 'Y', 'Z' } }) {
			boolean found = oneOfThese.length < 1;
			for (final char toBeFound : oneOfThese) {
				if (password.contains(String.valueOf(toBeFound))) {
					found = true;
					break;
				}
			}
			System.out.println(password);
			if (!found) {
				Assert.fail(String.format("Failure validating password '%s'. It should have atleast one character from '%s'.", password,
						String.valueOf(oneOfThese)));
			}
		}
	}

}
