package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

	/** The id. */
	private String id;
	
	/** The disjprot. */
	private String disjprot;
	/*private String disjatend;
	private String seccondut;
	private String tipcondut;
	private String tipmedidr;
	private String tensnomin;
	private String consvener;
	private String consvpost;
	private String hastaterr;
	private String entrnorma;*/
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
		
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param id the id
	 * @param disjprot the disjprot
	 */
	public JavaBeans(String id, String disjprot) {
		super();
		this.id = id;
		this.disjprot = disjprot;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the disjprot.
	 *
	 * @return the disjprot
	 */
	public String getDisjprot() {
		return disjprot;
	}

	/**
	 * Sets the disjprot.
	 *
	 * @param disjprot the new disjprot
	 */
	public void setDisjprot(String disjprot) {
		this.disjprot = disjprot;
	}		
}
