package fr.martinbonnefoy.sql.parser.ast;

import java.util.Objects;

public class TableNode extends Node {

	private String tableName;

	private String tableAlias;

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the tableAlias
	 */
	public String getTableAlias() {
		return this.tableAlias;
	}

	/**
	 * @param tableAlias the tableAlias to set
	 */
	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.tableAlias, this.tableName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TableNode)) {
			return false;
		}
		TableNode other = (TableNode) obj;
		return Objects.equals(this.tableAlias, other.tableAlias) && Objects.equals(this.tableName, other.tableName);
	}

	@Override
	public String toString() {
		return this.tableName + (this.tableAlias != null ? " AS " + this.tableAlias : "");
	}

}
