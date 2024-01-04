package fr.martinbonnefoy.sql.parser;

/**
 * Available types of tokens.<br>
 * Provides the list of keywords, symbols, and more
 */
public enum TokenType {

	// Keywords
	SELECT, FROM, WHERE, DISTINCT, AS, AND, OR,

	// Symbols
	COMMA, DOT, STAR, SEMICOLON, OPEN_PAREN, CLOSE_PAREN,

	// Operators
	COMPARISON_OP,

	// Others
	IDENTIFIER, NUMERIC_LIT, STRING_LIT(true);

	/**
	 * Indicates if the token is case sensitive or not
	 */
	private boolean caseSensitive = false;

	/**
	 * Creates a {@code TokenType} that is not case sensitive
	 */
	TokenType() {
		this.caseSensitive = false;
	}

	/**
	 * Creates a {@code TokenType} with the given case sensitivity
	 * @param caseSensitive Indicates if the token is case sensitive or not
	 */
	TokenType(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Returns whether the {@code TokenType} is case sensitive.
	 *
	 * @return true if the {@code TokenType} is case sensitive, false otherwise
	 */
	public boolean isCaseSensitive() {
		return this.caseSensitive;
	}

}
