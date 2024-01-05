package fr.martinbonnefoy.sql.parser.ast;

import java.util.Objects;

public class ColIdentifierNode extends Node {

	private String tableName;
	private String columnName;
	private String columnAlias;

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
	 * @return the columnName
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the columnAlias
	 */
	public String getColumnAlias() {
		return this.columnAlias;
	}

	/**
	 * @param columnAlias the columnAlias to set
	 */
	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.columnAlias, this.columnName, this.tableName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ColIdentifierNode)) {
			return false;
		}
		ColIdentifierNode other = (ColIdentifierNode) obj;
		return Objects.equals(this.columnAlias, other.columnAlias) && Objects.equals(this.columnName, other.columnName)
				&& Objects.equals(this.tableName, other.tableName);
	}

	@Override
	public String toString() {
		return (this.tableName != null ? this.tableName + "." : "") + this.columnName
				+ (this.columnAlias != null ? " AS " + this.columnAlias : "");
	}

}
