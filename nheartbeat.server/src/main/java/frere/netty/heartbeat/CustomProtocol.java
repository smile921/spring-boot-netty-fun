/**
 * 
 */
package frere.netty.heartbeat;

import java.io.Serializable;

/**
 * @author frere
 *
 */
public class CustomProtocol implements Serializable {
	private static final long serialVersionUID = 4671171056588401542L;
	private long id;
	private String content;

	public CustomProtocol() { 
	}
	public CustomProtocol(long id, String content) {
		setId(id);
		setContent(content);
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}

