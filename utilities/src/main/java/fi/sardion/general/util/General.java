package fi.sardion.general.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/** <p>
 * A class for general utility functions.
 * </p>
 * <p>
 * <ul>
 * <li>Created: 22 Oct 2016 19.48.28</li>
 * <li>Project: Utilities</li>
 * <li>File: fi.sardion.general.util.General</li>
 * </ul>
 * </p>
 * @author Christopher Harper, account: chris
 * @version %version%
 * @since 0.0.1-SNAPSHOT-b35-22.10.2016 16:49:07.061
 *        (built by: chris) */
public class General implements Serializable {

	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 19.51.22</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>ALGORITHM = "SHA-256";</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b41-22.10.2016 18:33:51.271
	 *        (built by: chris) */
	public static final String			ALGORITHM				= "SHA-256";
	/** <p>
	 * A single day.
	 * <ul>
	 * <li>Created: 22 Oct 2016 21.37.26</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>DAY = {@link General}.{@link General#HOUR} * 24;</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b43-22.10.2016 18:42:35.234
	 *        (built by: chris) */
	public static final long			DAY						= General.HOUR * 24;
	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 19.52.42</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>EMPTY = "";</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b41-22.10.2016 18:33:51.271
	 *        (built by: chris) */
	public static final String			EMPTY					= "";																		//$NON-NLS-1$

	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 19.53.02</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>ENCODING_UTF_8 = "UTF-8"</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b41-22.10.2016 18:33:51.271
	 *        (built by: chris) */
	public static final String			ENCODING_UTF_8			= "UTF-8";																	//$NON-NLS-1$
	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 19.53.45</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>FINNISH_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss.SZ";</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b41-22.10.2016 18:33:51.271
	 *        (built by: chris) */
	public static final String			FINNISH_TIME_FORMAT		= "dd.MM.yyyy HH:mm:ss.SZ";													//$NON-NLS-1$

	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 21.39.52</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>FINNISH_TIME_FORMATTER = new ${@link SimpleDateFormat}({@link General}.{@link General#FINNISH_TIME_FORMAT});</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b43-22.10.2016 18:42:35.234
	 *        (built by: chris) */
	public static final DateFormat		FINNISH_TIME_FORMATTER	= new SimpleDateFormat(General.FINNISH_TIME_FORMAT);

	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 21.55.08</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>HOUR = {@link General}.{@link General#MINUTE} * 60</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b47-22.10.2016 19:04:14.335
	 *        (built by: chris) */
	public static final long			HOUR					= General.MINUTE * 60;
	/** <p>
	 * https://fi.wikipedia.org/wiki/ISO_8601
	 * <ul>
	 * <li>Created: 22 Oct 2016 21.56.49</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>ISO_8601_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b47-22.10.2016 19:04:14.335
	 *        (built by: chris) */
	public static final String			ISO_8601_TIME_FORMAT	= "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 21.57.40</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>ISO_8601_TIME_FORMATTER = new ${@link SimpleDateFormat}({@link General}.{@link General#ISO_8601_TIME_FORMAT});</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b47-22.10.2016 19:04:14.335
	 *        (built by: chris) */
	public static final DateFormat		ISO_8601_TIME_FORMATTER	= new SimpleDateFormat(General.ISO_8601_TIME_FORMAT);

	/** <p>
	 * <ul>
	 * <li>Created: 22 Oct 2016 22.00.39</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>LINEFEED = {@link System}.{@link System#getProperty(String) getProperty}("line.separator");</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b47-22.10.2016 19:04:14.335
	 *        (built by: chris) */
	public static final String			LINEFEED				= System.getProperty("line.separator");										//$NON-NLS-1$
	/** <p>
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.12.42</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>MINUTE = {@link General}.{@link General#SECOND} * 60;</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b49-23.10.2016 08:23:48.461
	 *        (built by: chris) */
	public static final long			MINUTE					= General.SECOND * 60;
	/** <p>
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.15.40</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>RANDOM = new {@link SecureRandom#SecureRandom(byte[]) SecureRandom}({@link String}.{@link String#valueOf(long) valueOf}({@link System}.{@link System#currentTimeMillis() currentTimeMillis}()).{@link String#getBytes() getBytes}());</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b49-23.10.2016 08:23:48.461
	 *        (built by: chris) */
	public static final SecureRandom	RANDOM					= new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes());

	/** <p>
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.25.00</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>SECOND = 1000;</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b53-23.10.2016 08:53:27.405
	 *        (built by: chris) */
	public static final long			SECOND					= 1000;

	/** <p>
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.25.29</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>WEEK = {@link General}.{@link General#DAY} * 7;</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b53-23.10.2016 08:53:27.405
	 *        (built by: chris) */
	public static final long			WEEK					= General.DAY * 7;

	/** <p>
	 * <ul>
	 * <li>Created: 26 Oct 2016 17.51.03</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>SPECIAL = </code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	final static char[]					SPECIAL					= new char[] { '!', '#', '$', '%', '&', '(', ')', '*', '+', '-', '/', ':',
			';', '=', '?', '@', '[', '\\', ']', '{', '|', '}' };
	/** <p>
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.27.04</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>LOGGER = {@link Logger}.{@link Logger#getLogger(Class) getLogger}({@link General}.class);</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b53-23.10.2016 08:53:27.405
	 *        (built by: chris) */
	private static final Logger			LOGGER					= Logger.getLogger(General.class);

	/** <p>
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.30.38</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>serialVersionUID = 258773577792476217L;</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b53-23.10.2016 08:53:27.405
	 *        (built by: chris) */
	private static final long			serialVersionUID		= 258773577792476217L;

	/** <p>
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.31.25</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * <li><code>SHA = </code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b53-23.10.2016 08:53:27.405
	 *        (built by: chris) */
	private static MessageDigest		SHA;

	/** <p>
	 * Initialise SHA.
	 * <ul>
	 * <li>Created: May 5, 2011 9:12:48 AM</li>
	 * <li>Author: Christopher Harper, account: dmadmin</li>
	 * <li><code> {@link General}.{@link General#SHA SHA} = {@link MessageDigest}.{@link MessageDigest#getInstance(String) getInstance}({@link General}.{@link General#ALGORITHM ALGORITHM});</code></li>
	 * </ul>
	 * </p>
	 * @since 0.0.1-SNAPSHOT-b53-23.10.2016 08:53:27.405
	 *        (built by: chris) */
	static {
		try {
			General.SHA = MessageDigest.getInstance(General.ALGORITHM); // $NON-NLS-1$
			General.LOGGER.debug(String.format("Istantiated messsage digest with %s algorithm.", General.ALGORITHM)); //$NON-NLS-1$
		} catch (final NoSuchAlgorithmException nsaex) {
			final String message = "Failed to istantiated messsage digest with SHA-256 algorithm."; //$NON-NLS-1$
			General.LOGGER.warn(message, nsaex);
			throw new RuntimeException(message, nsaex);
		}
	}

	/** <p>
	 * Get the amount of days between two days.
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.55.05</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param start
	 *            the start date.
	 * @param end
	 *            the end date
	 * @return the amount of days between the two dates.
	 * @since 0.0.1-SNAPSHOT-b55-23.10.2016 09:06:36.507
	 *        (built by: chris) */
	public static long daysBetween(final Calendar start, final Calendar end) {
		return (end.getTimeInMillis() - start.getTimeInMillis() + General.HOUR) / (General.HOUR * 24);
	}

	/** <p>
	 * Find a file in relation to three locations in the following order:
	 * <ol>
	 * <li>config_di as given withe the java argument
	 * <code>-Dconfig_dir=/xxx/yyy</code></li>
	 * <li>user.home as defined in java parameters.</code></li>
	 * <li>. the application execution directory.</li>
	 * </ul>
	 * <ol>
	 * <li>Created: 23 Oct 2016 11.56.03</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param fileSpec
	 *            the specification of the file to find.
	 * @return the file that was found first.
	 * @since 0.0.1-SNAPSHOT-b55-23.10.2016 09:06:36.507
	 *        (built by: chris) */
	public static final File findFile(final String fileSpec) {
		if (fileSpec == null || fileSpec.trim().length() <= 0) {
			General.LOGGER.debug("Attempt to find a file with null file spec."); //$NON-NLS-1$
		} else {
			General.LOGGER.debug(String.format("Attempting to find a file with %s file spec.", fileSpec)); //$NON-NLS-1$
			final List<String> variables = Arrays.asList(new String[] { "config_dir", "user.home", "." }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			for (final String variable : variables) {
				final File file = General.findFile(variable, fileSpec);
				if (file != null) {
					return file;
				}
			}
		}
		return null;
	}

	/** <p>
	 * Find a file in relation to the given location.
	 * <ul>
	 * <li>Created: 23 Oct 2016 11.57.10</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param location
	 *            where to look for the file. Location value is evaluated using
	 *            the following methods in this order:
	 *            <ol>
	 *            <li><code>{@link System}.{@link System#getenv(String) getenv}(location);</code></li>
	 *            <li><code>{@link System}.{@link System#getProperty(String) getProperty}(location);</code></li>
	 *            <li>location(/)fileSpec</li>
	 *            </ol>
	 * @param fileSpec
	 *            the file name and any parent directories.
	 * @return the found file.
	 * @since 0.0.1-SNAPSHOT-b55-23.10.2016 09:06:36.507
	 *        (built by: chris) */
	public static final File findFile(final String location, final String fileSpec) {
		if (location == null || location.trim().length() <= 0) {
			General.LOGGER.debug("Attempt to find a file with null location."); //$NON-NLS-1$
		} else if (fileSpec == null || fileSpec.trim().length() <= 0) {
			General.LOGGER.debug("Attempt to find a file with null file spec."); //$NON-NLS-1$
		} else {
			General.LOGGER.debug(String.format("Attempt to find a file with location %s and file spec %s.", location, fileSpec)); //$NON-NLS-1$
			/* Look for settings found under the location defined by config_dir,
			 * user.home and the current execution directory. */
			String temp = System.getenv(location);
			if (temp == null || temp.trim().length() == 0) {
				General.LOGGER.debug(String.format("No value found from the specified %s environment variable.", location)); //$NON-NLS-1$
				temp = System.getProperty(location);
			}
			if (temp == null || temp.length() == 0) {
				temp = location;
			}
			if (!temp.endsWith(File.separator) && !fileSpec.startsWith(File.separator)) {
				temp += File.separator;
			}
			temp += fileSpec;
			final File foundFile = new File(temp);
			if (foundFile.exists() && foundFile.isFile()) {
				General.LOGGER.debug(String.format("Returning file %s.", foundFile.getAbsolutePath())); //$NON-NLS-1$
				return foundFile;
			}
			General.LOGGER.debug(String.format("%s does not denote a file.", foundFile.getAbsolutePath())); //$NON-NLS-1$
		}
		return null;
	}

	/** <p>
	 * Get the checksum of a file.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.05.50</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param file
	 *            the file to check
	 * @return the base64 encoded string.
	 * @since 0.0.1-SNAPSHOT-b55-23.10.2016 09:06:36.507
	 *        (built by: chris) */
	public static final String getCheckSum(final File file) {
		try {
			final InputStream in = new FileInputStream(file);
			final byte[] buffer = new byte[1024];
			final MessageDigest digest = MessageDigest.getInstance("SHA-1"); //$NON-NLS-1$
			int readAmount = 0;
			while ((readAmount = in.read(buffer)) > -1) {
				digest.update(buffer, 0, readAmount);
			}
			in.close();
			return new String(Base64.encodeBase64(digest.digest()));
		} catch (final Exception ex) {
			final String message = String.format("Failed to create digest from file %s using SHA-1 algorithm.", file); //$NON-NLS-1$
			General.LOGGER.fatal(message, ex);
			throw new RuntimeException(message, ex);
		}
	}

	/** <p>
	 * Get the {@link General#ALGORITHM} digest for a given string.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.07.58</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param raw
	 *            the string whose digest needs to be returned.
	 * @return the digest.
	 * @since 0.0.1-SNAPSHOT-b57-23.10.2016 09:13:58.912
	 *        (built by: chris) */
	public static synchronized final String getDigest(final String raw) {
		try {
			final StringBuilder codeRaw;
			if (raw == null) {
				codeRaw = new StringBuilder();
			} else {
				codeRaw = new StringBuilder(raw.length() * 2);
				for (final char c : raw.toCharArray()) {
					codeRaw.append((int) c).append('-');
				}
			}
			General.SHA.reset();
			General.SHA.update(codeRaw.toString().getBytes(General.ENCODING_UTF_8));
			final String digest = new String(Base64.encodeBase64(General.SHA.digest()));
			General.LOGGER.debug(String.format("Generated digest %s from raw %s.", digest, "XXXXXXXXXX")); //$NON-NLS-1$ //$NON-NLS-2$
			return digest;
		} catch (final Throwable ueex) {
			final String message = String.format("Invalid encoding %s given.", General.ENCODING_UTF_8); //$NON-NLS-1$
			General.LOGGER.debug(message, ueex);
			throw new RuntimeException(message, ueex);
		}
	}

	/** <p>
	 * Get the duration from a given start time.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.10.20</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param start
	 *            the start time.
	 * @return the duration string in the following format [x week[s]] [x day[s]] xx:xx:xx.xxx.
	 * @since 0.0.1-SNAPSHOT-b57-23.10.2016 09:13:58.912
	 *        (built by: chris) */
	public static final String getDuration(final long start) {
		final long end = System.currentTimeMillis();
		return General.getDuration(start, end);
	}

	/** <p>
	 * TODO Write a method comment.
	 * <ul>
	 * <li>Created: 26 Oct 2016 18.47.25</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param start
	 *            the start time.
	 * @param end
	 *            the end time.
	 * @return the duration string in the following format [x week[s]] [x day[s]] xx:xx:xx.xxx.
	 * @since 0.0.1-SNAPSHOT-b77-26.10.2016 18:58:07.992
	 *        (built by: chris) */
	public static final String getDuration(final long start, final long end) {
		long temp = 0;
		final StringBuilder duration = new StringBuilder();
		if (end > start) {
			temp = end - start;
		} else {
			temp = start - end;
			duration.append('-');
		}
		if (temp >= General.WEEK) {
			final int count = (int) (temp / General.WEEK);
			duration.append(' ').append(count).append(" week"); //$NON-NLS-1$
			if (count > 1) {
				duration.append('s');
			}
			temp = temp % General.WEEK;
		}
		if (temp >= General.DAY || duration.length() > 1) {
			final int count = (int) (temp / General.DAY);
			duration.append(' ').append(count).append(" day"); //$NON-NLS-1$
			if (count > 1) {
				duration.append('s');
			}
			temp = temp % General.DAY;
		}
		int count = (int) (temp / General.HOUR);
		duration.append(' ').append(String.format("%02d", new Integer(count))).append(':'); //$NON-NLS-1$
		temp = temp % General.HOUR;
		count = (int) (temp / General.MINUTE);
		duration.append(String.format("%02d", new Integer(count))).append(':'); //$NON-NLS-1$
		temp = temp % General.MINUTE;
		count = (int) (temp / General.SECOND);
		duration.append(String.format("%02d", new Integer(count))).append('.'); //$NON-NLS-1$
		temp = temp % General.SECOND;
		duration.append(String.format("%03d", new Integer((int) temp)));
		return duration.toString().trim();
	}

	/** <p>
	 * Generate a 12 characters long password.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.12.06</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @return a generated password.
	 * @since 0.0.1-SNAPSHOT-b57-23.10.2016 09:13:58.912
	 *        (built by: chris) */
	public static String getGeneratedPassword() {
		return General.getGeneratedPassword(new BigInteger(130, General.RANDOM).toString(32));
	}

	/** <p>
	 * Generate a password of a given length.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.13.03</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param lenght
	 *            how long should the password be.
	 * @return the generated password.
	 * @since 0.0.1-SNAPSHOT-b57-23.10.2016 09:13:58.912
	 *        (built by: chris) */
	public static String getGeneratedPassword(final int lenght) {
		return General.getGeneratedPassword(new BigInteger(130, General.RANDOM).toString(32), lenght);
	}

	/** <p>
	 * Generate a password of 12 characters long.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.27.17</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param seed
	 *            from what should the password be generated from.
	 * @return the generated password.
	 * @since 0.0.1-SNAPSHOT-b59-23.10.2016 09:52:54.747
	 *        (built by: chris) */
	public static String getGeneratedPassword(final String seed) {
		return General.getGeneratedPassword(seed, 12);
	}

	/** <p>
	 * Generate a password which contains at least one special character from
	 * <code>'!', '#', '$', '%', '&', '(', ')', '*', '+', '-', '/', ':', ';', '=', '?', '@', '[', '\\', ']', '{', '|', '}'</code>, one upper
	 * case
	 * character from <code>ABCDEFGHIJKLMNOPQRSTUVWXYZ</code> and characters
	 * from the seed string appended with <code>new {@link BigInteger}(130,
	 * {@link General}.{@link General#RANDOM}).{@link BigInteger#toString(int) toString}(32)<code>.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.29.01</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param aSeed
	 *            the string from which random characters are used.
	 * @param length
	 *            how long the generated password will be. Minimum length is 6.
	 * @return the generated password.
	 * @since 0.0.1-SNAPSHOT-b59-23.10.2016 09:52:54.747
	 *        (built by: chris) */
	public static String getGeneratedPassword(final String aSeed, final int length) {
		if (length < 6) {
			throw new IllegalArgumentException(String.format("Given %s password length too short. The minimum lenght required is six (6).", //$NON-NLS-1$
					String.valueOf(length)));
		}
		final int half = length / 2 - 3;
		final StringBuilder password = new StringBuilder(length);
		General.RANDOM.nextInt(length > 12 ? 11 : length);
		int div = General.RANDOM.nextInt(4) + 1;
		for (int index = 0; index < length; index++) {
			final int mod;
			if (index > half && index < half + 6) {
				mod = index - half;
			} else {
				mod = (index + 1) % div;
			}
			switch (mod) {
				case 1:
					char c;
					if (aSeed == null) {
						final char[] letter = new char[] { General.SPECIAL[General.RANDOM.nextInt(General.SPECIAL.length)],
								(char) (General.RANDOM.nextInt(26) + 65), (char) (General.RANDOM.nextInt(26) + 97),
								(char) (General.RANDOM.nextInt(10) + 48) };
						c = letter[General.RANDOM.nextInt(letter.length)];
					} else {
						c = aSeed.charAt(General.RANDOM.nextInt(aSeed.length()));
					}
					password.append(c);
					break;
				case 2:
					password.append(General.SPECIAL[General.RANDOM.nextInt(General.SPECIAL.length)]);
					break;
				case 3:
					/* Lower case alphabet. */
					password.append((char) (General.RANDOM.nextInt(26) + 97));
					break;
				case 4:
					final char[] letter = new char[] { (char) (General.RANDOM.nextInt(26) + 65), (char) (General.RANDOM.nextInt(26) + 97),
							(char) (General.RANDOM.nextInt(10) + 48) };
					password.append(letter[General.RANDOM.nextInt(letter.length)]);
					break;
				case 5:
					/* Upper case alphabet. */
					password.append((char) (General.RANDOM.nextInt(26) + 65));
					break;
				default:
					/* A number */
					password.append((char) (General.RANDOM.nextInt(10) + 48));
					break;
			}
			if (div <= 1) {
				div = 5;
			} else {
				div--;
			}
		}
		return password.toString();
	}

	/** <p>
	 * Javadocs for {@link Map#hashCode()} state the following <i>"hash code of
	 * a map is defined to be the sum of the hash codes of each entry in the
	 * map's <tt>entrySet()</tt> view"</i>. This however is not sufficient for
	 * our purposes and we need the key values to be included into the hash
	 * calculation.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.35.30</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param map
	 *            whose hash value to return.
	 * @return the hash value of the keys and the values.
	 * @since 0.0.1-SNAPSHOT-b59-23.10.2016 09:52:54.747
	 *        (built by: chris) */
	public static Long getHash(final Map<String, Object> map) {
		return new Long(map.keySet().hashCode() + map.hashCode());
	}

	/** <p>
	 * Escape single quotes from a string.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.42.19</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param stringToEscape
	 *            what to work on.
	 * @return the escaped string.
	 * @since 0.0.1-SNAPSHOT-b59-23.10.2016 09:52:54.747
	 *        (built by: chris) */
	public static String singleQuoteEscape(final String stringToEscape) {
		if (stringToEscape == null || stringToEscape.length() == 0) {
			return stringToEscape;
		}
		return stringToEscape.replaceAll("'", "''"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/** <p>
	 * Check whether a map contains a given key.
	 * <ul>
	 * <li>Created: 23 Oct 2016 12.51.56</li>
	 * <li>Author: Christopher Harper, account: chris</li>
	 * </ul>
	 * </p>
	 * @param extraAttributes
	 *            a map of values.
	 * @param attributeName
	 *            the key name that must be found from the map with a valid
	 *            value.
	 * @since 0.0.1-SNAPSHOT-b59-23.10.2016 09:52:54.747
	 *        (built by: chris) */
	public static void validateRequired(final Map<String, Object> extraAttributes, final String attributeName) {
		if (extraAttributes.containsKey(attributeName)) {
			final Object data = extraAttributes.get(attributeName);
			if (data != null) {
				if (data instanceof String) {
					if (((String) data).trim().length() > 0) {
						return;
					}
				} else if (data instanceof List) {
					@SuppressWarnings({ "rawtypes", "unchecked" })
					final List<String> list = (List) data;
					if (list.size() > 0 && list.get(0).trim().length() > 0) {
						return;
					}
				}
			}
		}
		throw new IllegalArgumentException(String.format("The attribute %s is required to have a value.", attributeName)); //$NON-NLS-1$
	}
}
