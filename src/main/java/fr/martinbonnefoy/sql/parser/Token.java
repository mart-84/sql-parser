package fr.martinbonnefoy.sql.parser;

import java.util.Objects;

/**
 * A lexical Token produced during the lexical analysis.<br>
 * Represents a piece of text (value) assigned to a type.
 */
public class Token {

	/**
	 * The type of the Token
	 */
	private TokenType type;

	/**
	 * The value of the Token<br>
	 * The default value is an empty string.
	 */
	private String value = "";

	/**
	 * Creates a new Token with the given type.<br>
	 * The value of the token is set to an empty string.
	 * 
	 * @param type the type of the Token, must not be null
	 */
	public Token(TokenType type) {
		this.type = type;
	}

	/**
	 * Create a new Token with the given type and the given value.
	 * 
	 * @param type  the type of the Token, must not be null
	 * @param value the value of the Token, must not be null, can be an empty string
	 */
	public Token(TokenType type, String value) {
		this.type = type;
		this.value = value;
	}

	/**
	 * Returns the type of the Token.
	 * 
	 * @return the type
	 */
	public TokenType getType() {
		return this.type;
	}

	/**
	 * Sets the type of the Token.
	 * 
	 * @param type the type to set
	 */
	public void setType(TokenType type) {
		this.type = type;
	}

	/**
	 * Returns the value of the Token.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Sets the value of the Token.
	 * 
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.type, this.value);
	}

	/**
	 * The letter case of the value matters only if the type is case sensitive
	 *
	 * @see TokenType#isCaseSensitive()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Token)) {
			return false;
		}
		Token other = (Token) obj;
		if (this.type != other.type) {
			return false;
		}
		if (this.type.isCaseSensitive()) {
			return Objects.equals(this.value, other.value);
		} else {
			return this.value.equalsIgnoreCase(other.value);
		}

	}

	@Override
	public String toString() {
		return "<" + this.type + ": '" + this.value + "'>";
	}

}
