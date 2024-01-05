package fr.martinbonnefoy.sql.parser.ast;

/**
 * Represent a Node of the Abstract Syntax Tree
 */
public abstract class Node {

	private static int lastId = 0;

	protected final int nodeId = ++lastId;

	/**
	 * @return the nodeId
	 */
	public int getNodeId() {
		return this.nodeId;
	}

	@Override
	public String toString() {
		return "AbstractNode [nodeId=" + this.nodeId + "]";
	}

}
