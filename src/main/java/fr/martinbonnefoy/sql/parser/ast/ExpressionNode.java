package fr.martinbonnefoy.sql.parser.ast;

import java.util.Objects;

public class ExpressionNode extends Node {

	public enum ExpressionType {
		COLUMN_IDENTIFIER, NUMERIC_LITERAL, STRING_LITERAL
	}

	private ExpressionType expressionType;

	private ColIdentifierNode columnIdentifier;

	private Double numericLiteral;

	private String stringLiteral;

	/**
	 * @param expressionType
	 */
	public ExpressionNode(ExpressionType expressionType) {
		this.expressionType = expressionType;
	}

	/**
	 * @return the expressionType
	 */
	public ExpressionType getExpressionType() {
		return this.expressionType;
	}

	/**
	 * @param expressionType the expressionType to set
	 */
	public void setExpressionType(ExpressionType expressionType) {
		this.expressionType = expressionType;
	}

	/**
	 * @return the columnIdentifier
	 */
	public ColIdentifierNode getColumnIdentifier() {
		return this.columnIdentifier;
	}

	/**
	 * @param columnIdentifier the columnIdentifier to set
	 */
	public void setColumnIdentifier(ColIdentifierNode columnIdentifier) {
		if (this.expressionType != ExpressionType.COLUMN_IDENTIFIER) {
			throw new IllegalStateException(
					"Cannot set column identifier when expression is of type " + this.expressionType);
		}
		this.columnIdentifier = columnIdentifier;
	}

	/**
	 * @return the numericLiteral
	 */
	public Double getNumericLiteral() {
		return this.numericLiteral;
	}

	/**
	 * @param numericLiteral the numericLiteral to set
	 */
	public void setNumericLiteral(Double numericLiteral) {
		if (this.expressionType != ExpressionType.NUMERIC_LITERAL) {
			throw new IllegalStateException(
					"Cannot set numeric literal when expression is of type " + this.expressionType);
		}
		this.numericLiteral = numericLiteral;
	}

	/**
	 * @return the stringLiteral
	 */
	public String getStringLiteral() {
		return this.stringLiteral;
	}

	/**
	 * @param stringLiteral the stringLiteral to set
	 */
	public void setStringLiteral(String stringLiteral) {
		if (this.expressionType != ExpressionType.STRING_LITERAL) {
			throw new IllegalStateException(
					"Cannot set string literal when expression is of type " + this.expressionType);
		}
		this.stringLiteral = stringLiteral;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.columnIdentifier, this.expressionType, this.numericLiteral, this.stringLiteral);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ExpressionNode)) {
			return false;
		}
		ExpressionNode other = (ExpressionNode) obj;
		return this.expressionType == other.expressionType
				&& Objects.equals(this.columnIdentifier, other.columnIdentifier)
				&& Objects.equals(this.numericLiteral, other.numericLiteral)
				&& Objects.equals(this.stringLiteral, other.stringLiteral);
	}

	@Override
	public String toString() {
		return switch (this.expressionType) {
		case COLUMN_IDENTIFIER -> this.columnIdentifier.toString();
		case NUMERIC_LITERAL -> this.numericLiteral.toString();
		case STRING_LITERAL -> "'" + this.stringLiteral + "'";
		};
	}

}
